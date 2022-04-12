import java.util.*;

class StringScream {
    public static void main(String[] args) {
        String res = "ab ac ab ad";
        String[] arr = res.split(" ");
        System.out.println(Arrays.toString(arr));

        String res2 = "99 88 300";
        ArrayList<String> holders = new ArrayList<>();
        String key = "";
        for (int i = 0; i < res2.length(); i++) {
            char ch = res2.charAt(i);
            if (ch == ' ') {
                holders.add(key);
                key = "";
                continue;
            } else {
                key += ch;
                // k = Integer.parseInt(res2.split(" ")[2]);
            }
        }
        Arrays.sort(holders.toArray());
        System.out.println(holders);

        /**
         * Printing all the elements in a 2d matrix using only one for loop
         */
        int[][] karr = { { 1, 2, 3 }, { 4, 5, 8 }, { 5, 6, 7 } };
        int hight = karr.length;
        int width = karr[0].length;
        for (int i = 0; i < width * hight; i++) {
            int li = i / hight;
            int col = i % hight;
            System.out.print(karr[li][col]);
            if (col == width - 1)
                System.out.println();
        }

        /**
         * Splitting a string into an arraylist of strings
         * 
         */
        String s1 = "java string split method by javatpoint";
        String[] words = s1.split("\\s");// splits the string based on whitespace
        // using java foreach loop to print elements of string array
        for (String w : words) {
            System.out.println(w);
        }
        System.out.println(Arrays.toString(words));

    }

}