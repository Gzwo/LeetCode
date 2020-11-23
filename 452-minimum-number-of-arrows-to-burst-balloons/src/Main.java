import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] points;

        points = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(solution.findMinArrowShots(points)); // 2

    }
}

/* 1.自定义排序
   2.当心整形溢出 */
class Solution {
    public int findMinArrowShots(int[][] points) {

        if (points == null || points.length == 0) {
            return 0;
        }

        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

        int MAS = 1; // MinArrowShots
        for (int i = 1, cur = points[0][1]; i < points.length; i++) {
            if (cur < points[i][0]) {
                MAS++;
                cur = points[i][1];
            }
        }

        return MAS;
    }
}
