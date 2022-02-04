package Week_1One;

import java.util.Scanner;
import TextIO.TextIO;

public class ExOne1 {

    /**
     * This program will compute and print one of the solutions
     * to an equation of the form A*X*X + B*X + C = 0, where
     * A, B, and C are numbers entered by the user. It depends
     * on the non-standard class TextIO for doing input/output.
     */

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        double A, B, C; // Coefficients in the equation.
        double results; // The results computed for the equation.
        boolean runAgain; // Set to true if the user wants to
                          // solve another equation.

        System.out.println("This program will compute and print one of the solutions");

        do {

            /* Get the coefficients from the user. */
            System.out.println("Enter values for A, B, and C:");
            System.out.println("A = ");
            A = scan.nextDouble();
            System.out.println("B = ");
            B = scan.nextDouble();
            System.out.println("C = ");
            C = scan.nextDouble();
            /*
             * Print the solution, or an error message, if
             * there is no solution.
             */

            try {
                results = root(A, B, C);
                System.out.println("A solution for this equation is " + results);
            } catch (IllegalArgumentException e) {
                System.out.println("Sorry, a solution can't be found.");
                System.out.println(e.getMessage());
            }

            /*
             * Ask the user if they want to solve another equation.
             */
            System.out.println("Do you want to solve another equation? ");
            runAgain = TextIO.getlnBoolean();

        } while (runAgain);
        scan.close();
    } // end main

    /**
     * Returns the larger of the two roots of the quadratic equation
     * A*x*x + B*x + C = 0, provided it has any roots. If A == 0 or
     * if the discriminant, B*B - 4*A*C, is negative, then an exception
     * of type IllegalArgumentException is thrown.
     */
    static public double root(double A, double B, double C)
            throws IllegalArgumentException {
        if (A == 0) {
            throw new IllegalArgumentException("A can't be zero.");
        } else {
            double disc = B * B - 4 * A * C;
            if (disc < 0)
                throw new IllegalArgumentException("Discriminant < zero.");
            return (-B + Math.sqrt(disc)) / (2 * A);
        }
    }

} // end class
