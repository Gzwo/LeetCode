public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums;

        nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(solution.findMin(nums));

        nums = new int[]{2, 3, 1};
        System.out.println(solution.findMin(nums));
    }
}

class Solution {
    public int findMin(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[0] < nums[m]) {
                l = m + 1;
            } else {
                if (nums[m] > nums[m + 1]) {
                    return nums[m + 1];
                } else {
                    r = m;
                }
            }
        }

        if (nums[l] < nums[l - 1]) {
            return nums[l];
        } else {
            return -1;
        }
    }
}