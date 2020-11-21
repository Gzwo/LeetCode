public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String word1, word2;

//        word1 = "sea";
//        word2 = "eat";
//        System.out.println(solution.minDistance(word1, word2)); // 2(ea)
//
//        word1 = "apple";
//        word2 = "pie";
//        System.out.println(solution.minDistance(word1, word2)); // 4(pe)
//
//        word1 = "donald";
//        word2 = "mcdonald";
//        System.out.println(solution.minDistance(word1, word2)); // 2(donald)
//
//        word1 = "jack";
//        word2 = "jack";
//        System.out.println(solution.minDistance(word1, word2)); // 2(donald)

        word1 = "park";
        word2 = "spake";
        System.out.println(solution.minDistance(word1, word2)); // 3(pak)

    }
}

/* 问题本质是找两个字符串的最长公共子序列 */
class Solution {
    public int minDistance(String word1, String word2) {

        if (word1 == null || word2 == null) {
            return -1;
        }

        int len1 = word1.length(), len2 = word2.length(), maxComm = 0;
        /* 首行和0首列空出来，方便处理边界 */
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;

                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
                maxComm = Math.max(maxComm, dp[i + 1][j + 1]);
            }
        }

//        for (int[] row : dp) {
//            for (int v : row) {
//                System.out.printf("%2d", v);
//            }
//            System.out.println();
//        }

        return len1 + len2 - 2 * maxComm;
    }
}