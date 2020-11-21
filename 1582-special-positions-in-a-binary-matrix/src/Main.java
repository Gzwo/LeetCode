import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix;

        matrix = new int[][]{
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}};
        System.out.println(solution.numSpecial(matrix));
    }
}

class Solution {
    public int numSpecial(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0] == null || mat[0].length == 0)
            return 0;

        int m = mat.length, n = mat[0].length;
        int[] rows = new int[m], cols = new int[n];
        Arrays.fill(rows, -1);
        Arrays.fill(cols, -1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    if (rows[i] == -1) {
                        rows[i] = j;
                    } else {
                        rows[i] = -2;
                    }
                    if (cols[j] == -1) {
                        cols[j] = i;
                    } else {
                        cols[j] = -2;
                    }
                }
            }
        }


        int count = 0;
        for (int i = 0; i < m; i++) {
            if (0 <= rows[i] && 0 <= cols[rows[i]]) {
                count++;
            }
        }

        return count;
    }
}