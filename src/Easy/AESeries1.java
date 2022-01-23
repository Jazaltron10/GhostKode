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
        Map <String, Integer> dictionary = new HashMap<String, Integer>();
        for (int i = 0 ; i < competitions.size() ; i++) {
            for (int j = 0 ; j < competitions.get(0).size(); j++) {
                String coders = competitions.get(i).get(j);
                Integer points = dictionary.get(coders);
                if(!dictionary.containsKey(coders)) {
                    dictionary.put(coders, 0);
                }else{
                    dictionary.put(coders, points + 0);
                }
            }
        }
        System.out.println("\n\n\n"+dictionary);
        
        // dictionary.get("HTML") = 3;
        
        int i = 0;
            for(String k : dictionary.keySet()){
                Integer value = dictionary.get(k);
                String winhome = competitions.get(i).get(0);// home team
                String winaway = competitions.get(i).get(1);// away team
                // Here the home team wins
                if (results.get(i) == 1) {
                    if (!dictionary.containsKey(winhome)){
                        dictionary.put( winhome , 0);
                    }else{
                        dictionary.put( winhome , value + 3);
                    }
                    System.out.println("\n\n\n"+ dictionary);
                }
                
                // Here the away team wins
                if (results.get(i) == 0) {
                    System.out.println("\n\n\n"+ dictionary);
                    if (!dictionary.containsKey(winaway)){
                        dictionary.put( winaway , 0);
                    }else{
                        dictionary.put( winaway , value + 3);
                    }
            }i++;
    }
        
        System.out.println("\n\n\n"+ dictionary);
        String res = " ";
        Integer largest = 0;
        for(String winner : dictionary.keySet()){
            System.out.println(dictionary.get(winner));
            Integer value = dictionary.get(winner);
            if(value > largest) largest = value;
            res = winner;
        }
        return res;
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
        

        ArrayList<Integer> results = new ArrayList<Integer>(Arrays.asList(1,1,1));

        String ans = TournamentWinner(competitions , results);
        // System.out.println("\n\n"+competitions.size());
        // System.out.println("\n\n"+results);
        
        System.out.println("\n\nThe winner is: " + ans);
        
        
        
    }
}
