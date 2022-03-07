package Week_5Five;

import java.util.Arrays;

public class DashTable {
    String[] theArray;

    int arraySize;

    int itemsInArray = 0;

    DashTable(int size) {
        arraySize = size;
        theArray = new String[size];
        Arrays.fill(theArray, "-1");
    }
    public static void main(String[] args) {

        DashTable table = new DashTable(30);


        String[] elementsToAdd = { "120", "213", "175", "214", "278", "498",
                "227", "802", "900", "723", "299", "1", "18", "909", "890",
                "709", "998", "978", "988", "999", "980", "984", "320", "321",
                "401", "415", "450", "50", "620", "660" };

        table.hashFunction(elementsToAdd, table.theArray);


        table.getKey("660");

        table.displayCollection();

    }

    public void hashFunction(String[] ArrayStrings, String[] theArray) {
        for (int n = 0; n < ArrayStrings.length; n++) {
            String newVal = ArrayStrings[n];
            int arrayIdx = Integer.parseInt(newVal) % 29;
            System.out.println("Hash Index = " + arrayIdx + " for value "
                    + newVal);
            while (theArray[arrayIdx] != "-1") {
                ++arrayIdx;
                System.out.println("Collision Try " + arrayIdx + " Instead");
                arrayIdx %= arraySize;
            }
            theArray[arrayIdx] = newVal;
        }
    }

    public String getKey(String key) {
    int arrayIdxHash = Integer.parseInt(key) % 29;
        while (theArray[arrayIdxHash] != "-1") {
            if (theArray[arrayIdxHash] == key) {
                System.out.println(key + " was found in index "
                        + arrayIdxHash);
                return theArray[arrayIdxHash];
            }
            ++arrayIdxHash;
            arrayIdxHash %= arraySize;
        }
        return null;
    }

    public void displayCollection() {
        int increment = 0;

        for (int n = 0; n < 71; n++)
            System.out.print("-");
        System.out.println();

        for (int n = increment - 10; n < increment; n++) {
            System.out.format("| %3s " + " ", n);
        }

        System.out.println("|");

        for (int n = 0; n < 71; n++)
            System.out.print("-");
        System.out.println();

        for (int n = increment - 10; n < increment; n++) {
            if (theArray[n].equals("-1"))
                System.out.print("|      ");
            else
                System.out.print(String.format("| %3s " + " ", theArray[n]));
            }

        System.out.println("|");

        for (int n = 0; n < 71; n++)
            System.out.print("-");
        System.out.println();
    }
}
