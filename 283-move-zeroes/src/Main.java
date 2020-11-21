public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums;

        nums = new int[]{0, 1, 0, 3, 12};
        solution.moveZeroes(nums);
        for (int num : nums) {
            System.out.printf("%3d", num);
        }
        System.out.println();

        nums = new int[]{1, 2, 0, 3, 4, 0, 5, 6};
        solution.moveZeroes(nums);
        for (int num : nums) {
            System.out.printf("%2d", num);
        }
        System.out.println();


    }
}

class Solution {
    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int idx = 0, nonZeroIdx = 0; idx < nums.length; idx++) {
            if (nums[idx] != 0) {
                nums[nonZeroIdx] = nums[idx];
                nonZeroIdx++;
            } else {
                count++;
            }
        }
        for (int i = 1; i <= count; i++) {
            nums[nums.length - i] = 0;
        }
    }
}