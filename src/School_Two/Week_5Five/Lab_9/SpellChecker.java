package Week_5Five.Lab_9;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.io.IOException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.HashSet; // Import the HashSet class
import java.util.TreeSet; // Import the TreeSet class           
import java.util.StringTokenizer; // Import the StringTokenizer class
import javax.swing.JFileChooser; // Import the JFileChooser class

public class SpellChecker {
    public static void main(String[] args) throws IOException {
        try {
            // Scanning the words from the words.txt file
            File fileObj = new File("Week_5Five/Lab_9/wordas.txt");
            Scanner fileReader = new Scanner(fileObj);
            // Creating a HashSet to store the words from the words.txt file
            HashSet<String> hash = new HashSet();
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                // Converting words into lowercase then adding them onto the HashSet
                hash.add(data.toLowerCase());
                System.out.println(data);
            }
            fileReader.close(); // Closing the fileReader
            Scanner userFile = new Scanner(getInputFileNameFromUser());
            userFile.useDelimiter("[^a-zA-Z]+"); // Using the delimiter to read the file
            while (userFile.hasNext()) {
                String line = userFile.next();
                String lineLC = line.toLowerCase();
                if (!hash.contains(lineLC)) {
                    System.out.println(lineLC + ":" + wordCorrections(lineLC, hash));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. File Not Found...");
            e.printStackTrace();
        }
    }

    /**
     * This method is used to find the corrections for the misspelled word
     * 
     * @param misSpelledWord
     * @param dictionary
     * @return TreeSet containing all the corrections for the misspelled word
     */
    static TreeSet wordCorrections(String misSpelledWord, HashSet dictionary) {
        // Creating a TreeSet to store the corrections
        TreeSet<String> tree = new TreeSet<String>();
        // Checking if a letter exists in the dictionary after deleting it from the
        // misspelled word.
        for (int i = 0; i < misSpelledWord.length(); i++) {
            String s = misSpelledWord.substring(0, i) + misSpelledWord.substring(i + 1);
            if (dictionary.contains(s)) {
                tree.add(s);
            }
        }
        // Checking if a letter exists in the dictionary after changing it in the
        // misspelled word.
        for (int i = 0; i < misSpelledWord.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                String s = misSpelledWord.substring(0, i) + ch + misSpelledWord.substring(i + 1);
                if (dictionary.contains(s)) {
                    tree.add(s);
                }
            }
        }
        // Checking if a letter exists in the dictionary after inserting it in the
        // misspelled word.
        for (int i = 0; i <= misSpelledWord.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                String s = misSpelledWord.substring(0, i) + ch + misSpelledWord.substring(i);
                if (dictionary.contains(s)) {
                    tree.add(s);
                }
            }
        }
        // Checking if a letter exists in the dictionary after swapping it with an
        // adjacent character in the misspelled word.
        for (int i = 0; i < misSpelledWord.length() - 1; i++) {
            String s = misSpelledWord.substring(0, i) + misSpelledWord.substring(i + 1, i + 2) +
                    misSpelledWord.substring(i, i + 1) + misSpelledWord.substring(i + 2);
            if (dictionary.contains(s)) {
                tree.add(s);
            }
        }
        // Inserting a space into the misspelled word at any point
        for (int i = 1; i < misSpelledWord.length(); i++) {
            String stringInput = misSpelledWord.substring(0, i) + " " + misSpelledWord.substring(i);
            String newWord = "";
            StringTokenizer tokenWords = new StringTokenizer(stringInput);
            // Loop over all words in tokenWords.
            while (tokenWords.hasMoreTokens()) {
                // Store each word in a temporary string.
                String word_1One = tokenWords.nextToken();
                String word_2Two = tokenWords.nextToken();
                // Check if the word is in the dictionary.
                if (dictionary.contains(word_1One) &&
                        dictionary.contains(word_2Two)) {
                    newWord = word_1One + " " + word_2Two;
                } else
                    break;
                tree.add(newWord);
            }
        }
        if (tree.isEmpty()) {
            tree.add("no suggestions");
        }
        return tree;
    }

    /**
     * This method is used to get the file name from the user
     * 
     * @return a new file object
     */
    static File getInputFileNameFromUser() {
        JFileChooser fileDialog = new JFileChooser();
        fileDialog.setDialogTitle("Select File for Input");
        int option = fileDialog.showOpenDialog(null);
        if (option != JFileChooser.APPROVE_OPTION)
            return null;
        else
            return fileDialog.getSelectedFile();
    }
}