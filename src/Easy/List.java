

public class List<T> {

    public void sort(Object object) {
    }

}


// reverse queries


// 12:50 AM: def performOperations(arr, operations):
//     for i, j in operations:
//         while i < j:
//             arr[i], arr[j] = arr[j], arr[i]
//             i += 1
//             j -= 1
//     return arr





// 12:50 AM:     public static List<Integer> performOperations(List<Integer> arr, List<List<Integer>> operations) {
//        for (List<Integer> op : operations) {
//            int start = op.get(0);
//            int end = op.get(1);
//            reverse(arr, start, end);
//        }
//        System.out.println("hello world");
//        return arr;

//     }
    
//     public static void reverse(List<Integer> list, int start, int end) {
//         while (start < end) {
//             int temp = list.get(start);
//             list.set(start, list.get(end));
//             list.set(end, temp);
//             start++;
//             end--;
//         }
//     }



// sortgroups
// Python
// 1:08 AM: def groupSort(arr):
//     cnt = {}
//     for x in arr:
//         cnt[x] = cnt.get(x, 0) + 1

//     res = sorted(cnt.items(), key=lambda e: (-e[1], e[0]))
//     return res 



// 1:11 AM: private static final Comparator<List<Integer>> COMPARE_COUNTS = new Comparator<List<Integer>>() {
//     @Override
//     public int compare(List<Integer> ca1, List<Integer> ca2) {
//         if (ca2.get(1) == ca1.get(1)) {
//            return ca1.get(0).compareTo(ca2.get(0)); 
//         }
//         return ca2.get(1).compareTo(ca1.get(1));
//     }  
//  };

//  public static List<List<Integer>> groupSort(List<Integer> arr) {
//     final Map<Integer, Integer> countMap = new HashMap();
//     for (Integer num : arr) {
//         if (countMap.containsKey(num)) {
//             int count = countMap.get(num);
//             count++;
//             countMap.put(num, count);
//         } else {
//             countMap.put(num, 1);
//         }
//     }
    
//     final List<List<Integer>> result = new ArrayList();
//     for (Map.Entry<Integer, Integer> countEntry : countMap.entrySet()) {
//         final int num = countEntry.getKey();
//         final int count = countEntry.getValue();
//         final List<Integer> countArray = new ArrayList();
//         countArray.add(num);
//         countArray.add(count);
//         result.add(countArray);
//     }
    
//     result.sort(COMPARE_COUNTS);
//     return result;
//  }




// '^[ab]$|^aa$|^bb$|^'
// "^[ab]$|^([ab]).*\\1$|^";