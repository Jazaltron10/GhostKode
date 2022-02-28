package Week_5Five;

import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;

public class MapInterface {
    private static DecimalFormat df = new DecimalFormat("#.##");

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        Random rand = new Random();
        map.put("a", df.format(rand.nextDouble(10)));
        map.put("b", df.format(rand.nextDouble(10)));
        map.put("d", df.format(rand.nextDouble(10)));
        map.put("w", df.format(rand.nextDouble(10)));
        map.put("k", df.format(rand.nextDouble(10)));
        map.put("a", df.format(rand.nextDouble(10)));
        System.out.println(map);

        Set<String> Keys = map.keySet();
        Iterator<String> Keyiter = Keys.iterator();
        System.out.println("\n\n\nThe map contains the following associations:");
        while (Keyiter.hasNext()) {
            String key = Keyiter.next();
            String value = map.get(key);
            System.out.println(key + " : " + value);
        }

        // Alternative way to print the map using the for loop
        System.out.println("\n\n\nThe map contains the following associations:");
        for (String Key : map.keySet()) {
            String value = map.get(Key);
            System.out.println("(" + Key + " : " + value + ")");
        }

        // Alternative way to print the map using the Map.Entry class
        // The elements of the set below are of type Map.Entry<K,V>.

        Set<Map.Entry<String, String>> entries = map.entrySet();
        Iterator<Map.Entry<String, String>> entryIter = entries.iterator();
        System.out.println("\n\n\nThe map contains the following associations:");
        while (entryIter.hasNext()) {
            Map.Entry<String, String> entry = entryIter.next();
            String key = entry.getKey(); // Get the key from the entry
            String value = entry.getValue(); // Get the value
            System.out.println("(" + key + " : " + value + ")");
        }

        // Alternative way to print the map using the Map.Entry class and the for-each
        // loop
        System.out.println("\n\n\nThe map contains the following associations:");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("(" + entry.getKey() + " : " + entry.getValue() + ")");
        }
    }
}
