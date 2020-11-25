public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums;
        int target;
        int[] range;

        nums = new int[]{5, 7, 7, 8, 8, 10};
        target = 8;
        range = solution.searchRange(nums, target);
        System.out.println("left: " + range[0] + ", right: " + range[1]); // 3, 4

        nums = new int[]{5, 7, 7, 8, 8, 8, 8, 8, 10};
        target = 8;
        range = solution.searchRange(nums, target);
        System.out.println("left: " + range[0] + ", right: " + range[1]); // 3, 7

        nums = new int[]{5, 7, 7, 8, 8, 8, 8, 8, 10};
        target = 4;
        range = solution.searchRange(nums, target);
        System.out.println("left: " + range[0] + ", right: " + range[1]); // -1, -1

        nums = new int[]{5, 7, 7, 8, 8, 8, 8, 8, 10};
        target = 11;
        range = solution.searchRange(nums, target);
        System.out.println("left: " + range[0] + ", right: " + range[1]); // -1, -1

        nums = new int[]{5, 7, 7, 8, 8, 8, 8, 8, 10};
        target = 6;
        range = solution.searchRange(nums, target);
        System.out.println("left: " + range[0] + ", right: " + range[1]); // -1, -1

        nums = null;
        target = 6;
        range = solution.searchRange(nums, target);
        System.out.println("left: " + range[0] + ", right: " + range[1]); // -1, -1

        nums = new int[]{1, 2};
        target = 2;
        range = solution.searchRange(nums, target);
        System.out.println("left: " + range[0] + ", right: " + range[1]); // 1, 1

        nums = new int[]{1};
        target = 1;
        range = solution.searchRange(nums, target);
        System.out.println("left: " + range[0] + ", right: " + range[1]); // 0, 0

        nums = new int[]{2, 2};
        target = 2;
        range = solution.searchRange(nums, target);
        System.out.println("left: " + range[0] + ", right: " + range[1]); // 0, 1


    }
}

class Solution {
    public int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        return new int[]{findLeft(nums, target), findRight(nums, target)};

    }

    private int findLeft(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            if (nums[m] >= target) {
                r = m;
            } else if (nums[m] < target) {
                l = m;
            }
        }
        if (nums[l] == target) {
            return l;
        }
        if (nums[r] == target) {
            return r;
        }

        return -1;
    }

    private int findRight(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > target) {
                r = m;
            } else if (nums[m] <= target) {
                l = m;
            }
        }
        if (nums[r] == target) {
            return r;
        }
        if (nums[l] == target) {
            return l;
        }

        return -1;
    }
}