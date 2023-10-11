import java.util.Arrays;
import java.util.Scanner;

public class project22 {
    public static void main(String[] args) {
        System.out.println("how many numbers you want to enter");
        Scanner myScanner=new Scanner(System.in);
        int a=myScanner.nextInt();
        int[]arr=new int[a];
        System.out.println("nums");
        for(int i=0;i<arr.length;i++){
            arr[i]=myScanner.nextInt();
        }
        System.out.println("target");
        int target=myScanner.nextInt();
        Arrays.sort(arr);
        search(arr,target);
    }
    public static int search(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}
