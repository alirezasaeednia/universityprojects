import java.util.Scanner;

public class main {
    static int count=0;
    public static void main(String[] args) {
        Scanner myScanner=new Scanner(System.in);
        int b=myScanner.nextInt();
        int a=myScanner.nextInt();
        System.out.println(comb(a,b));
        System.out.println(count);
    }

    public static int comb(int n,int k){
        if(k>n||k<0){
            return 0;
        }
        count++;
        if(n==k||k==0){
            return 1;
        }
        else{
            return comb(n-1,k-1)+comb(n-1,k);
        }
    }
}
