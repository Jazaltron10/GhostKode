import java.util.Map;
import java.util.HashMap;

// import java.util.ArrayList;
// import java.util.Arrays;
public class AESeries1 {

    public static int firstNonRepeatingCharacter(String word) {
        Map<Character, Integer> dictionary = new HashMap<Character, Integer>();
        // This is the histogram section
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Integer value = dictionary.get(c);
            if (!dictionary.containsKey(c)) {
                dictionary.put(c, 1);
            } else {
                dictionary.put(c, value + 1);
            }
        }
        System.out.println("\nd is " + dictionary.size());
        // This section for the first character in the given string/word that occurs
        // once,
        // This can only be achieved after making use of a histogram to log all of the
        // character frequencies.
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (dictionary.get(c) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("\nHello World!");
        int res = firstNonRepeatingCharacter("abacabad");
        System.out.println(res);

    }
}
