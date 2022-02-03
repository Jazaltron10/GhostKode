package Week_1One;

public class Home {
    public static void main(String[] args) {
        int nOne, nTwo;
        try {
            /*
             * We suspect that this block of statement can throw
             * exception so we handled it by placing these statements
             * inside try and handled the exception in catch block
             */
            nOne = 0;
            nTwo = 100 / nOne;
            System.out.println(nTwo);
            System.out.println("Hey I'm at the end of try block");
        } catch (ArithmeticException e) {
            /*
             * This block will only execute if any Arithmetic exception
             * occurs in try block
             */
            System.out.println("You should not divide a number by zero");
        } catch (Exception e) {
            /*
             * This is a generic Exception handler which means it can handle
             * all the exceptions. This will execute if the exception is not
             * handled by previous catch blocks.
             */
            System.out.println("Exception occurred");
        }
        System.out.println("I'm out of try-catch block in Java.");
    }
    // Output:

    // You should not divide a number by zero
    // I'm out of try-catch block in Java.
}
