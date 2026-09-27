import java.util.ArrayList;

public class BinaryTreesB {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;

        }

    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;

        }

        public static void treeTraversal(Node root) {
            if (root == null) {
                System.out.print(" -1");
                return;
            }
            System.out.print(root.data + " ");

            treeTraversal(root.left);
            treeTraversal(root.right);

        }

        public static void inorderTraversal(Node root) {
            if (root == null) {
                return;
            }
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);

        }

        public static void postOrder(Node root) {
            if (root == null)
                return;
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");

        }

        public static boolean getPath(Node root, int n, ArrayList<Node> path) {
            if (root == null) {
                return false;
            }
            path.add(root);
            if (root.data == n) {
                return true;
            }
            boolean leftFound = getPath(root.left, n, path);
            boolean rightFound = getPath(root.right, n, path);

            if (leftFound || rightFound) {
                return true;
            }

            path.remove(path.size() - 1);
            return false;

        }

        public static Node lca(Node root, int n1, int n2) {

            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();

            getPath(root, n1, path1);
            getPath(root, n2, path2);
            int i = 0;
            for (; i < path1.size() && i < path2.size(); i++) {
                if (path1.get(i) != path2.get(i)) {
                    break;
                }

            }
            Node lca = path1.get(i - 1);
            return lca;

        }

        public static Node lca2(Node root, int n1, int n2) {
            if (root == null) {
                return null;
            }
            if (root.data == n1 || root.data == n2) {
                return root;
            }

            Node leftLca = lca2(root.left, n1, n2);
            Node rightLca = lca2(root.right, n1, n2);

            if (leftLca == null) {
                return rightLca;
            }
            if (rightLca == null) {
                return leftLca;
            }

            return root;
        }

        // MINIMUM DISTANCE BETWEEN NODES

        public static int lcaDis(Node root, int n) {
            if (root == null) {
                return -1;
            }
            if (root.data == n) {
                return 0;
            }
            int leftDis = lcaDis(root.left, n);
            int rightDis = lcaDis(root.right, n);

            if(leftDis==-1 && rightDis==-1){
                return -1;
            }
            else if(leftDis==-1)  return rightDis+1;
            else {return leftDis+1;}


   

        }

public  static int minDis(Node root , int n1, int n2){
    Node lca1 = lca2(root, n1, n2);
    int dis1 = lcaDis(lca1 , n1);
    int dis2= lcaDis(lca1, n2);

    return dis1+dis2;



    if(root.data==n1 )

}
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1, 0 };
        BinaryTree bt = new BinaryTree();
        Node root = bt.buildTree(nodes);

        Node res = bt.lca2(root, 4, 5);
        System.out.print(res.data);

    }

}