import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class Ancestors {
    // THIS SECTION PRINTS ALL THE DIFFERENT TYPES OF MATRIX
    static void PrintMatrix(int[][] matrix) {
        System.out.println("\nThe value of the matrix is ");
        System.out.println(Arrays.deepToString(matrix));
    }
    static int[][] TwoMatrixMultiplication(int[][] A1, int[][] A2) {
        /*
         * Two matrices can be multiplied together only when the
         * number of columns in the first matrix is equal
         * to the number of rows in the second matrix.
         * so basically if we have two matrices
         * number of columns of first matrix is = A1[0].length
         * number of rows of second matrix is = A2.length
         * They can only be multiplied
         * if A1[0].length == A2.length
         * 
         */
        /*
         * A1.length = number of rows of first matrix
         * A1[0].length = number of columns of first matrix
         * A2.length = number of rows of second matrix
         * A2[0].length = number of columns of second matrix
         * rowOfFirst * columnOfSecond = newElement;
         */
        int[][] newMatrix = new int[A1.length][A2[0].length];
        if (A1[0].length == A2.length) {
            // newMatrix[0][0] = (A1[0][0] * A2[0][0]) + (A1[0][1] * A2[1][0]) + (A1[0][2] *
            // A2[2][0]);
            // newMatrix[1][0] = (A1[1][0] * A2[0][0]) + (A1[1][1] * A2[1][0]) + (A1[1][2] *
            // A2[2][0]);
            if (A2[0].length == 1) {
                int row = 0;
                int col = 0;
                for (row = 0; row < newMatrix.length; row++) {
                    for (col = 0; col < newMatrix[0].length; col++) {
                        newMatrix[row][col] = (A1[row][col] * A2[0][col]) + (A1[row][1] * A2[1][col])
                                + (A1[row][2] * A2[2][col]);
                    }
                }
            } else if (A2[0].length > 1) {
                for (int nmRow = 0; nmRow < newMatrix.length; nmRow++) {
                    int j = 0;
                    int col = 0;
                    for (int nmCol = 0; nmCol < newMatrix[0].length; nmCol++) {
                        int row = 0;
                        newMatrix[row][col++] = (A1[row][0] * A2[0][j]) + (A1[row][1] * A2[1][j]);
                        j++;
                    }
                    j = 0;
                    col = 0;
                    for (int nmCol = 0; nmCol < newMatrix[0].length; nmCol++) {
                        int row = 1;
                        newMatrix[row][col++] = (A1[row][0] * A2[0][j]) + (A1[row][1] * A2[1][j]);
                        j++;
                    }
                    j = 0;
                    col = 0;
                    for (int nmCol = 0; nmCol < newMatrix[0].length; nmCol++) {
                        int row = 2;
                        newMatrix[row][col++] = (A1[row][0] * A2[0][j]) + (A1[row][1] * A2[1][j]);
                        j++;
                    }
                    // OUTPUT -> [[18, 29, 43, 31], [30, 43, 62, 44], [32, 32, 41, 27]]
                }
            }
        } else {
            System.out.println("Sorry the two matrices cannot be multiplied");
            return null;
        }

        return newMatrix;
    }
    // failed firstDuplicates FROM Code Signal 
    static int firstDuplicates(int [] a){
        ArrayList<Integer> duplicates = new ArrayList<Integer>();
        for(int i = 0; i < a .length; i++){
            for(int j = i+1; j < a.length; j++){
                if(a[i] == a[j]){
                    duplicates.add(j);
                }
            }
        }
        System.out.println("\n\nDuplicates are at index: " + duplicates);
        if(duplicates.size() == 0){
            return -1;
        }
        int smallest = duplicates.get(0);
        if(duplicates.size() == 1){
            return a[smallest];
        }
        for (int b = 0; b < duplicates.size(); b++) {
            if (duplicates.get(b) < smallest || duplicates.get(b) == duplicates.get(b++)) {
                smallest = duplicates.get(b);
                System.out.println("\n\n\nsmallest here is : " + smallest);
                return a[smallest];
            }
        }
        return -1;
    }
    static int[] largeSmall(Integer[] array){
        int largest = 0;
        int smallest = array[0];
        for(int a : array){
            if(a > largest){
                largest = a;
            }
            if (a < smallest){
                smallest = a;
            }
        }
        return new int[]{largest, smallest};
    }
    
    static String Run_Length_Encoding(String word) {
        // where run length encoded string is rulenc
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
        System.out.println("\n\n" + dictionary);
        String rulenc = "";
        for (Map.Entry<Character, Integer> entry : dictionary.entrySet()) {
            char c = entry.getKey();
            int value = entry.getValue();
            System.out.println("\n The Character " + c + ", Occured " + value + " times");
            if (value <= 9) {
                rulenc = rulenc + value + c + " ";
            } else if (value > 9 && value % 9 == 0) {
                int multi = value / 9;
                String prerulenc = "" + (value / multi) + c;
                rulenc = rulenc + prerulenc.repeat(multi) + " ";
                // rulenc = rulenc.repeat(multi);
            } else if (value > 9) {
                int muly = value / 9;
                int additional = value % 9;
                String prerulenca = "" + (9) + c;
                rulenc = rulenc + prerulenca.repeat(muly) + additional + c + " ";
            }
        }
        System.out.printf("%n %s", rulenc);
        // System.out.println("\n"+rulenc.getClass().getSimpleName());
        return rulenc;
    }
    public static void main(String[] args) {
        // Multiplying a matrix
        int[][] A1 = new int[][] { { 4, 7, 6 }, { 2, 3, 1 } };
        int[][] A2 = new int[][] { { 8 }, { 5 }, { 9 } };
        int[][] M5 = TwoMatrixMultiplication(A1, A2);
        PrintMatrix(M5);

        if(M5[0].length == A1[0].length){
            System.out.println("The two matrices can be multiplied " + M5[0].length + " "+ A1[0].length);
        }else{
            System.out.println("The two matrices cannot be multiplied \nM5[0].length " + M5[0].length + "\nA1[0].length "+ A1[0].length);
        }

        int[][] A3 = new int[][] { { 1, 5 }, { 2, 7 }, { 3, 4 } };
        int[][] A4 = new int[][] { { 8, 4, 3, 1 }, { 2, 5, 8, 6 } };
        int[][] M6 = TwoMatrixMultiplication(A3, A4);
        PrintMatrix(M6);


        // failed firstDuplicates FROM Code Signal 
        int[] a = new int[] {2,1,3,5,3,2};
        int[] b = new int[] {2,2,2,2,2,2,2,2};
        int[] c = new int[] {1,2,3,4,5,6,7,8,9,10};
        int[] d = new int[] {2,2};
        int[] e = new int[] {8, 4, 6, 2, 6, 4, 7, 9, 5, 8};
        int resa = firstDuplicates(a);
        int resb = firstDuplicates(b);
        int resc = firstDuplicates(c);
        int resd = firstDuplicates(d);
        int rese = firstDuplicates(e);
        System.out.printf("\nThe result is = rese: %d%n", rese);
        System.out.printf("\nThe result is = resa: %d%nresb:  %d%n resc: %d%n", resa, resb, resc);
        System.out.printf("\nThe result is:  %d%n%d%n%d%n%d%n", resa, resb, resc, resd);


        // Q3 failed run length encoding question [it isn't lossless]
        String Q3 = Run_Length_Encoding("AAAAAAAAAAAAABBCCCCDD");
            System.out.println("\n\n" + Q3);
        String Q3b = Run_Length_Encoding(
            "AAAAAAAAAAAAAAAAAABBBBBBBBBBBBBBCCCCCCCCCCCCCCCCCCDDDDDDDDDDDDDDDFFFFFFFFFFFFFEEEEEEEEEE");
            System.out.println("\n\n" + Q3b);
        String Q3c = Run_Length_Encoding(
            ";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;");
            System.out.println("\n\n" + Q3c);
        String Q3d = Run_Length_Encoding(
            "AAAAAAAAAAAAAAAAAABBBBBBBBBBBBeeeeeeeeeeBBCFFFFFFFCCCCCCCCCCCCCCCCCDDDDDDDDDDDDDDDFFFFFFFFFFFFFEEEEEEEEEE");
            System.out.println("\n\n" + Q3d);
    }
}
