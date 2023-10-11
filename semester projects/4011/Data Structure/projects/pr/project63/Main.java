import java.util.*;

public class Main {

 public static ArrayList<Integer> a = new ArrayList<>();
   public static int result = 0;
  public static ArrayList<Integer>results=new ArrayList<>();

 public static boolean is_sorted(ArrayList<Integer> a)
    {
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i) < a.get(i - 1))
                return false;
        }

        return true;
    }


    public static boolean merge(ArrayList<Integer> a, int low, int mid, int high)
    {
        if (a.get(mid) < a.get(mid + 1)) {
            return false;
        }


        for (int i = low; i <= mid; i++) {
            int tempswap = a.get(i);
            a.set(i, a.get(i + (high - low + 1) / 2));
            a.set(i + (high - low + 1) / 2, tempswap);
        }
        return true;
    }


public static void swap(ArrayList<Integer> a, int low, int high)
    {
        if (low < high) {

            int mid = low + (high - low) / 2;

            swap(a, low, mid);

            swap(a, mid + 1, high);

            if (merge(a, low, mid, high) == true) {
                result = result + 1;
            }
        }
    }

    public static void main(String[] args)
    {

          Scanner myScanner=new Scanner(System.in);
            int howmany=myScanner.nextInt();
            for (int i=0;i<howmany;i++){
                int tedadeLeaf=myScanner.nextInt();

                for(int j=0;j<tedadeLeaf;j++) {
                    int h=myScanner.nextInt();
                    a.add(h);
                }

                swap(a, 0, tedadeLeaf - 1);

              if (is_sorted(a))
                  results.add(result);
                else
                  results.add(-1);
                a.clear();
                result=0;

        }
            for(int i=0;i<results.size();i++){
                System.out.println(results.get(i));
           }


    }
    
}