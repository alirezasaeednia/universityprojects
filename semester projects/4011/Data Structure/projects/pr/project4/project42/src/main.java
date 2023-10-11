import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class main {
    public class Node {


        @Override
        public String toString() {
            return "Node{" + "moadel=" + moadel + ", name=\n\n'"
                    + name + '\'' + ", reshte=" + reshte + ", tedadVahed=\n" + tedadVahed;
        }

        double moadel;
        String name;
        Reshte reshte;
        double tedadVahed;
        Node next;
        Node prev;
        public Node(double moadel, String name, Reshte reshte, double tedadVahed) {
            this.moadel =  moadel;
            this.name = name;
            this.reshte = reshte;
            this.tedadVahed = tedadVahed;
        }

        public Node() {
        }
    }

        public  Node add(double moadel,String name,Reshte reshte,double tedadVahed,Node prev){
          Node newNode = new Node(moadel,name,reshte,tedadVahed);
          if(head.next==null){
              head.prev=null;
              head.next=newNode;
              newNode.prev=head;
              return newNode;
          }
          else{
               prev.next=newNode;
               newNode.prev=prev;
               return newNode;
          }
        }

        public void display() {
            Node current = head;
            System.out.println("Nodes of the circular linked list: ");
            do{
                System.out.print( current.toString());
                current = current.next;
            }while(current != null);
            return;
        }
        public  Node head=new Node(0,"",null,0) ;


        public static void main(String[] args) throws IOException {
            try {
                main cl=new main();
                Random moad=new Random(20);
                FileReader fileReader=new FileReader("src/names.txt");
                BufferedReader bufferedReader=new BufferedReader(fileReader);
                Reshte reshte;
                ArrayList<Reshte>arrayList=new ArrayList<>();
                arrayList.add(Reshte.BARGH);
                arrayList.add(Reshte.COMPUTER);
                arrayList.add(Reshte.ENSANI);
                arrayList.add(Reshte.HONAR);
                arrayList.add(Reshte.MEMARI);
                arrayList.add(Reshte.PHYISIC);
                arrayList.add(Reshte.SHIMI);
                arrayList.add(Reshte.TAJROBI);
                Random resht=new Random(7);
                Random vahed=new Random(24);
                String[]s=new String[100];
                for(int i=0;i<100;i++){
                    s[i]=bufferedReader.readLine();
                }
                Random name=new Random();
                Node nnn=cl.add(moad.nextInt(0,20), s[name.nextInt(100)],arrayList.get(resht.nextInt(0,7)),vahed.nextInt(0,24), cl.head);

                for(int i=0;i<99;i++){
                    nnn=cl.add(moad.nextInt(0,20), s[name.nextInt(100)],arrayList.get(resht.nextInt(0,7)),vahed.nextInt(0,24), nnn);
                }
                //cl.display();
                bufferedReader.close();
                cl.display();
            }

            catch (Exception e){

            }


        }
    }




