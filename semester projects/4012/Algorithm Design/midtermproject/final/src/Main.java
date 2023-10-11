import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int howMany = scanner.nextInt();
            if(howMany==1){
                System.out.print("0");
                System.exit(0);
            }
            if(howMany==2){
                System.out.println("0 + 1");
                System.exit(0);
            }

        Random random = new Random();
        int randomizer_honest=random.nextInt(howMany/2+1, howMany+1);
        int [] arrayOfKnight=new int[howMany];
        while(randomizer_honest!=0){
            int rand=random.nextInt(howMany);
            arrayOfKnight[rand]=1;
            randomizer_honest--;
        }
        System.out.println(Arrays.toString(arrayOfKnight));
        recursion(arrayOfKnight, 0, arrayOfKnight.length-1);
    }
    public static void recursion(int[]array,int begin,int end){
        int mid=(end+begin)/2;

        if(end-begin+1==2){
            if(array[begin]==1&&array[end]==1){
                System.out.print(begin+" "+end+" ");
                return;
            }
            else if(array[begin]==1&&array[end]==0){
                System.out.print(begin+" ");
                return;
            }
            else if(array[begin]==0&&array[end]==1){
                System.out.print(end+" ");
                return;
            }
            else if(array[begin]==0&&array[end]==0)
                return;
        }
        else if(end-begin+1==3){

            if(array[end]==0&&array[begin]==1||array[end]==0&&array[begin]==0)
                recursion(array, begin, end-1);
            else if(array[end]==1&&array[begin]==0){
                recursion(array, begin+1, end);
            }
            else if(array[end]==1&&array[begin]==1){
                System.out.print(end+" ");
                recursion(array, begin, end-1);
            }
         return;
        }
        recursion(array, begin, mid);
        recursion(array, mid+1, end);
    }
}
