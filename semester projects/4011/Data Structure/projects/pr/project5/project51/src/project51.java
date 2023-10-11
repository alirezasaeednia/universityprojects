import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.Scanner;

public class project51 {

    public static void main(String[] args) {
        try {

            System.out.println("what do you want to do?");
            System.out.println("insert a new node right hand side the main root--->1");
            System.out.println("derakhte nakhi !!----->2");
            Scanner myScanner=new Scanner(System.in);
            if(myScanner.nextInt()==2){
                BinaryTree bt = new BinaryTree();
                BinaryTree.TreeNode root = new BinaryTree.TreeNode("A");
                bt.root = root;
                bt.root.left = new BinaryTree.TreeNode("B");
                bt.root.left.left = new BinaryTree.TreeNode("C");

                bt.root.left.right = new BinaryTree.TreeNode("D");
                bt.root.right = new BinaryTree.TreeNode("E");
                bt.root.right.left=new BinaryTree.TreeNode("K");
                bt.root.right.right = new BinaryTree.TreeNode("F");

                printbst("",root,false);

                // visitng nodes in preOrder traversal

                String a=bt.preOrder(root);
                System.out.println(BinaryTree.s);

                BinaryTree.derakhteNakhi(root,root);
                BinaryTree.printtt(root);
                System.exit(0);
            }
            else{
                System.out.println("What character to inter after A?");
                BinaryTree bt = new BinaryTree();
                BinaryTree.TreeNode root = new BinaryTree.TreeNode("A");
                bt.root = root;
                bt.root.left = new BinaryTree.TreeNode("B");
                bt.root.left.left = new BinaryTree.TreeNode("C");

                bt.root.left.right = new BinaryTree.TreeNode("D");
                bt.root.right = new BinaryTree.TreeNode("E");
                bt.root.right.left=new BinaryTree.TreeNode("K");

                bt.root.right.right = new BinaryTree.TreeNode("F");

                printbst("",root,false);
                String s=myScanner.next();
                BinaryTree.TreeNode temp=bt.root.right;

                bt.root.right=new BinaryTree.TreeNode(s);
                bt.root.right.right=temp;
                printbst("",root,false);

            }
        }catch (Exception e){

        }




    }
    public static void printbst(String prefix, BinaryTree.TreeNode n, boolean isLeft) {
        if (n != null) {
            printbst(prefix + "     ", n.right, false);
            System.out.println (prefix + ("|-- ") + n.data);
            printbst(prefix + "     ", n.left, true);
        }
    }
}



class BinaryTree {
        public static String s ="";
        public static String s2 ="";


    static class TreeNode {
            Boolean isRight;
            Boolean isLeft;
            String data;
            TreeNode left, right;
            TreeNode nakhechap,nakherast;

        @Override
        public String toString() {
            return "TreeNode{" +
                    "isRight=" + isRight +
                    ", isLeft=" + isLeft +
                    ", data='" + data + '\'' +
                    ", left=" + left +
                    ", right=" + right +

                    '}';
        }

        TreeNode(String value) {
                this.data = value;
                left = right = null;
            }

            boolean isLeaf() {
                return left == null ? right == null : false;
            }

        }

        public static void printtt(TreeNode treeNode){
            if (treeNode != null)
            {
                System.out.println(treeNode.toString());
                if(treeNode.nakherast!=null)
                    System.out.print("nakherast=" +treeNode.nakherast.toString());

                if(treeNode.nakhechap!=null)
                    System.out.print("nakhechap=" +treeNode.nakhechap.toString());
                printtt(treeNode.left);
                printtt(treeNode.right);
            }
        }
        TreeNode root;

        public String preOrder(TreeNode node) {
            if (node == null) {
                return "";
            }
            s+=node.data;
            preOrder(node.left);
            preOrder(node.right);
            return s.replaceAll(" ", "");
        }

        public void preOrder() {
            preOrder(root);
        }


        public static void derakhteNakhi(TreeNode root, TreeNode rooteasli){

            if (root != null)
            {
                s2=root.data;
                derakhteNakhi(root.left,rooteasli);
                derakhteNakhi(root.right,rooteasli);
            }
            else{
                TreeNode node=ifNodeExists(rooteasli,s2);
                if(node.left==null){
                    node.isLeft=true;
                    if(s.indexOf(s2)-1==-1){
                        node.nakhechap=rooteasli;
                    }
                    else{
                       node.nakhechap=ifNodeExists(rooteasli, String.valueOf(s.charAt(s.indexOf(s2)-1)));
                   }
                }

                if(node.right==null){
                    node.isRight=true;
                    if(s.indexOf(s2)+1==s.length()){
                        node.nakherast=rooteasli;
                    }
                    else{
                        node.nakherast=ifNodeExists(rooteasli, String.valueOf(s.charAt(s.indexOf(s2)+1)));

                    }
                }

            }

        }
        static TreeNode founded;

        static TreeNode  ifNodeExists( TreeNode node, String key)
        {
            if(node != null){
                if(node.data.equals(key)){
                    return node;
                } else {
                    TreeNode foundNode = ifNodeExists(node.left,key );
                    if(foundNode == null) {
                        foundNode = ifNodeExists(node.right, key);
                    }
                    return foundNode;
                }
            } else {
                return null;
            }


            // node is not found in left,
            // so recur on right subtree /

        }

    }


