// import java.util.ArrayList;
// import java.util.List;

public class XPrep {
    static void showOutput(int mark) {
        if (mark == 0) {
            System.out.println("*");
        } else {
            System.out.println("[");
            showOutput(mark - 1);
            System.out.println(",");
            showOutput(mark - 1);
            System.out.println("]");
        }
    }

    public static int factorial(int number) {
        if (number == 1) {
            return 1;
        } else {
            return number * (factorial(number - 1));
        }
    }

    public static void main(String[] args) {
        System.out.println("XPrep");
    }

}
