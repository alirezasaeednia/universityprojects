import java.util.Scanner;
import java.util.Stack;

public class main {
    public static void main(String[] args) {
        Scanner myScanner=new Scanner(System.in);
        System.out.println("enter ");
        prefixToPostfix(myScanner.next());
    }
    public static String prefixToPostfix(String s1) {
        Stack<String> s=new Stack<>();
        String res1= "";
        int n=s1.length();
        for(int i=n-1;i>=0;i--)
        {
            char c=s1.charAt(i);
            if(Character.isLetterOrDigit(c))
            {
                s.push(c+"");
            }
            else
            {
                String a=s.pop();
                String b=s.pop();
                res1=a+b+c;
                s.push(res1);
            }
            System.out.println(s);

        }
        System.out.println(res1);
        return res1;
    }
}
