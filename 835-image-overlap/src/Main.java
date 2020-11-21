public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] img1, img2;

        img1 = new int[][]{
                {1, 1, 0},
                {0, 1, 0},
                {0, 1, 0}};
        img2 = new int[][]{
                {0, 0, 0},
                {0, 1, 1},
                {0, 0, 1}};
        System.out.println(solution.largestOverlap(img1, img2));
    }
}

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int N = img1.length;
        int[][] offsets = new int[2 * N + 1][2 * N + 1];
        for (int i1 = 0; i1 < N; i1++) {
            for (int j1 = 0; j1 < N; j1++) {
                /* 枚举 img1 中的 1 */
                if (img1[i1][j1] == 1) {
                    for (int i2 = 0; i2 < N; i2++) {
                        for (int j2 = 0; j2 < N; j2++) {
                            /* 枚举 img2 中的 1 */
                            if (img2[i2][j2] == 1) {
                                /* img2 相对于 img1 的偏移，offsets[N][N] 表示不作位移的直接重叠 */
                                offsets[i1 - i2 + N][j1 - j2 + N]++;
                            }
                        }
                    }
                }
            }
        }

        /* 计数 */
        int largest = 0;
        for (int i = 0; i < offsets.length; i++) {
            for (int j = 0; j < offsets[i].length; j++) {
                largest = Math.max(largest, offsets[i][j]);
            }
        }
        return largest;
    }
}