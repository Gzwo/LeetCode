public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int N;
        int[][] mines;

        N = 5;
        mines = new int[][]{{4, 2}};
        System.out.println(solution.orderOfLargestPlusSign(N, mines));
    }
}

class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        /* dp */
        int[][] wings = new int[N][N];
        for (int[] mine : mines) {
            wings[mine[0]][mine[1]] = -1;
        }

        int len = 0;
        /* 计算每个格子向左右伸出的【翼】长度 */

        for (int r = 0; r < N; r++) {
            /* 左侧 */
            len = 0;
            for (int c = 0; c < N; c++) {
                if (wings[r][c] == -1) {
                    len = 0;
                } else {
                    len++;
                    /* 左侧【翼】长是第一个记录的，相当于初始化，之后的3个需要调用 Math.min() */
                    wings[r][c] = len;
                }
            }
            /* 右侧 */
            len = 0;
            for (int c = N - 1; c >= 0; c--) {
                if (wings[r][c] == -1) {
                    len = 0;
                } else {
                    len++;
                    wings[r][c] = Math.min(wings[r][c], len);
                }

            }
        }

        /* 计算每个格子向上下伸出的【翼】长度 */
        for (int c = 0; c < N; c++) {
            /* 上边 */
            len = 0;
            for (int r = 0; r < N; r++) {
                if (wings[r][c] == -1) {
                    len = 0;
                } else {
                    len++;
                    wings[r][c] = Math.min(wings[r][c], len);

                }
            }
            /* 下边 */
            len = 0;
            for (int r = N - 1; r >= 0; r--) {
                if (wings[r][c] == -1) {
                    len = 0;
                } else {
                    len++;
                    wings[r][c] = Math.min(wings[r][c], len);
                }
            }
        }

        int answer = 0;
        for (int[] wing : wings) {
            for (int e : wing) {
                answer = Math.max(answer, e);
            }
        }
        return answer;
    }
}