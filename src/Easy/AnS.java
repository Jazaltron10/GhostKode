// package Easy;
public class AnS {
    static void Uniquechar() {
        String name = "String as name in las venturas";
        String ame = "123456";
        StringBuilder s = new StringBuilder();
        s.append("Japan ");
        System.out.println(s);
        for (int i = 0; i < name.length(); i++) {
            // System.out.println(name.charAt(i));
            s.append(name.charAt(i));
        }
        System.out.println(s);
        name.split(" ,");
        System.out.println(ame);
    }
    
    public static void main(String[] args) {
        Uniquechar();
        int [] a = new int[] {8,9,1,2,4,3,2,3,2,2};
        AnS cas = new AnS();
        int result = cas.solution(a);
        System.out.println("result: " + result);

    }

    int solution(int[] a) {
        int count = 0 ;
        int i = 0 ; 
        int j = 1 ;
        int k = 2 ;
        while(k < a.length){
            if(a[i] == a[j] && a[i] != a[k]){
                count +=1;           
            }
            else if (a[i] == a[k] && a[i] != a[j]){
                count +=1;           
            } 
            else if (a[k] == a[j] && a[k] != a[i]){
                count +=1;           
            }
            i++;
            j++;
            k++;
        }
        return count; 
    }

}

