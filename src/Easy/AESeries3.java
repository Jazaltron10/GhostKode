import java.util.Random;

public class AESeries3 {
    public int commonSense(int num, int hom) {
        return num + hom ;
    }

    public void matureSense(){
        
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int num = rand.nextInt(30);
        int hom = rand.nextInt(20);

        System.out.println("\n\nHello");
        AESeries3 Jon = new AESeries3();
        int ans = 0;
        for(int i = 0; i < 5; i++){
            ans = Jon.commonSense(num, hom);
        }
        System.out.println("The answer is " + ans);
    }
}
