package Week_1One.Lab_2;
import java.util.Arrays;
import java.util.Random;

/**
 * BenchMark_Sort class
 * RESULTS REPORT
 * <h2>Below are the runtime for the different arraySize input for the selection
 * Sorting Algorithm</h2>
 * When the arraySize is 1000, the runtime is: 0.003secs
 * When the arraySize is 10000, the runtime is: 0.049secs
 * When the arraySize is 100000, the runtime is: 3.854secs
 * 
 * <h2>Below are the runtime for the different arraySize input for the
 * Arrays.sort() built-in Algorithm</h2>
 * When the arraySize is 1000, the runtime is: 0.000secs
 * When the arraySize is 10000, the runtime is: 0.016secs
 * When the arraySize is 100000, the runtime is: 0.017secs
 */
public class BenchMark_Sort {
    // Welcome Message 
    public void Welcome(){
        System.out.println("\n\nWelcome to the BenchMark_Sort class");
    }
    // Computing the benchmarks of two different sorting algorithms
    public BenchMark_Sort() {
        int arraySize = 10000; // initializing the arraySize
        Random rand = new Random(); // creating a Random object

        // Creating two arrays of same type(int) and size
        int[] arrayA = new int[arraySize];
        int[] arrayB = new int[arraySize];

        // Filling the arrays with random numbers using the random object
        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = rand.nextInt(100);
            arrayB[i] = arrayA[i];
        }

        // Calculating the computing time for the Selection sort
        long startTimeArrayA = System.currentTimeMillis(); // start time
        selectionSortingAlgorithm(arrayA); // calling the selection sort method
        long runTimeArrayA = System.currentTimeMillis() - startTimeArrayA; // time taken to run the method

        // Calculating the computing time for the built in sorting method ->
        // (Arrays.sort)
        long startTimeArrayB = System.currentTimeMillis(); // start time
        Arrays.sort(arrayB); // sorting arrayB with Arrays.sort()
        long runTimeArrayB = System.currentTimeMillis() - startTimeArrayB; // time taken to run the method

        // Printing the Results
        System.out.println("\nselection sort time in secs is " + runTimeArrayA / 1000.0);
        System.out.println("\nArrays.sort(), sort time in secs is " + runTimeArrayB / 1000.0);
    }

    /**
     * This method takes in an array with random values and sorts
     * it using the selection sort algorithm.
     * 
     * @param A, an integer array of random values
     */
    static void selectionSortingAlgorithm(int[] A) {
        // Sort A into increasing order, using selection sort
        for (int lastPlace = A.length - 1; lastPlace > 0; lastPlace--) {
            // Find the largest item among A[0], A[1], ...,
            // A[lastPlace], and move it into position lastPlace
            // by swapping it with the number that is currently
            // in position lastPlace.
            int maxLoc = 0; // Location of largest item seen so far.
            for (int j = 1; j <= lastPlace; j++) {
                if (A[j] > A[maxLoc]) {
                    // Since A[j] is bigger than the maximum we’ve seen
                    // so far, j is the new location of the maximum value
                    // we’ve seen so far.
                    maxLoc = j;
                }
            }
            int temp = A[maxLoc]; // Swap largest item with A[lastPlace].
            A[maxLoc] = A[lastPlace];
            A[lastPlace] = temp;
        } // end of for loop
    }
}
