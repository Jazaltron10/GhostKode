package Week_5Five;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.io.IOException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.HashSet; // Import the HashSet class
import java.util.TreeSet; // Import the TreeSet class           
import java.util.StringTokenizer; // Import the StringTokenizer class
import javax.swing.JFileChooser; // Import the JFileChooser class

public class Check {
    public static void main(String[] args) throws IOException {
        try {
            File fileObj = new File("Week_5Five/Help.txt");
            Scanner fileReader = new Scanner(fileObj);
            HashSet<String> hash = new HashSet();
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                // Adding words into set from "words.txt"
                hash.add(data.toLowerCase());
                // System.out.println(data);
            }
            fileReader.close();
            Scanner userFile = new Scanner(getInputFileNameFromUser());
            userFile.useDelimiter("[^a-zA-Z]+");
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

    static TreeSet wordCorrections(String misSpelledWord, HashSet dictionary) {
        TreeSet<String> tree = new TreeSet<String>();
        // Delete any one of the letters from the misspelled word, then check if exist
        // in the dictionary.
        for (int i = 0; i < misSpelledWord.length(); i++) {
            String s = misSpelledWord.substring(0, i) + misSpelledWord.substring(i + 1);
            if (dictionary.contains(s)) {
                tree.add(s);
            }
        }
        // Change any letter in the misspelled word to any other letter , then check if
        // exist in the dictionary.
        for (int i = 0; i < misSpelledWord.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                String s = misSpelledWord.substring(0, i) + ch + misSpelledWord.substring(i + 1);
                if (dictionary.contains(s)) {
                    tree.add(s);
                }
            }
        }
        // Insert any letter at any point in the misspelled word ,then check if exist in
        // the dictionary.
        for (int i = 0; i <= misSpelledWord.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                String s = misSpelledWord.substring(0, i) + ch + misSpelledWord.substring(i);
                if (dictionary.contains(s)) {
                    tree.add(s);
                }
            }
        }
        // Swap any two neighboring characters in the misspelled word, then check if
        // exist in the dictionary.
        for (int i = 0; i < misSpelledWord.length() - 1; i++) {
            String s = misSpelledWord.substring(0, i) + misSpelledWord.substring(i + 1, i + 2) +
                    misSpelledWord.substring(i, i + 1) + misSpelledWord.substring(i + 2);
            if (dictionary.contains(s)) {
                tree.add(s);
            }
        }
        // Insert a space at any point in the misspelled word (and check that
        // both of the words that are produced are in the dictionary)
        for (int i = 1; i < misSpelledWord.length(); i++) {
            String stringInput = misSpelledWord.substring(0, i) + " " + misSpelledWord.substring(i);
            String newWord = "";
            // break a string into tokens and add it to tokenWords
            StringTokenizer tokenWords = new StringTokenizer(stringInput);
            // Loop over all words in tokenWords.
            while (tokenWords.hasMoreTokens()) {
                // Store each word in a temp string.
                String word_1One = tokenWords.nextToken();
                String word_2Two = tokenWords.nextToken();
                // Check if temp words exist in dictionary otherwise break
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