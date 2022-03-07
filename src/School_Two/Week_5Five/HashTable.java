package Week_5Five;

// import java.util.Scanner;

// import TextIO.TextIO;

public class HashTable {
    private static class linkedListNode {
        String key;
        String value;
        linkedListNode next;
    }

    // creating an array of the type linked list nodes
    private linkedListNode[] table;

    private int countNodes; // a variable to count the key, value pairs in the hash table

    // Constructors
    public HashTable() {
        table = new linkedListNode[100];
    }

    public HashTable(int initialSize) {
        table = new linkedListNode[initialSize];
    }

    private int hash(Object key) {
        return (Math.abs(key.hashCode())) % table.length;
    }

    public void put(String key, String value) {

        assert key != null : "The key must be non-null";

        int bucket = hash(key);

        linkedListNode list = table[bucket];
        while (list != null) {
            if (list.key.equals(key))
                break;
            list = list.next;
        }
        if (list != null) {
            list.value = value;
        } else {
            if (countNodes >= 0.75 * table.length) {
                resize();
            }
            linkedListNode newNode = new linkedListNode();
            newNode.key = key;
            newNode.value = value;
            newNode.next = table[bucket];
            table[bucket] = newNode;
            countNodes++;
        }
    }

    public String get(String key) {
        int bucket = hash(key);

        linkedListNode list = table[bucket];
        while (list != null) {
            if (list.key.equals(key))
                return list.value;
            list = list.next;
        }
        return null;
    }

    public void remove(String key) {

        int bucket = hash(key);

        if (table[bucket] == null) {
            return;
        }

        if (table[bucket].key.equals(key)) {
            table[bucket] = table[bucket].next;
            countNodes--;
            return;
        }
        linkedListNode prev = table[bucket];
        linkedListNode curr = prev.next;
        while (curr != null && !curr.key.equals(key)) {
            curr = curr.next;
            prev = curr;
        }
        if (curr != null) {
            prev.next = curr.next;
            countNodes--;
        }
        System.out.println(key + "has been removed");
    }

    public boolean containsKey(String key) {

        int bucket = hash(key);

        linkedListNode list = table[bucket];
        while (list != null) {
            if (list.key.equals(key))
                return true;
            list = list.next;
        }
        return false;
    }

    public int size() {
        return countNodes;
    }

    private void resize() {
        linkedListNode[] newtable = new linkedListNode[table.length * 2];
        for (int i = 0; i < table.length; i++) {
            linkedListNode list = table[i];
            while (list != null) {
                linkedListNode next = list.next;
                int hash = (Math.abs(list.key.hashCode())) % newtable.length;
                list.next = newtable[hash];
                newtable[hash] = list;
                list = next;
            }
        }
        table = newtable;
    }

    public static void main(String[] args) {
        HashTable table = new HashTable(20); // Initial size of table is 2.
        // String key, value;
        table.put("key", "alue");
        table.put("key2", "alue2");
        System.out.println(table.get("key"));
        System.out.println(table);

        // Scanner scan = new Scanner(System.in);
        // for (int i = 0; i < 5; i++) {
        // System.out.println("Enter key: ");
        // key = scan.nextLine();
        // System.out.println("Enter value: ");
        // value = scan.nextLine();
        // table.put(key, value);
        // }
        System.out.println(table.size());
        table.remove("this");
        System.out.println(table.size());
        // scan.close();
    }

} // end class HashTable
