package Week_4Four.Lab_8;

// import java.io.*;

public class Sony {
    String model;
    String blockBusterGame;
    int price;
    int prodYear;

    public Sony(String model, String blockBusterGame, int price, int prodYear) {
        this.model = model;
        this.blockBusterGame = blockBusterGame;
        this.price = price;
        this.prodYear = prodYear;
    }

    public void getInfo() {
        System.out.println("Model: " + model);
        System.out.println("price: " + price);
        System.out.println("prodYear: " + prodYear);
    }

    // Overriding using hashCode() method
    @Override
    public int hashCode() {
        /*
         * overriding hashCode() method
         * to check the length of the names
         */
        return this.blockBusterGame.length() % 10;
    }

    public static void main(String[] args) {
        Sony console_1 = new Sony("Playstation_5", "Miles Morales", 500, 2020);
        // console_1.getInfo();
        Sony console_2 = new Sony("Playstation_5", "Miles Morales", 500, 2020);
        // console_2.getInfo();
        Sony console_3 = new Sony("Playstation_4", "The Last Of Us Part 2", 400, 2013);
        // console_3.getInfo();

        System.out.println(console_2.hashCode());
        /**
         * Using the equals() method
         */
        if (console_1.model.equals(console_2.model)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
        if (console_1.model.equals(console_3.model)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

        /**
         * Using the hashcode() method
         */
        // if the hashcode of console_1 and console_2 are equal, then they are equal
        if (console_1.hashCode() == console_2.hashCode()) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
        // if the hashcode of console_1 and console_2 are equal, then they are equal
        if (console_1.hashCode() == console_3.hashCode()) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }
}
