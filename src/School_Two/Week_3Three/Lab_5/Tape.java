package Week_3Three.Lab_5;

/**
 * This class Represents the tape in class TuringMachine
 * (see{@link TuringMachine})
 * The tape is created using Cell (see {@link Cell})
 * Each method has it's describe
 */
public class Tape {
    // create an instance variable for a Cell to use in the tape
    private Cell currentCell;

    // Default constructor
    public Tape() {
        // Initializes a new cell.
        Cell newCell = new Cell();
        newCell = new Cell();
        newCell.content = ' ';
        newCell.next = null;
        newCell.prev = null;
        currentCell = newCell;
    }

    /**
     * public Cell getCurrentCell()
     * 
     * @return the pointer that points to the current cell.
     */
    public Cell getCurrentCell() {
        return currentCell;
    }

    /**
     * Getter method that returns the char from the current cell.
     * public char getContent()
     * 
     * @return the char from the current cell.
     */
    public char getContent() {
        return currentCell.content;
    }

    // Setter method the set the char in the current cell to the specified value.
    public void setContent(char ch) {
        currentCell.content = ch;
    }

    /**
     * The method moves the tape one cell to the left.
     */
    public void moveLeft() {
        // Create a new cell, if no cell exists to the left.
        if (currentCell.prev == null) {
            Cell newCell = new Cell();
            newCell.content = ' ';
            newCell.next = currentCell;
            newCell.prev = null;
            currentCell.prev = newCell;
        }
        currentCell = currentCell.prev;

    }

    /**
     * The method moves the tape one cell to the right.
     */
    public void moveRight() {
        // Create a new cell, if no cell exists to the right.
        if (currentCell.next == null) {
            Cell newCell = new Cell();
            newCell.content = ' ';
            newCell.prev = currentCell;
            newCell.next = null;
            currentCell.next = newCell;
        }
        currentCell = currentCell.next;
    }

    /**
     * public String getTapeContents()
     * 
     * @return a String consisting of the chars from all the cells on the tape, read
     *         from left to right,
     *         except that leading or trailing blank characters should be discarded.
     *
     */
    public String getTapeContents() {
        Cell cellPointer = currentCell;
        while (cellPointer.prev != null)
            cellPointer = cellPointer.prev;
        StringBuilder contents = new StringBuilder();
        while (cellPointer != null) {
            contents.append(cellPointer.content);
            cellPointer = cellPointer.next;
        }
        // Returns the contents of the tape.
        return contents.toString().trim();
    }
}