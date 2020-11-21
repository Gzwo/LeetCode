import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid;
        int k;
        List<List<Integer>> shifted;

        grid = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        k = 1;
        shifted = solution.shiftGrid(grid, k);
        for (int i = 0; i < shifted.size(); i++) {
            List<Integer> row = shifted.get(i);
            for (int j = 0; j < row.size(); j++) {
                System.out.printf("%4d", row.get(j));
            }
            System.out.println();
        }

    }
}

/* 平坦化 */
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return new ArrayList<>(0);
        }

        /* 行数 */
        int m = grid.length;
        /* 列数 */
        int n = grid[0].length;
        /* k 对 (m * n) 取余 */
        k %= (m * n);

        List<List<Integer>> shifted = new ArrayList<>(grid.length);
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                /* 当前位置的数字从 grid 的平坦化下标 */
                int old = (m * n + n * i + j - k) % (m * n);
                int r = old / n;
                int c = old % n;
                row.add(grid[r][c]);
            }
            shifted.add(row);
        }

        return shifted;
    }
}