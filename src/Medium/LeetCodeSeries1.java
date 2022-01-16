
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
    public static void main(String[] args) {
        String name = "james";
        System.out.printf("%n%s is a palindrome: %b", name, palindromeTwo(name));
        System.out.println("\nHello World!");
        boolean palindrome = palindromeNumber(1221);
        System.out.printf("%n1221 is a palindrome: %b", palindrome);

    }
}