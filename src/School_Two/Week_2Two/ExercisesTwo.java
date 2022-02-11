package Week_2Two;

public class ExercisesTwo {
    static int factorial(int n) {
        if (n == 0)
            return 1;
        else
            return n * factorial(n - 1);
    }

    static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);

    }

    public static void main(String[] args) {
        int firstfact = 1;
        int number = 4;
        firstfact = factorial(number);
        System.out.println("Factorial of " + number + " is " + firstfact);

        int num = 9;
        int res = fibonacci(num);
        System.out.println("Fibonacci of " + num + " is " + res);
    }
}
