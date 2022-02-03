/**
 * 
 * PART 1: BenchMarking Sorting Algorithms 
 * The same task can take vastly different amounts of time, depending on the
 * algorithm that is used to perform the task. You are familiar with simple
 * sorting algorithms such as insertion sort and selection sort. (See Section
 * 7.4 in the textbook.) While these methods work fine for small arrays, for
 * larger arrays they can take an unreasonable amount of time. The question is
 * whether we can do any better.
 * 
 * Java has some built-in sorting methods. They can be found in the class named
 * Arrays in the package java.util. The one that you will use in this lab is
 * Arrays.sort(A), which sorts the entire array A into increasing order.
 * (Actually, there are different methods for different array base types, but
 * all the methods have the same name and are used in the same way. You will be
 * using an array of ints in this lab.)
 * 
 * You should write a program that does the following:
 * 
 * Create two arrays of type int[]. Both arrays should be the same size, and the
 * size should be given by a constant in the program so that you can change it
 * easily.
 * 
 * Fill the arrays with random integers. The arrays should have identical
 * contents, with the same random numbers in both arrays. To generate random
 * integers with a wide range of sizes, you could use (int)(Integer.MAX_VALUE *
 * Math.random()).
 * 
 * Sort the first array using either Selection Sort or Insertion Sort. You
 * should add the sorting method to your program; you can copy it from Section
 * 7.4 if you want. (It is a good idea to check that you got the sorting method
 * correct by using it to sort a short array and printing out the result.)
 * 
 * Time how long it takes to sort the array and print out the time.
 * 
 * Now, sort the second (identical) array using Arrays.sort(). Again, time how
 * long it takes, and print out the time.
 * 
 * You should run your program using array sizes of 1,000, 10,000, and 100,000.
 * Record the sort times. Add a comment to the top of the program that reports
 * the times. (You might be interested in applying Arrays.sort() to a
 * million-element array, but don't try that with Selection Sort or Insertion
 * Sort!)
 * 
 * Note: The general method for getting the run time of a code segment is:
 * 
 * long startTime = System.currentTimeMillis();
 * doSomething();
 * long runTime = System.currentTimeMillis() - startTime;
 * 
 * This gives the run time in milliseconds. If you want the time in seconds, you
 * can use runTime/1000.0.
 */
package Week_1One.Lab_2;

import java.util.Arrays;
import java.util.Random;

/**
 * BenchMark class
 * Computing the benchmarks of two different sorting algorithms
 * REPORT
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
public class BenchMark {
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

    public static void main(String[] args) {
        int arraySize = 100000; // initializing the arraySize
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
}
