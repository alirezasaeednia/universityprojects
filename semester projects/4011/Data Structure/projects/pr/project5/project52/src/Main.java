// Java program to implement optimized delete in BST.
import java.util.*;

class Main {

    static class Node {
        int key;
        Node left, right;
    }

    static Node newNode(int item)
    {
        Node temp = new Node();
        temp.key = item;
        temp.left = temp.right = null;
        return temp;
    }



    static Node insert(Node node, int key)
    {

        if (node == null)
            return newNode(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else
            node.right = insert(node.right, key);

        return node;
    }

    static Node deleteNode(Node root, int k)
    {

        if (root == null)
            return root;

        if (root.key > k) {
            root.left = deleteNode(root.left, k);
            return root;
        }
        else if (root.key < k) {
            root.right = deleteNode(root.right, k);
            return root;
        }


        if (root.left == null) {
            Node temp = root.right;
            return temp;
        }
        else if (root.right == null) {
            Node temp = root.left;
            return temp;
        }

        else {
            Node succParent = root;

            Node succ = root.right;

            while (succ.left != null) {
                succParent = succ;
                succ = succ.left;
            }

            if (succParent != root)
                succParent.left = succ.right;
            else
                succParent.right = succ.right;

            root.key = succ.key;

            return root;
        }
    }

    // Driver Code
    public static void main(String args[])
    {


        Node root = null;
        root = insert(root, 50);
        root = insert(root, 30);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 70);
        root = insert(root, 60);
        root = insert(root, 80);

        print("",root,false);
        root = deleteNode(root, root.right.key);
        System.out.println("Inorder traversal of the "
                + "modified tree");
        print("",root,false);
    }

    public static void print(String prefix, Node n, boolean isLeft) {
        if (n != null) {
            print(prefix + "     ", n.right, false);
            System.out.println (prefix + ("|-- ") + n.key);
            print(prefix + "     ", n.left, true);
        }
    }
}

