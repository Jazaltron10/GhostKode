package Week_3Three;

public class Binary3s {
    private static class Node {
        int data;
        Node left, right; 
        Node( int num ) { 
            this.data = num;
            left = right = null;
        }
    }
    
    // The root of the Binary tree
    private Node root;
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
