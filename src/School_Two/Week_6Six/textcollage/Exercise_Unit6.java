package Week_6Six.textcollage;

import java.io.File;
import java.util.Scanner;

/**
 * This program lists the files in a directory specified by
 * the user. The user is asked to type in a directory name.
 * If the name entered by the user is not a directory, a
 * message is printed and the program ends.
 */
public class Exercise_Unit6 {

    public static void main(String[] args) {

        String directoryName; // Directory name entered by the user.
        File directory; // File object referring to the directory.
        Scanner scanner; // For reading a line of input from the user.

        scanner = new Scanner(System.in); // scanner reads from standard input.

        System.out.print("Enter a directory name: ");
        directoryName = scanner.nextLine().trim();
        directory = new File(directoryName);

        if (directory.isDirectory() == false) {
            if (directory.exists() == false)
                System.out.println("There is no such directory!");
            else
                System.out.println("That file is not a directory.");
        } else {
            contentsOfDirectory(directory, "");
        }

    } // end main()

    /**
     * This is a recursive subroutine that lists all the files in a
     * directory and all its subdirectories.
     * @param dir is the directory whose contents are to be listed
     * @param delimeter is the string that separates the names of files
     */
    private static void contentsOfDirectory(File dir, String delimiter) {
        String[] files = dir.list();
        delimiter += " ";
        files = dir.list();
        System.out.println(delimiter + "Files in directory\" " + dir.getName() + "\":");
        for (int i = 0; i < files.length; i++) {
            File f = new File(dir, files[i]);
            if (f.isDirectory()) {
                System.out.println(delimiter + files[i]);
                contentsOfDirectory(f, delimiter + "   ");
            } else {
                System.out.println(delimiter + files[i]);
            }
        }
    }
} // end class DirectoryList
