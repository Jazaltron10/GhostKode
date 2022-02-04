// package Easy;

import java.util.HashSet;
import java.util.Arrays;
import java.util.ArrayList;

public class CSSeries1 {
    // THE FIRST METHOD O(n^2)) TIME AND O(1) SPACE
    static int firstDuplicates(int[] a) {
        int min_idx_of_first_duplicate = a.length;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j]) {
                    min_idx_of_first_duplicate = Math.min(min_idx_of_first_duplicate, j);
                }
            }
        }
        if (min_idx_of_first_duplicate == a.length) {
            return -1;
        } else
            return a[min_idx_of_first_duplicate];
    }

    static int firstDuplicates_HashSet(int[] a) {
        // This has O(n) time and O(n) space
        /**
         * space complexity could be used to speed up time complexity
         */
        HashSet<Integer> alreadySeen = new HashSet<Integer>();
        for (int num : a) {
            if (alreadySeen.contains(num)) {
                return num;
            } else {
                alreadySeen.add(num);
            }
        }
        return -1;
    }

    static int firstDuplicates_Optimized(int[] a) {
        // This has O(n) time and O(1) space
        /**
         * Every detail of a problem matters because they can often times help you to
         * get the most optimized solution
         */
        for (int i = 0; i < a.length; i++) {
            if (a[Math.abs(a[i]) - 1] < 0) {
                return Math.abs(a[i]);
            } else {
                a[Math.abs(a[i]) - 1] = -a[Math.abs(a[i]) - 1];
            }
        }
        return -1;
    }

    static String fancyRide(int l, double[] fares) {
        int Uber_Discount = 20;
        String[] options = new String[] { "UberX", "UberXL", "UberPlus", "UberBlack", "UberSUV" };
        double largest = 0;
        String ans = "";
        for (int i = 0; i < fares.length; i++) {
            double res = l * fares[i];
            if (res > Uber_Discount) {
                break;
            } else if (res <= Uber_Discount && res > largest) {
                largest = res;
                ans = options[i];
            }
        }
        return ans;
    }

    public static int[][] rotateImage(int[][] a) {
        int n = a.length;
        for(int i = 0; i < n ; i++){
            for(int j = i; j < n ; j++){
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n/2; j++){
                int tem = a[i][j];
                a[i][j] = a[i][n-1-j];
                a[i][n-1-j] = tem;
            }
        }
        System.out.print("\n\n" + Arrays.deepToString(a));
        return a;
    }

    public static void main(String[] args) {
        // firstDuplicates
        int[] a = new int[] { 2, 1, 3, 5, 3, 2 };
        int[] b = new int[] { 2, 2, 2, 2, 2, 2, 2, 2 };
        int[] c = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] d = new int[] { 2, 2 };
        int[] e = new int[] { 8, 4, 6, 2, 6, 4, 7, 9, 5, 8 };
        int[] f = new int[] { 10, 6, 8, 4, 9, 1, 7, 2, 5, 3 };
        int resa = firstDuplicates(a);
        int resb = firstDuplicates(b);
        int resc = firstDuplicates_HashSet(c);
        int resd = firstDuplicates_HashSet(d);
        int rese = firstDuplicates_Optimized(e);
        int resf = firstDuplicates_Optimized(f);
        System.out.printf("\nThe result is = rese: %d,%n resf: %d%n", rese, resf);
        System.out.printf("\nThe result is:  %d%n%d%n%d%n%d%n", resa, resb, resc, resd);

        // first_non_repeating_character
        int[] k = new int[] { 10, 6, 8, 4, 9, 1, 7, 2, 5, 3 };
        ArrayList<Integer> v = new ArrayList<Integer>(Arrays.asList(10, 6, 8, 4, 9, 1, 7, 2, 5, 3));
        System.out.println("" + v);
        // (int) v;

        Arrays.sort(k);

        for (int i = 97; i < 123; i++) {
            System.out.println("" + (char) i);
        }

        double[] lis = new double[] { 0.3, 0.5, 0.7, 1, 1.3 };
        String mans = fancyRide(15, lis);
        System.out.println("" + mans);
        
        int[][] arr = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] barr = rotateImage(arr);
        System.out.println("" + Arrays.deepToString(barr));
    }
}
