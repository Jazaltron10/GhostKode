import java.util.Arrays;
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
    }
}
