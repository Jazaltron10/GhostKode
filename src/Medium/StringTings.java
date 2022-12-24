
import java.util.List;

// import java.util.Map;
// import java.util.HashMap;
// import java.util.ArrayList;
// import java.util.Arrays;
public class StringTings {

    public static int commonChild(String s1, String s2) {
        /*
         * A string is said to be a child of another string if it can be formed by
         * deleting 0 or more characters from the other string. Letters cannot be
         * rearranged. Given two strings of equal length, what's the longest string that
         * can be constructed such that it is a child of both?
         */
        return LCSM4(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length());
    }

    public static int LCSM4(char[] X, char[] Y, int m, int n) {
        int memo[] = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            int prev = 0;
            for (int j = 1; j <= n; j++) {
                int temp = memo[j];
                if (X[i - 1] == Y[j - 1]) {
                    memo[j] = prev + 1;
                } else {
                    memo[j] = Math.max(memo[j], memo[j - 1]);
                }
                prev = temp;
            }
        }
        return memo[n];
    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        /*
         * Given two non-empty arrays of integers, write a function that determines
         * whether the second array is a subsequence of the first one.
         * A subsequence of an array is a set of numbers that aren't necessarily
         * adjacent in the array but that are in the same order as they appear in the
         * array. For instance, the numbers [1, 3, 4] form a subsequence of the array
         * [1, 2, 3, 4], and so do the numbers [2, 4]. Note that a single number in an
         * array is also a subsequence of the array.
         */
        int count = 0;
        for (int c = 0; c < array.size(); c++) {
            if (count == sequence.size()) {
                break;
            }
            if ((array.get(c) == sequence.get(count))) {
                count += 1;
            }
        }
        if (count == sequence.size()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // Question 1
        int Q1_result = commonChild("james", "john");
        System.out.printf("%nQ1_result: %d\n", Q1_result);

        // Question 2
        boolean Q2_result = isValidSubsequence(List.of(1, 2, 3, 4, 5), List.of(3, 4));
        System.out.printf("%nQ2_result: %b\n", Q2_result);

        // Resource

    }
}
