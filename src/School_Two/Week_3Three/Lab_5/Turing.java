package Week_3Three.Lab_5;

public class Turing {
    public static void main(String[] args) {
        String word_1 = "Hello World! How are you?";
        String word_2 = "Born on Monday, I ate on Tuesday.";
        String word_3 = "Went to Metropolis to see Superman";
        String word_4 = "CR7 is the greatest footballer of all time";
        String word_5 = "Pizza is the best food in the world";

        Tape testTape = new Tape();
        for (int i = 0; i < word_1.length(); i++) {
            testTape.setContent(word_1.charAt(i));
            testTape.moveRight();
        }
        for (int i = 0; i < word_1.length(); i++) {
            testTape.moveLeft();
        }
        for (int i = 0; i < word_1.length(); i++) {
            testTape.setContent(word_1.charAt(i));
            testTape.moveRight();
        }
        System.out.println("Tape Contents: " + testTape.getTapeContents());
        testTape.moveRight();
        // System.out.println("Final position at the " + testTape.getContent());

    }
}
