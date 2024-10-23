import java.util.Random;

public class AESeries3 {
    public int commonSense(int num, int hom) {
        return num + hom;
    }

    public static void matureSense() {
        int[] month = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        for (int i = 0; i < month.length; i++) {
            System.out.println(month[i] + "\n");
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int num = rand.nextInt(30);
        int hom = rand.nextInt(20);

        System.out.println("\n\nHello");
        AESeries3 Jon = new AESeries3();
        int ans = 0;
        for (int i = 0; i < 5; i++) {
            ans = Jon.commonSense(num, hom);
        }
        System.out.println("The answer is " + ans);

        System.out.println("\n");
        matureSense();

    }
}
