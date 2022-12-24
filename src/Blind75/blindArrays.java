import java.util.Arrays;

public class blindArrays {
    /**
     * This variation of two number sum uses the concepts of two pointers to solve
     * the question.
     */
    public static int[] TwoSum(int[] arr, int targetSum) {
        // Write your code here.

        Arrays.sort(arr);
        int lhs = 0;
        int rhs = arr.length - 1;
        while (lhs < rhs) {
            int sum = arr[lhs] + arr[rhs];
            if (sum == targetSum) {
                return new int[] { arr[lhs], arr[rhs] };
            } else if (sum < targetSum) {
                lhs++;
            } else {
                rhs--; 
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] a = new int[] { 8, 9, 1, 2, 4, 3, 2, 3, 2, 2 };
        int res[] = new int[a.length];
        res = TwoSum(a, 9);
        System.out.println(Arrays.toString(res));

        // System.out.println("Welcome to Blind75's Java Snippets");
        // # Question 1
        // Two Sum

    }
}
