import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int R, C, r0, c0;
        int[][] cells;

        R = 2;
        C = 3;
        r0 = 1;
        c0 = 2;
        cells = solution.allCellsDistOrder(R, C, r0, c0);
        for (int[] cell : cells) {
            System.out.printf("%2d, %2d; ", cell[0], cell[1]);
        }

    }
}

/* BFS */
class Solution {

    private int[][] d = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] cells = new int[R * C][2];
        boolean[][] visited = new boolean[R][C];

        int idx = 0;
        Queue<int[]> q = new LinkedList<>();
        /* start */
        q.offer(new int[]{r0, c0});
        visited[r0][c0] = true;
        /* loops */
        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                int[] cur = q.poll();
                cells[idx++] = cur;
                int r = cur[0], c = cur[1];
                for (int j = 0; j < 4; j++) {
                    if (isValid(R, C, r + d[j][0], c + d[j][1], visited)) {
                        q.offer(new int[]{r + d[j][0], c + d[j][1]});
                        visited[r + d[j][0]][c + d[j][1]] = true;
                    }
                }
            }
        }

        return cells;
    }

    private boolean isValid(int R, int C, int r1, int c1, boolean[][] visited) {
        return r1 >= 0 && c1 >= 0 && R > r1 && C > c1 && !visited[r1][c1];
    }
}