public class BST {
    static class Node {
        int data;
        Node right;
        Node left;

        public Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;

        }
    }

    static int idx = -1;

    public static Node insert(Node root, int val) {

        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data < val) {
            root.right = insert(root.right, val);

        } else {
            root.left = insert(root.left, val);
        }
        return root;

    }

    public static void inorder(Node root) {
        if (root == null) {

            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);

    }

    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (key == root.data) {
            return true;
        }
        if (root.data > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }

    }
    //Inorder successor
    public static Node findInOrderSuccessor(Node root){
        while(root.left!=null){
            root= root.left;
        }
        return root;
    } 

    //deletion of node

    public static Node delete(Node root,int val){
        if(root.data>val){
            root.left=delete(root.left, val);
        }
        else if(root.data<val){
            root.right=delete(root.right, val);
        }
        else{
            //case 1 leaf node
            if(root.left==null && root.right==null){
                return null;
            } 
            //case 2 one child
            if(root.left==null){
                return root.right;
            } else if(root.right ==null){
                return root.left;
            }

            //case 3 
            Node IS=findInOrderSuccessor(root.right);
            root.data= IS.data;
            root.right=delete(root.right, IS.data);

        }
        return root;
    }
    //print in range
    public static void printInRange(Node root,int k1,int k2){
        if(root==null){
            return;
        }
        if(root.data>=k1 && root.data<=k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);

        } else if(root.data<k1){
            printInRange(root.left, k1, k2);
        }
        else{
            printInRange(root.right, k1, k2);

        }
    }

    public static void main(String[] args) {
        int values[] = { 5, 1, 3, 4, 2, 7 };

        Node root = null;
        for (int val : values) {
            root = insert(root, val);
        }

        inorder(root);
        boolean isFound = search(root, 1);
        if (isFound) {
            System.out.println("Found");

        } else {
            System.out.println("Not Found");

        }
        root = delete(root, 3);
            System.out.println();
    
        inorder(root);
    }
}