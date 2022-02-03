package Week_1One;
import java.util.Arrays;
// import java.util.ArrayList;
import java.util.Scanner;
public class Programming_Assignment_1one {
    public static void main(String[] args) {
        System.out.println("Please enter a number");
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        switch(N){
            case 1:
                System.out.println("The number is 1. ");
                break;
            case 2:
            case 4:
            case 8:
                System.out.println("The number is 2, 4, or 8. ");
                System.out.println("(That's a power of 2!)");
                break;
                case 3:
            case 6:
            case 9:
                System.out.println("The number is 3, 6, or 9.");
                System.out.println("(That's a multiple of 3!)");
                break;
            case 5:
                System.out.println("The number is 5");
                break;
            default: 
                System.out.println("The number is 7 or is outside the range 1 to 9.");         
        }   
        scan.close();
        double reas = areaOfRectangle(9.0 , 7.8);
        System.out.println("The area of the rectangle is " + reas);
        
        int[][] a = new int[][] { {1,2,3}, {4,5,6}, {7,8,9} };
        int[][] b = rotateImage(a);
        System.out.println(Arrays.deepToString(b));
    }
    /**
    *This subroutine computes the area of a rectangle, given its width
    *and its height. The length and the width should be positive numbers.
    *@param width the length of one side of the rectangle
    *@param height the length the second side of the rectangle
    *@return the area of the rectangle
    *@throws IllegalArgumentException if either the width or the height
    *is a negative number.
    */
public static double areaOfRectangle( double height, double width ) {
    if ( width < 0 || height < 0 )
    throw new IllegalArgumentException("Sides must have positive length.");
    double area;
    area = width * height;
    return area;
    }
public static int[][] rotateImage(int[][] a) {
            System.out.print(Arrays.deepToString(a));
            System.out.print("\n\n\n");
            for(int i = 0; i < a.length ; i++){
                for(int j = i; j < a.length; j++){
                    int temp = a[i][j];
                    a[i][j] = a[j][i];
                    a[j][i] = temp;
                }
            }
            int n = a.length;
            for(int i = 0; i < a.length ; i++){
                for(int j = 0; j < a.length/2; j++){
                    int tem = a[i][j];
                    a[i][j] = a[i][n-1-j];
                    a[i][n-1-j] = tem;
                }
            }
            System.out.print(Arrays.deepToString(a));
            return a;
        }
    
    static void printMatrix(int[][] a){
        
    }
}
