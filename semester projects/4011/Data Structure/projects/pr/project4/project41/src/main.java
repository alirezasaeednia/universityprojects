import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class main {
    public class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }


        public Node() {
        }
    }

    public  Node head=new Node(0) ;
    public  Node tail = head;

    public void add(int data){
        Node newNode = new Node(data);
            //tail will point to new node.
            tail.next = newNode;
            //New node will become new tail.
            tail = newNode;
            tail.next = head;

    }

    //Displays all the nodes in the list
    public void display() {
        Node current = head;
        System.out.println("next data after tail is " +tail.next.data);


            System.out.println("Nodes of the circular linked list: ");
            do{
                System.out.print(" "+ current.data);
                current = current.next;
            }while(current != head);
            System.out.println();
    }

    public static int findMin(Node head){
        int a=head.next.data;
        Node cur=head.next;
        while(cur!=head){
            if(a<cur.data){
                cur=cur.next;
            }
            else{
                a=cur.data;
                cur=cur.next;
            }
        }
        System.out.println();
        return a;
    }

    public static void main(String[] args) {
        try {
            Scanner myScanner=new Scanner(System.in);
            main cl = new main();
            System.out.println("how many numbers do you want to enter?");
            int many=myScanner.nextInt();
            if(many==0){
                System.out.println("list is empty but there is gere rasi");
                System.exit(0);
            }
            for(int i=0;i<many;i++){
                cl.add(myScanner.nextInt());
            }
        System.out.println("min value is "+findMin(cl.head));
            searchAddress(findMin(cl.head), cl.head);
        cl.display();
        }
        catch (Exception e){

        }
    }

    public static void searchAddress(int a,Node head){
        Node cur=head.next;
        while(cur!=head){
            if(a==cur.data){
                System.out.println("address of the min value is "+cur);
                return;
            }
            else{
                cur=cur.next;
            }
        }
    }
}
