package v2;

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
        for (int i = 0; i < n; i++) {
            if(arr[i])
        }
    }
}