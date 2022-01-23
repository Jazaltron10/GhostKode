import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
public class AESeries2 {
    static String TournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        String winner = " ";
        String winner_1 = "";
        String winner_2 = "";
        String winner_3 = "";
        for (int row = 0; row < competitions.size(); row++) {
            // System.out.println(competitions.get(row).get(col));
            System.out.println(competitions.get(row));

            // for each row
            int c = 0;
            for (int col = 0; col < competitions.size() - 1; col++) {
                // for each col in the row
                // This is for the first row
                int r = 0;
                if (results.get(0) == 1) {
                    winner_1 = " " + competitions.get(r).get(c) + " 3";
                    System.out.println(winner_1);
                } else {
                    winner_1 = " " + competitions.get(r).get(c++) + " 3";
                    System.out.println(winner_1);
                }
            }

            c = 0;
            for (int col = 0; col < competitions.size() - 1; col++) {
                // This is for the second row in the tournament
                int r = 1;
                if (results.get(1) == 1) {
                    winner_2 = " " + competitions.get(r).get(c) + " 3";
                    System.out.println(winner_2);
                } else {
                    winner_2 = " " + competitions.get(r).get(c++) + " 3";
                    System.out.println(winner_2);
                }
            }
            c = 0;
            for (int col = 0; col < competitions.size() - 1; col++) {
                // This is for the Third row in the tournament
                int r = 2;
                if (results.get(2) == 1) {
                    winner_3 = " " + competitions.get(r).get(c) + " 3";
                    System.out.println(winner_3);
                } else {
                    winner_3 = " " + competitions.get(r).get(c++) + " 3";
                    System.out.println(winner_3);
                }
            }
        }

        // System.out.println("\n" + winner_1);
        // System.out.println("\n" + winner_2);
        // System.out.println("\n" + winner_3);
        if (winner_1.equals(winner_2) || winner_1.equals(winner_3)) {
            winner = winner_1;
        } else if (winner_2.equals(winner_1) || winner_2.equals(winner_3)) {
            winner = winner_2;
        } else if (winner_3.equals(winner_1) || winner_3.equals(winner_2)) {
            winner = winner_3;
        } else {
            winner = " Tie ";
        }
        return winner;
    }

    public static void main(String[] args) {
        System.out.println("Hello Ghost");

        // Tourney Winner
        ArrayList<ArrayList<String>> competitions = new ArrayList<ArrayList<String>>();
        ArrayList<String> team_1 = new ArrayList<String>(Arrays.asList("HTML", "C#"));
        ArrayList<String> team_2 = new ArrayList<String>(Arrays.asList("C#", "Python"));
        ArrayList<String> team_3 = new ArrayList<String>(Arrays.asList("Python", "HTML"));
        competitions.add(team_1);
        competitions.add(team_2);
        competitions.add(team_3);

        ArrayList<Integer> results = new ArrayList<Integer>(Arrays.asList(0, 1, 1));

        String ans = TournamentWinner(competitions, results);
        // System.out.println("\n\n"+competitions.size());
        // System.out.println("\n\n"+results);

        System.out.println("\n\nThe winner is: " + ans);
        String s = "Hello World";
        characterCounter(s);
    }
    static void characterCounter(String s){
        Map <Character, Integer> dictionary = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()){
            dictionary.put(c, dictionary.getOrDefault(c, 0) + 1);
        }
        System.out.println("\n\n\n"+dictionary);
    }
}
