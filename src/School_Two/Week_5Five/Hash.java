package Week_5Five;

import java.util.Arrays;

/**
 * HashSets and HashMaps are implemented using a data structure known as
 * <p>
 * hash table
 * </p>
 * <section>
 * hash table is a good solution for the problem of searching for a value.
 * The array index for a key is called a hashcode for that key.
 * A function that computes a hashcode, given a key, is called a hash function.
 * </section>
 * <p>
 * A collision is when we try to store more than one key in the same array
 * location. This usually happens when we have a lot of keys that share the same
 * hashcode. In this case, we can use a linked list to store the keys.
 * </p>
 * <p>
 * For a hashtable to work properly the number of items in the hash table should
 * be somewhat less than the number of locations in the array
 * </p>
 * Every object in java has a hash code
 * 
 * < h1>Map Applications</h1>
 * <p>
 * One of the most basic applications of a Map is for the construction of what
 * is known as a Symbol Table. A Symbol Table is a data structure that maps keys
 * to values, where the keys maps the name of the symbol and values an object
 * that holds the definition of the said symbol
 * .
 * </p>
 *
 * .
 */
public class Hash {
    private String[] table = new String[3];

    static int hashFunction(String s, int tableSize) {
        int hash = 17; // using prime number to help spread out the keys
        for (int i = 0; i < s.length(); i++) {
            int ascii = charCodeAt(s, i);
            hash = (13 * hash * ascii) % tableSize;
        }
        // System.out.println(hash);
        return hash;
    }

    static int charCodeAt(String string, int index) {
        return (int) string.charAt(index);
    }

    //
    void putItem(String key, String value) {
        int idx = hashFunction(key, this.table.length);
        if (this.table[idx] != null) {
            this.table[idx] = key + "=" + value;
        } else {
            this.table[idx] = this.table[idx] + "," + key + "=" + value;
        }
    }

    String getItem(String key) {
        int idx = hashFunction(key, this.table.length);
        return this.table[idx];

    }

    public static void main(String[] args) {
        Hash myTable = new Hash();
        myTable.putItem("firstName", "Angela");
        myTable.putItem("lastName", "Robert");
        myTable.putItem("age", "5");
        myTable.putItem("dob", "1/2/3");
        System.out.println(Arrays.toString(myTable.table));
        System.out.println(myTable.getItem("firstName"));
        System.out.println(myTable.getItem("last Name"));
        // System.out.println(charCodeAt("firstname", 0));
    }
}
