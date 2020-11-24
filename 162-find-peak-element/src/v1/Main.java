package v1;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums;
        int peak;

        nums = new int[]{1, 2, 3, 1};
        peak = solution.findPeakElement(nums);
        System.out.println("peak index: " + peak);

    }
}

class Solution {
    public int findPeakElement(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return 0;
        }

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;

            if (nums[m] > nums[m + 1]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}