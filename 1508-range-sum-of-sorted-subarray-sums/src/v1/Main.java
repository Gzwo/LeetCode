package v1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums;
        int n, left, right;

        nums = new int[]{1, 2, 3, 4};
        n = 4;
        left = 1;
        right = 5;
        System.out.println(solution.rangeSum(nums, n, left, right));
    }
}

/* brutal force */
class Solution {

    private static final int MOD = 1_000_000_007;

    public int rangeSum(int[] nums, int n, int left, int right) {

        if (nums == null || nums.length == 0 || n == 0) return 0;

        int sn = n * (n + 1) / 2;

        int[] sums = new int[sn];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                sums[idx++] = sum;
            }
        }

        Arrays.sort(sums);

        long answer = 0;
        for (int i = left - 1; i < right; i++) {
            answer += sums[i];
            answer %= MOD;
        }

        return (int) answer;
    }
}