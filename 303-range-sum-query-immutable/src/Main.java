public class Main {
    public static void main(String[] args) {
        int[] nums;
        int[][] queries;

        nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        queries = new int[][]{{0, 2}, {2, 5}, {0, 5}};
        for (int[] query : queries) {
            System.out.println(numArray.sumRange(query[0], query[1]));
        }
    }
}

class NumArray {

    private int[] prefixSums;

    public NumArray(int[] nums) {
        prefixSums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return prefixSums[j + 1] - prefixSums[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */