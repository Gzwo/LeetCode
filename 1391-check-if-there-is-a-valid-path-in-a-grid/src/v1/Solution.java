package v1;

/* 这是一道非常啰嗦无聊的 DFS/BFS 题 */
public class Solution {
    boolean[][] visited;

    public boolean hasValidPath(int[][] grid) {
        /* 检查输入合法性 */
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return false;
        }

        /* 初始化 visited 表 */
        visited = new boolean[grid.length][grid[0].length];

        /* go! dfs! go! */
        dfs(0, 0, grid);
        return visited[grid.length - 1][grid[0].length - 1];
    }

    /* 东，南，西，北 */
    private int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0},};

    private void dfs(int r, int c, int[][] grid) {
        /* 标记访问过的位置 */
        visited[r][c] = true;
        /* 依据 grid[r][c] 的类型决定下一步可达的位置 */
        int type = grid[r][c];
        /* 东 */
        if ((type == 1 || type == 4 || type == 6)
                && isValid(r, c, 0, grid)) {
            dfs(r, c + 1, grid);
        }
        /* 南 */
        if ((type == 2 || type == 3 || type == 4)
                && isValid(r, c, 1, grid)) {
            dfs(r + 1, c, grid);
        }
        /* 西 */
        if ((type == 1 || type == 3 || type == 5)
                && isValid(r, c, 2, grid)) {
            dfs(r, c - 1, grid);
        }
        /* 北 */
        if ((type == 2 || type == 5 || type == 6)
                && isValid(r, c, 3, grid)) {
            dfs(r - 1, c, grid);
        }
    }

    private boolean isValid(int r, int c, int dIdx, int[][] grid) {
        int nextR = r + dir[dIdx][0], nextC = c + dir[dIdx][1];
        /* 出界或已访问 */
        if (nextR < 0 || nextC < 0 ||
                grid.length <= nextR || grid[0].length <= nextC ||
                visited[nextR][nextC]) {
            return false;
        }
        /* 判断是否连通 */
        int nextCell = grid[nextR][nextC];
        /* 东 */
        if ((nextCell == 1 || nextCell == 3 || nextCell == 5)
                && dIdx == 0) {
            return true;
        }
        /* 南 */
        if ((nextCell == 2 || nextCell == 5 || nextCell == 6)
                && dIdx == 1) {
            return true;
        }
        /* 西 */
        if ((nextCell == 1 || nextCell == 4 || nextCell == 6)
                && dIdx == 2) {
            return true;
        }
        /* 北 */
        if ((nextCell == 2 || nextCell == 3 || nextCell == 4)
                && dIdx == 3) {
            return true;
        }
        return false;
    }
}