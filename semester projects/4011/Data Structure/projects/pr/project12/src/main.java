import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner myScanner=new Scanner(System.in);
        int a =myScanner.nextInt();
        System.out.println(findK(a,0));

    }
    public static int findK(int n,int i){
        if(n<=Math.pow(3, i)){
            return 0;
        }
        return 1+findK(n, i+1);
    }
}
