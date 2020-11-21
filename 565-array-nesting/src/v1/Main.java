package v1;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums;

        nums = new int[]{5, 4, 0, 3, 1, 6, 2};
        System.out.println(solution.arrayNesting(nums));
    }
}

class Solution {
    public int arrayNesting(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        boolean[] visited = new boolean[n];
        int maxRing = 0, visitedCount = 0;
        for (int i = 0; i < n; i++) {
            /* 假如当前位置未访问，从当前位置进入环 */
            int cur = i, count = 0;
            while (!visited[cur]) {
                visited[cur] = true;
                cur = nums[cur];
                count++;
                visitedCount++;
            }
            maxRing = Math.max(maxRing, count);
            /* 剪枝：未访问的位置数不大于 maxRing 时可以提前退出 */
            if (n - visitedCount <= maxRing) break;
        }
        return maxRing;
    }
}