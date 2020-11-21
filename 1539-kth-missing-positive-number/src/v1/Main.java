package v1;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr;
        int k;

        arr = new int[]{2, 3, 4, 7, 11};
        k = 5;
        System.out.println(solution.findKthPositive(arr, k));

        arr = new int[]{1, 2, 3, 4};
        k = 2;
        System.out.println(solution.findKthPositive(arr, k));
    }
}

/* brutal force */
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        for (int i = 1, j = 0, count = 0; i <= n + k; i++) {
            if (j < n && i == arr[j]) {
                j++;
            } else {
                count++;
                if (count == k) {
                    return i;
                }
            }
        }
        /* this return statement is never used */
        return 0;
    }
}