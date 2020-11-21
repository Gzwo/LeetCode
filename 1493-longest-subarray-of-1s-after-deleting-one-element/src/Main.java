import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums;

        /* 测试应当包括：空数组(null)、长度为0的数组、全1数组、全0数组、一般化的数组 */

        nums = new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1};
        System.out.println(solution.longestSubarray(nums)); // 5

        nums = new int[]{1, 1, 1};
        System.out.println(solution.longestSubarray(nums)); // 2

        nums = new int[]{0, 0, 0};
        System.out.println(solution.longestSubarray(nums)); // 0


    }
}

class Solution {
    public int longestSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] zeros = new int[nums.length + 2];
        Arrays.fill(zeros, nums.length);
        zeros[0] = -1;

        for (int i = 0, j = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros[j++] = i;
            }
        }

        int longest = 0;
        for (int i = 0; i < zeros.length - 2; i++) {
            longest = Math.max(longest, zeros[i + 2] - zeros[i] - 2);
        }

        return longest;
    }
}