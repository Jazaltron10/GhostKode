package Week_6Six.Files;

import java.io.*;
import java.util.*;

/**
 * Reads numbers from a file named data.dat and writes them to a file
 * named result.dat in reverse order. The input file should contain
 * only real numbers.
 */
public class ReadFile {
    public static void main(String[] args) {
        Scanner data; // Scanner object for reading data.dat
        PrintWriter result; // PrintWriter object for writing to result.dat

        ArrayList<Double> numbers; // ArrayList of doubles to hold the data
        numbers = new ArrayList<Double>();

        try { // create the input stream.
            data = new Scanner(new File("Week_6Six/Files/data.dat"));
        } catch (FileNotFoundException e) {
            System.out.println("can't find the file data.dat!");
            return; // End the program by returning from main().
        }
        try { // create the output stream.
            result = new PrintWriter("Week_6Six/Files/result.dat");
        } catch (FileNotFoundException e) {
            System.out.println("can't find the file result.dat!");
            System.out.println("Error: " + e);
            data.close();
            return; // End the program by returning from main().
        }
        while (data.hasNextDouble()) { // Read until end-of-file
            double inputNumber = data.nextDouble(); // Read the next number
            numbers.add(inputNumber); // Add the number to the ArrayList
        }

        ArrayList<Double> reverse = new ArrayList();
        // Output the numbers in reverse order
        for (int i = numbers.size() - 1; i >= 0; i--) {
            result.println(numbers.get(i));
            reverse.add(2*numbers.get(i));
        }
        System.out.println("The numbers in reverse order are: " + reverse);

        System.out.println("Done!");
        data.close(); // Close the input stream
        result.close(); // Close the output stream
    } // end of main()
} // end of class ReadFile
