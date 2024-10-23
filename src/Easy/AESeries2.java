import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class AESeries2 {

    static String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        final int Home_Team_Won = 1;
        String currentBestTeam = "";
        HashMap<String, Integer> scores = new HashMap<String, Integer>();
        scores.put(currentBestTeam, 0);

        for (int i = 0; i < competitions.size(); i++) {
            int result = results.get(i);
            String homeTeam = competitions.get(i).get(0);// home team
            String awayTeam = competitions.get(i).get(1);// away team

            String winningTeam = (result == Home_Team_Won) ? homeTeam : awayTeam;

            updateScores(winningTeam, 3, scores);

            if (scores.get(winningTeam) > scores.get(currentBestTeam)) {
                currentBestTeam = winningTeam;
            }
        }
        return currentBestTeam;
    }

    static void updateScores(String team, int points, HashMap<String, Integer> scores) {
        if (!scores.containsKey(team)) {
            scores.put(team, 0);
        }
        scores.put(team, scores.get(team) + points);

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

        ArrayList<Integer> results = new ArrayList<Integer>(Arrays.asList(0, 0, 1));
        String ans = tournamentWinner(competitions, results);
        System.out.println("\n\nThe winner is: " + ans);
    }
}
