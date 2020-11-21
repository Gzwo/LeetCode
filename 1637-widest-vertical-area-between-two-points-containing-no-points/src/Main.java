import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] points;

        points = new int[][]{{3, 1}, {9, 0}, {1, 0}, {1, 4}, {5, 3}, {8, 8}};
        System.out.println(solution.maxWidthOfVerticalArea(points));
    }
}

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        /* 处理特殊情形 */
        if (points == null || points.length == 0 || points[0].length == 0) return 0;

        /* 抽取x轴坐标，升序排序 */
        int[] xes = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            xes[i] = points[i][0];
        }
        Arrays.sort(xes);

        /* 计算最大宽度 */
        int maxWidth = 0;
        for (int i = 0; i < xes.length - 1; i++) {
            maxWidth = Math.max(maxWidth, xes[i + 1] - xes[i]);
        }
        return maxWidth;
    }
}