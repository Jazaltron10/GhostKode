import java.util.Arrays;
import java.util.ArrayList;
public class LeetCodeSeries1{
    public static boolean palindromeTwo(String word){
        // This has O(n) time and O(1) space
        int j = word.length()-1;
        for(int i = 0; i < word.length() ; i++, j--){
            if(word.charAt(i) != word.charAt(j)){
                return false;
            }
        }
        return true;
    }
    public static boolean palindromeNumber(int num){
        String numberString = Integer.toString(num);
        System.out.println("numberString: " + numberString);
        int j = numberString.length()-1;
        for(int i = 0; i < numberString.length() ; i++, j--){
            if(numberString.charAt(i) != numberString.charAt(j)){
                return false;
            }
        }
        return true;
    }
    public static void theCommonChild(String first, String second){
        // This has O(n^2) time and O(n) space
        int[][] matrix = new int[first.length()+1][second.length()+1];
        for(int i = 0; i < first.length()+1; i++){
            matrix[i][0] = 0;
        }
        for(int i = 0; i < second.length()+1; i++){
            matrix[0][i] = 0;
        }
        for(int i = 1; i < first.length()+1; i++){
            for(int j = 1; j < second.length()+1; j++){
                if(first.charAt(i-1) == second.charAt(j-1)){
                    matrix[i][j] = matrix[i-1][j-1] + 1;
                }else{
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
                }
            }
        }
        System.out.println("\n\n\nThe common child is: " + matrix[first.length()][second.length()]);
    }

    static int codeDuplicates(int [] a){
        // int inc = 0;
        int []count = new int[a.length];
        ArrayList<Integer> duplicates = new ArrayList<Integer>();
        for(int i = 0; i < a .length; i++){
            for(int j = i+1; j < a.length; j++){
                if(a[i] == a[j]){
                    // System.out.println("\nDuplicate: " + a[i] + " at index " + i + "\n " + a[j] + " at index " + j);
                    count[i] = j;
                    duplicates.add(j);
                    // inc++;
                    // return a[i];
                }
            }
        }
        System.out.println("\n\nDuplicates are at index: " + duplicates +" "+ duplicates.size());
        System.out.println("\n\n\nThe duplicates are: " + Arrays.toString(count)+" "+ count.length);
        int smallest = count[0];
        for (int b : count) {
            if (b < smallest && b != 0) {
                smallest = b;
                System.out.println("\n\n\nsmallest: " + smallest);
                return a[smallest];
            }
            else if (count.length == 2){
                return a[count.length-1];
            }else if(b == smallest && b != 0){
                return a[smallest];
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        // String name = "james";
        // System.out.printf("%n%s is a palindrome: %b", name, palindromeTwo(name));
        // System.out.println("\nHello World!");
        // boolean palindrome = palindromeNumber(1221);
        // System.out.printf("%n1221 is a palindrome: %b", palindrome);
        // theCommonChild("HARRY", "SALLY");
        // theCommonChild("SHINCHAN", "NOHARAAA");

        int[] a = new int[] {2,1,3,5,3,2};
        int[] b = new int[] {2,2,2,2,2,2,2,2};
        int[] c = new int[] {1,2,3,4,5,6,7,8,9,10};
        int[] d = new int[] {2,2};
        int resa = codeDuplicates(a);
        int resb = codeDuplicates(b);
        int resc = codeDuplicates(c);
        int resd = codeDuplicates(d);
        // System.out.printf("\nThe result is:  %d%n", resd);
        System.out.printf("\nThe result is:  %d%n%d%n%d%n%d%n", resa, resb, resc, resd);
    }
}