package v2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr;
        int k;
        int[] kStrongest;

        arr = new int[]{1, 1, 3, 5, 5};
        k = 2;
        kStrongest = solution.getStrongest(arr, k);
        for (int num : kStrongest) {
            System.out.printf("%3d", num);
        }
        System.out.println();

        arr = new int[]{6, 7, 11, 7, 6, 8};
        k = 5;
        kStrongest = solution.getStrongest(arr, k);
        for (int num : kStrongest) {
            System.out.printf("%3d", num);
        }
        System.out.println();

        arr = new int[]{-7, 22, 17, 3};
        k = 2;
        kStrongest = solution.getStrongest(arr, k);
        for (int num : kStrongest) {
            System.out.printf("%3d", num);
        }
        System.out.println();
    }
}

class Solution {
    public int[] getStrongest(int[] arr, int k) {
        /* 处理特殊情形 */
        if (arr.length == k) return arr;

        /* 初始化答案数组 */
        int[] kStrongest = new int[k];

        /* 排序 */
        Arrays.sort(arr);

        /* 取中位数 m */
        int m = arr[(arr.length - 1) / 2];

        /* 双指针填充答案 */
        int l = 0, r = arr.length - 1;
        for (int i = 0; i < k; i++) {
            if (m - arr[l] > arr[r] - m) {
                kStrongest[i] = arr[l];
                l++;
            } else {
                kStrongest[i] = arr[r];
                r--;
            }
        }

        return kStrongest;
    }
}