import java.util.Scanner;

public class main {

    static Node first = null;

    public static class Node {
        int row;
        int col;
        int data;
        Node next;
    };

    public static void main(String[] args)
    {        Scanner s=new Scanner(System.in);

        System.out.println("how many rows");
        int rows=s.nextInt();
        System.out.println("how many colums");
        int col=s.nextInt();
        int[][] sparseMatrix=new int[rows][col];
        for(int i=0;i<rows;i++){
        for(int j=0;j<col;j++){
            sparseMatrix[i][j]=s.nextInt();
        }
    }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                if (sparseMatrix[i][j] != 0) {
                    create_new_node(i, j,
                            sparseMatrix[i][j]);
                }
            }
        }
        printList(first);
    }

    private static void create_new_node(int row_index, int col_index, int x)
    {
        Node temp = first;
        Node r;
        if (temp == null) {
            temp = new Node();
            temp.row = row_index;
            temp.col = col_index;
            temp.data = x;
            temp.next = null;
            first = temp;
        }

        else {
            while (temp.next != null)
                temp = temp.next;

            r = new Node();
            r.row = row_index;
            r.col = col_index;
            r.data = x;
            r.next = null;
            temp.next = r;
        }
    }


    public static void printList(Node start)
    {
        Node ptr = start;
        System.out.print("row_position:");
        while (ptr != null) {
            System.out.print(ptr.row + " ");
            ptr = ptr.next;
        }
        System.out.println("");
        System.out.print("column_position:");

        ptr = start;
        while (ptr != null) {
            System.out.print(ptr.col + " ");
            ptr = ptr.next;
        }
        System.out.println("");
        System.out.print("Value:");
        ptr = start;

        while (ptr != null) {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
    }
}
