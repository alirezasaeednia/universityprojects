import java.util.*;

public class main {
    public static void main(String[] args) {
        System.out.println("array length");
        Scanner myScanner = new Scanner(System.in);
        int length = myScanner.nextInt();
        int[] array = new int[length];
        System.out.println(" nums");
        try {
            for (int i = 0; i < length; i++) {
                array[i] = myScanner.nextInt();
            }
        } catch (InputMismatchException e) {
            System.exit(0);
        }
        System.out.println("k to find");
        int k = myScanner.nextInt();
        if (k > array.length) {
            System.exit(0);
        }
        System.out.println("Q");
        int q = myScanner.nextInt();
        System.out.println(choosingAlg(array, k, q));
    }

    public static int choosingAlg(int[] array, int k, int q) {
        if (array.length < q) {
            Arrays.sort(array);
            return array[k - 1];
        }
        List<int[]> arrayParts = splitArrays(array, q);
        return sbeArray(findMid(arrayParts, k, q, arrayParts), array, k, q);
    }

    public static List splitArrays(int[] array, int q) {
        int numberOfArrays = array.length / q;
        int remainder = array.length % q;

        int start = 0;
        int end = 0;

        List<int[]> list = new ArrayList<int[]>();
        for (int i = 0; i < numberOfArrays; i++) {
            end += q;
            list.add(Arrays.copyOfRange(array, start, end));
            start = end;
        }

        if (remainder > 0) {
            list.add(Arrays.copyOfRange(array, start, (start + remainder)));
        }

        for (int i = 0; i < list.size(); i++) {
            Arrays.sort(list.get(i));
        }

        return list;
    }

    public static int findMid(List<int[]> list, int k, int q, List<int[]> original) {

        HashSet<Integer> s = new HashSet();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length % 2 == 0) {
                s.add(list.get(i)[list.get(i).length / 2 - 1]);
            } else {
                s.add(list.get(i)[list.get(i).length / 2]);
            }
        }
        if (s.size() != 1) {
            List<int[]> l = new ArrayList();
            int[] array = s.stream().mapToInt(Number::intValue).toArray();
            l.add(array);
            return findMid(new ArrayList<int[]>(l), k, q, original);
        } else {
            return s.iterator().next();
        }
    }

    public static int sbeArray(int mid, int[] array, int k, int q) {
        List<HashSet> l1 = new ArrayList<>();
        HashSet<Integer> s1 = new HashSet<>();
        HashSet<Integer> s2 = new HashSet<>();
        HashSet<Integer> s3 = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] < mid) {
                s1.add(array[i]);
            } else if (array[i] == mid) {
                s2.add(array[i]);
            } else {
                s3.add(array[i]);
            }
        }
        l1.add(s1);
        l1.add(s2);
        l1.add(s3);
        if (k <= s1.size()) {
            return choosingAlg((s1.stream().mapToInt(Number::intValue).toArray()), k, q);
        } else if (k <= (s2.size() + s1.size())) {
            Arrays.sort(array);
            if (s2.size() % 2 != 0) {
                return array[array.length / 2];
            } else {
                return array[array.length / 2 - 1];
            }
        } else {
            return choosingAlg((s3.stream().mapToInt(Number::intValue).toArray()), k - s2.size() - s1.size(), q);
        }
    }

}
