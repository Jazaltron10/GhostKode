import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// import java.util.Arrays;
// import java.util.ArrayList;
public class LeetCodeSeries1 {
    public static boolean palindromeTwo(String word) {
        // This has O(n) time and O(1) space
        int j = word.length() - 1;
        for (int i = 0; i < word.length(); i++, j--) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static boolean palindromeNumber(int num) {
        String numberString = Integer.toString(num);
        System.out.println("numberString: " + numberString);
        int j = numberString.length() - 1;
        for (int i = 0; i < numberString.length(); i++, j--) {
            if (numberString.charAt(i) != numberString.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void theCommonChild(String first, String second) {
        // This has O(n^2) time and O(n) space
        int[][] matrix = new int[first.length() + 1][second.length() + 1];
        for (int i = 0; i < first.length() + 1; i++) {
            matrix[i][0] = 0;
        }
        for (int i = 0; i < second.length() + 1; i++) {
            matrix[0][i] = 0;
        }
        for (int i = 1; i < first.length() + 1; i++) {
            for (int j = 1; j < second.length() + 1; j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }
        System.out.println("\n\n\nThe common child is: " + matrix[first.length()][second.length()]);
    }

    public static List<List<Integer>> sortTheSummary(List<Integer> arr) {
        // Write your code here
        // Story: given an array of integers,
        // input: list of integers
        // output: list of lists of integers
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (Integer k : arr) {
            Integer value = countMap.getOrDefault(k, 0);
            countMap.put(k, value + 1);
        }
        // System.out.println(countMap);

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            List<Integer> InnerList = new ArrayList<>();
            InnerList.add(entry.getKey());
            InnerList.add(entry.getValue());
            result.add(InnerList);
        }

        // System.out.println(InnerList);
        result.sort((a, b) -> a.get(0) - b.get(0));
        result.sort((a, b) -> b.get(1) - a.get(1));

        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        String name = "james";
        System.out.printf("%n%s is a palindrome: %b", name, palindromeTwo(name));
        System.out.println("\nHello World!");
        boolean palindrome = palindromeNumber(1221);
        System.out.printf("%n1221 is a palindrome: %b", palindrome);
        theCommonChild("HARRY", "SALLY");
        theCommonChild("SHINCHAN", "NOHARAAA");

        sortTheSummary(Arrays.asList(1, 4, 3, 6, 5, 3, 3, 2, 2));
    }
}