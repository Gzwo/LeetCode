public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix;
        int target;

        matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};

        // true
        target = 5;
        System.out.println(solution.searchMatrix(matrix, target));

        // false
        target = 20;
        System.out.println(solution.searchMatrix(matrix, target));

        // 25 * true
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println(solution.searchMatrix(matrix, matrix[i][j]));
            }
        }

        // false
        target = -1;
        System.out.println(solution.searchMatrix(matrix, target));

        // false
        target = 100;
        System.out.println(solution.searchMatrix(matrix, target));

    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && 0 <= j) {
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            } else /* if (target == matrix[i][j]) */ {
                return true;
            }
        }
        return false;
    }
}