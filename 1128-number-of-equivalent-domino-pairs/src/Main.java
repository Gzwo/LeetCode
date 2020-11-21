public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] dominoes;

        dominoes = new int[][]{
                {1, 2},
                {2, 1},
                {3, 4},
                {4, 5},
                {6, 3},
                {1, 2},
                {1, 2},
                {4, 3},
                {9, 9},
                {9, 9},
                {9, 9},
                {1, 1},
                {1, 1},
                {1, 1}
        };

        // 7
        System.out.println(solution.numEquivDominoPairs(dominoes));
    }
}

/* 简单哈希：将骨牌映射到一个 (10, 100) 中的数字
   按照规律映射，如将骨牌的两个数字中较大的放在个位 */
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] map = new int[89];
        for (int[] domino : dominoes) {
            map[mapper(domino[0], domino[1])]++;
        }

        int pairCount = 0;
        for (int count : map) {
            if (1 < count) pairCount += (count * (count - 1)) / 2;
        }
        return pairCount;
    }

    private int mapper(int num1, int num2) {
        if (num1 < num2) return 10 * num1 + num2 - 11;
        else return 10 * num2 + num1 - 11;
    }
}