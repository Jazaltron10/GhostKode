import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
public class AESeries1 {
    
    public static int firstNonRepeatingCharacter(String word) {
        /*
        Write a function that takes in a string of lowercase English-alphabet letters and returns the index of the string's first non-repeating character. 
        The first non-repeating character is the first character in a string that occurs only once. 
        if the input string doesn't have any non-repeating characters, your function should return -1.
        */ 
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
    
    static String TournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        String winner = " ";
        String winner_1 = "";
        String winner_2 = "";
        String winner_3 = "";
        // for (int row = 0; row < competitions.size(); row++){// for each row
            // for (int column = 0; column < competitions.size()-1; column++){// for each column in the row
                // System.out.println(competitions.get(row).get(column));
                // System.out.println(competitions.get(row));
                if(results.get(0) == 1){
                    winner_1 = " " + competitions.get(0).get(0)+" 3";
                    System.out.println(winner_1);
                }else{
                    winner_1 = " " + competitions.get(0).get(1)+" 3";
                    System.out.println(winner_1);
                }
                if(results.get(1) == 1){
                    winner_2 = " " + competitions.get(1).get(0)+" 3";
                    System.out.println(winner_2);
                }else{
                    winner_2 = " " + competitions.get(1).get(1)+" 3";
                    System.out.println(winner_2);
                }
                if(results.get(2) == 1){
                    winner_3 = " " + competitions.get(2).get(0)+" 3";
                    System.out.println(winner_3);
                }else{
                    winner_3 = " " + competitions.get(2).get(1)+" 3";
                    System.out.println(winner_3);
                }
            // }
            // }
    
            System.out.println("\n"+winner_1);
            System.out.println("\n"+winner_2);
            System.out.println("\n"+winner_3);
            if (winner_1.equals(winner_2) || winner_1.equals(winner_3)){
            winner = winner_1;
        }else if (winner_2.equals(winner_1) || winner_2.equals(winner_3)){
            winner = winner_2;
        }else if (winner_3.equals(winner_1) || winner_3.equals(winner_2)){
            winner = winner_3;
        }else{
            winner = " Tie ";
        }
        return winner;
    }
    
    public static void main(String[] args) {
        // System.out.println("\nHello World!");
        
        
        // int res = firstNonRepeatingCharacter("abacabad");
        // System.out.println(res);


        // Tourney Winner
        ArrayList<ArrayList<String>> competitions = new ArrayList<ArrayList<String>>();
        ArrayList<String> team_1 = new ArrayList<String>(Arrays.asList("HTML", "C#"));
        ArrayList<String> team_2 = new ArrayList<String>(Arrays.asList("C#", "Python"));
        ArrayList<String> team_3 = new ArrayList<String>(Arrays.asList("Python", "HTML"));
        competitions.add(team_1);
        competitions.add(team_2);
        competitions.add(team_3);
        

        ArrayList<Integer> results = new ArrayList<Integer>(Arrays.asList(1, 1, 1));

        String ans = TournamentWinner(competitions , results);
        // System.out.println("\n\n"+competitions.size());
        // System.out.println("\n\n"+results);
        
        System.out.println("\n\nThe winner is: " + ans);
        
        
        
    }
}
