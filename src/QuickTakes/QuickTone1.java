public class QuickTone1 {
    public static void stringSpaces(String word) {
        for (char c : word.toCharArray()) {
            // System.out.printf("%n%s", c);

            if (c == ' ') {
                System.out.println(c + " :-> This is just empty space");
                word = word.replace(c, '2');
            } else if (c != ' ') {
                System.out.println(c + " :-> There is something definitely here");
            }

        }
        System.out.printf("\nThe new string is :-> %s", word);
    }

    public static void main(String[] args) {
        // stringSpaces("I will be great");
        // System.out.println("\n\n");
        // stringSpaces("I will be gr e at");
        System.out.println("\n\nHello World");

        String Jane = "C a l c o";
        // System.out.println("\n\n"+Jane+"%" +"20");
        for (char c : Jane.toCharArray()) {
            if(c == ' ') {
                c = '%' + '2' + '0';
            }
            // System.out.println("\n\n" + Jane);
        }
        for(int i = 0; i < Jane.length(); i++) {
            System.out.println("\n\n" + Jane);
        }
        
        char cow = ' ';
        System.out.println("\n\n 1" + cow);
        cow += '%' + '2' + '0'; 
        System.out.println("\n\n 2" + cow);

    }
}
