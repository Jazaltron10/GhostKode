public class StringTings {

    public static int commonChild(String s1, String s2) {
        /*
        *A string is said to be a child of a another string if it can be formed by deleting 0 or more characters from the other string. Letters cannot be rearranged. Given two strings of equal length, what's the longest string that can be constructed such that it is a child of both?
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


    public static void main(String[] args) {
        int Q1_result = commonChild("james", "john");
        System.out.printf("%nQ1_result: %d\n", Q1_result);
    }
}
