package v1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr;
        int k;

        arr = new int[]{4, 3, 1, 1, 3, 3, 2};
        k = 3;
        System.out.println(solution.findLeastNumOfUniqueInts(arr, k));

        arr = new int[]{5, 4, 5};
        k = 1;
        System.out.println(solution.findLeastNumOfUniqueInts(arr, k));
    }
}

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {

        if (arr == null || arr.length == 0 || arr.length <= k) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int e : arr) {
            int count = map.getOrDefault(e, 0);
            count++;
            map.put(e, count);
        }

        Integer[] counts = map.values().toArray(new Integer[0]);
        Arrays.sort(counts);

//        for (int i = 0; i < counts.length; i++) {
//            System.out.println("i: " + i + ", counts[i]: " + counts[i]);
//        }

        for (int i = 0; i < counts.length; i++) {
            if (k < counts[i]) {
                return counts.length - i;
            }
            k -= counts[i];
        }
        /* 这一句应当不会被访问到 */
        return 0;
    }
}