package Week_5Five;

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
public class HashTable {

    static int run(int[] arr) {
        int home = 0;
        int away = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                home++;
            } else {
                away++;
            }
        }
        if (home > away || home == away) {
            return home;
        } else {
            return away;
        }

    }

    public static void main(String[] args) {
        int ans = run(new int[] { 1, 2, 1, 2, 2, 2, 2, 2, 2 });
        System.out.println(ans);
    }
}
