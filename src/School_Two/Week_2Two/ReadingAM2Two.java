package Week_2Two;

public class ReadingAM2Two {
    // LinkedList
    /**
     * Search in the array A in positions numbered loIndex to hiIndex,
     * inclusive, for the specified value. If the value is found, return
     * the index in the array where it occurs. If the value is not found,
     * return-1. Precondition:
     * The array
     * must be
     * sorted into increasing*order.
     */

    static int binarySearch(int[] A, int loIndex, int hiIndex, int value) {
        if (loIndex > hiIndex) {
            // The starting position comes after the final index,
            // so there are actually no elements in the specified
            // range. The value does not occur in this empty list!
            return -1;
        } else {
            // Look at the middle position in the list. If the
            // value occurs at that position, return that position.
            // Otherwise, search recursively in either the first
            // half or the second half of the list.
            int middle = (loIndex + hiIndex) / 2;
            if (value == A[middle])
                return middle;
            else if (value < A[middle])
                return binarySearch(A, loIndex, middle - 1, value);
            else // value must be > A[middle]
                return binarySearch(A, middle + 1, hiIndex, value);
        }
    } // end binarySearch()

    /**
     * Solve the problem of moving the number of disks specified
     * by the first parameter from the stack specified by the
     * second parameter to the stack specified by the third
     * parameter. The stack specified by the fourth parameter
     * is available for use as a spare. Stacks are specified by
     * number: 0, 1, or 2.
     */
    static void towersOfHanoi(int disks, int from, int to, int spare) {
        if (disks == 1) {
            // There is only one disk to be moved. Just move it.
            System.out.printf("Move disk 1 from stack %d to stack %d%n",
                    from, to);
        } else {
            // Move all but one disk to the spare stack, then
            // move the bottom disk, then put all the other
            // disks on top of it.
            towersOfHanoi(disks - 1, from, spare, to);
            System.out.printf("Move disk %d from stack %d to stack %d%n",
                    disks, from, to);
            towersOfHanoi(disks - 1, spare, to, from);
        }
    }

    /**
     * If the No. of disks is 4
     * Move disk 1 from stack 0 to stack 2
     * Move disk 2 from stack 0 to stack 1
     * Move disk 1 from stack 2 to stack 1
     * Move disk 3 from stack 0 to stack 2
     * Move disk 1 from stack 1 to stack 0
     * Move disk 2 from stack 1 to stack 2
     * Move disk 1 from stack 0 to stack 2
     * Move disk 4 from stack 0 to stack 1
     * Move disk 1 from stack 2 to stack 1
     * Move disk 2 from stack 2 to stack 0
     * Move disk 1 from stack 1 to stack 0
     * Move disk 3 from stack 2 to stack 1
     * Move disk 1 from stack 0 to stack 2
     * Move disk 2 from stack 0 to stack 1
     * Move disk 1 from stack 2 to stack 1
     */

    public static void main(String[] args) {
        System.out.println("Hello World");
        int ans = binarySearch(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 0, 9, 5);
        System.out.println(ans);
    }
}
