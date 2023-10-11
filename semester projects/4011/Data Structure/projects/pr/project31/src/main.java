import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter the String");
        String s1 = myScanner.next();
        System.out.println("here's your list of characters:" +findCharacters(s1));
        if(isPostFix(s1)){
            s1=givingNumbers(s1,findCharacters(s1),myScanner);
            arzyabi(s1);
        }
        else if(isPrefix(s1)){
            s1=prefixToPostfix(s1);
            s1=givingNumbers(s1,findCharacters(s1),myScanner);
            arzyabi(s1);
        }
        else{
            s1=infixToPostfix(s1);
            s1=givingNumbers(s1,findCharacters(s1),myScanner);
            arzyabi(s1);
        }

    }

    public static HashSet<String>findCharacters(String s){
        HashSet<String>h=new HashSet<>();
        String patternString = "\\w";

        Pattern pattern = Pattern.compile(patternString);

        Matcher matcher = pattern.matcher(s);
        while(matcher.find()){
            h.add(matcher.group());
        }
        return h;
    }

    public static boolean isPrefix(String s) {
        String s2=s.substring(0, 2);
        if(s2.matches("\\W\\W")){
            System.out.println("its a prefix");
            return true;
        }
        return false;
    }


    public static boolean isPostFix(String s) {
        String s2=s.substring(0, 2);
        if(s2.matches("\\w\\w")){
            System.out.println("its a postfix");
            return true;
        }
        return false;
    }

    public static String prefixToPostfix(String s1) {
        Stack<String> s=new Stack<>();
        String res1= "";
        int n=s1.length();
        for(int i=n-1;i>=0;i--)
        {
            char c=s1.charAt(i);
            if(isCharacter(c))
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
        return res1;
    }

    public static String givingNumbers(String s1, HashSet h,Scanner myScanner){
        String[] myString = (String[]) h.toArray(new String[h.size()]);
        for (int i=0;i<h.size();i++){
            System.out.println("What variable you want to give to "+myString[i]+" ?");
            String myNeeds=myScanner.next();
            s1=s1.replaceAll(myString[i],myNeeds);
        }
        System.out.println(s1);
        return s1;
    }

    public static boolean isCharacter(char c)
    {
        return ((c >= 'a' && c <= 'z') || (c >='A' && c <='Z'));
    }

    static String infixToPostfix(String s1)
    {
        StringBuilder result = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s1.length(); ++i) {
            System.out.println(stack);
            char c = s1.charAt(i);
            if (Character.isLetterOrDigit(c)) // agar amalvand bud ezafe be khuruji mostaghiman
                result.append(c);
            else if (c == '(')         //agar ( bud ezafe be poshte
                stack.push(c);
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') { //ta residan be avalin parantes baz mibarim toye khuruji parantez baz ro az poshte hazf mikonim
                    result.append(stack.peek());
                    stack.pop();
                }

                stack.pop();
            }
            else // pas amalgar didim
            {
               while (!stack.isEmpty() && priority(c) <= priority(stack.peek())) { // poshte khali bud ke mizarim age payintar bud balaye poshte ro mifrestim khuruji va jadidaro mizarim
                    result.append(stack.peek());
                    stack.pop();
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            result.append(stack.peek());
            stack.pop();
        }

        return result.toString();
    }

    public static String arzyabi(String s1){ //tebghe slide raftam
        Stack<Integer>s=new Stack<>();
        String org="";
        for(int i=0;i<s1.length();i++){
            if(String.valueOf(s1.charAt(i)).matches("\\w")){
                s.push(Integer.valueOf(String.valueOf(s1.charAt(i))) );
            }
            else{
                s=isAmalgar(s1, s, i);
            }
        }
        org=String.valueOf(s.pop());
        System.out.println(org);
        return org;
    }

    private static Stack<Integer> isAmalgar(String s1, Stack<Integer> s, int i) {
        if(s1.charAt(i)=='/'){
            int number1= s.pop();
            int number2= s.pop();
            int number3=number2/number1;
            s.push(number3);
            return s;
        }
        else if(s1.charAt(i)=='*'){
            int number1= s.pop();
            int number2= s.pop();
            int number3=number2*number1;
            s.push(number3);
            return s;
        }
        else if(s1.charAt(i)=='+'){
            int number1= s.pop();
            int number2= s.pop();
            int number3=number2+number1;
            s.push(number3);
            return s;
        }
        else if(s1.charAt(i)=='-'){
            int number1= s.pop();
            int number2= s.pop();
            int number3=number2-number1;
            s.push(number3);
            return s;
        }
        return s;
    }

    static int priority(char ch)
    {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

}
