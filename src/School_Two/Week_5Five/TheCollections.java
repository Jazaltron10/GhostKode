package Week_5Five;

import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collections;

public class TheCollections {
    public static void main(String[] args) {
        // System.out.println("This program will compute union, intersection,");
        List <String> stringList = new ArrayList<String>();
        stringList.add("a"); 
        stringList.add("w");
        stringList.add("c"); 
        stringList.add("d"); 
        stringList.add("a"); 
        stringList.add("k"); 
        stringList.add("a"); 
        

        ArrayList<String> list = new ArrayList<>(new TreeSet<>(stringList));
        System.out.println(list);

        PriorityQueue <String> pq = new PriorityQueue<>();
        pq.addAll(stringList);
        System.out.println(pq);
        while(!pq.isEmpty()){
            System.out.println(pq.remove());
        }
        // Collections.sort(stringList);
        // System.out.println(stringList);
        // Collections.shuffle(stringList);
        // System.out.println(stringList);
        // Collections.reverse(stringList);
        // System.out.println(stringList);

        // Subrange Query
    }
}
