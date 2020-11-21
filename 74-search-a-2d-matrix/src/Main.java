public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix;
        int target;

        matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}};
        target = 3;
        System.out.println(solution.searchMatrix(matrix, target)); // true

        target = 13;
        System.out.println(solution.searchMatrix(matrix, target)); // false

        target = 0;
        System.out.println(solution.searchMatrix(matrix, target)); // false

        target = 61;
        System.out.println(solution.searchMatrix(matrix, target)); // false


    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        /* empty matrix */
        if (matrix == null || matrix.length == 0 ||
                matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        /* binary search */
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int r = mid / n, c = mid % m;
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] < target) {
                left = mid + 1;
            } else /* if (target < matrix[r][c]) */ {
                right = mid - 1;
            }
        }

        /* target not found */
        return false;
    }

}