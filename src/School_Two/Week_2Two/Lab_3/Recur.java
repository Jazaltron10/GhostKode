package Week_2Two.Lab_3;
import java.util.Arrays;
public class Recur {
    /**
     * Apply QuicksortStep to the list of items in locations lo through hi
     * in the array A. The value returned by this routine is the final
     * position of the pivot item in the array.
     */
    static int quicksortStep(int[] A, int lo, int hi) {
        int pivot = A[lo]; // Get the pivot value.
        // The numbers hi and lo mark the endpoints of a range
        // of numbers that have not yet been tested. Decrease hi
        // and increase lo until they become equal, moving numbers
        // bigger than pivot so that they lie above hi and moving
        // numbers less than the pivot so that they lie below lo.
        // When we begin, A[lo] is an available space, since its
        // value has been moved into the local variable, pivot.
        while (hi > lo) {
            // Loop invariant (See Subsection Subsection 8.2.3): A[i] <= pivot
            // for i < lo, and A[i] >= pivot for i > hi.
            while (hi > lo && A[hi] >= pivot) {
                // Move hi down past numbers greater than pivot.
                // These numbers do not have to be moved.
                hi--;
            }
            if (hi == lo)
                break;
            // The number A[hi] is less than pivot. Move it into
            // the available space at A[lo], leaving an available
            // space at A[hi].
            A[lo] = A[hi];
            lo++;
            while (hi > lo && A[lo] <= pivot) {
                // Move lo up past numbers less than pivot.
                // These numbers do not have to be moved.
                lo++;
            }
            if (hi == lo)
                break;
            // The number A[lo] is greater than pivot. Move it into
            // the available space at A[hi], leaving an available
            // space at A[lo].
            A[hi] = A[lo];
            hi--;
        } // end while
          // At this point, lo has become equal to hi, and there is
          // an available space at that position. This position lies
          // between numbers less than pivot and numbers greater than
          // pivot. Put pivot in this space and return its location.
        A[lo] = pivot;
        return lo;
    } // end QuicksortStep

    /**
     * Apply quicksort to put the array elements between
     * position lo and position hi into increasing order.
     */
    static void quicksort(int[] A, int lo, int hi) {
        if (hi <= lo) {
            // The list has length one or zero. Nothing needs
            // to be done, so just return from the subroutine.
            // return;
        } else {
            // Apply quicksortStep and get the new pivot position.
            // Then apply quicksort to sort the items that
            // precede the pivot and the items that follow it.
            int pivotPosition = quicksortStep(A, lo, hi);
            quicksort(A, lo, pivotPosition - 1);
            quicksort(A, pivotPosition + 1, hi);
        }
    }
    
    public static void main(String[] args) {
        int[] lis = new int[]{10,72,3,46,4,2,55,6,74,86,32,3,69,8,7,65,32,2,3,4,42,82,26,1,18,13,26,2,90,4,4};
        quicksort(lis, 0, lis.length-1);
        // System.out.println(Arrays.toString(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        System.out.println(Arrays.toString(lis));
    }
}
