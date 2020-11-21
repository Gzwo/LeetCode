package v2;

import java.util.Arrays;

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

        Arrays.sort(arr);

        int pre = -1, distinct = 0;
        int[] counts = new int[arr.length];
        for (int i = 0, j = -1; i < arr.length; i++) {
            if (pre != arr[i]) {
                j++;
                pre = arr[i];
            }
            counts[j]++;
            distinct = j + 1;
        }

        Arrays.sort(counts, 0, distinct);

//        for (int count : counts) {
//            System.out.println(count);
//        }


        for (int i = 0; i < distinct; i++) {
            if (k < counts[i]) {
                return distinct - i;
            }
            k -= counts[i];
        }
        /* 这一句应当不会被访问到 */
        return 0;
    }
}