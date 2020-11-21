package v1;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n;
        int[][] reservedSeats;

        n = 3;
        reservedSeats = new int[][]{
                {1, 2}, {1, 3}, {1, 8},
                {2, 6},
                {3, 1}, {3, 10}};
        System.out.println(solution.maxNumberOfFamilies(n, reservedSeats));

        n = 4;
        reservedSeats = new int[][]{
                {4, 3},
                {1, 4},
                {4, 6},
                {1, 7}};
        System.out.println(solution.maxNumberOfFamilies(n, reservedSeats));


        n = 2;
        reservedSeats = new int[][]{
                {1, 5},
                {2, 8},
                {2, 10},
                {2, 2},
                {1, 6},
                {1, 10},
                {1, 1},
                {2, 5},
                {1, 2}};
        System.out.println(solution.maxNumberOfFamilies(n, reservedSeats));
    }
}

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        /* 所能够安排的家庭数，初始化为最大可能值 */
        int count = 2 * n;

//        System.out.println("count: " + count);

        /* 将预约座位表按行排列，保证同一行的预约下标连续 */
        Arrays.sort(reservedSeats, Comparator.comparingInt(r -> r[0]));

//        for (int[] reservedSeat : reservedSeats) {
//            System.out.println("reserved: " + reservedSeat[0] + ", " + reservedSeat[1]);
//        }

        int cur = reservedSeats[0][0]; // 第一个预约的行号
        for (int i = 0, code = 7; i < reservedSeats.length; i++) {
            /* 更新 code */
            int col = reservedSeats[i][1];
            /* code != 0 才有必要更新 */
            if (code != 0) {
                if (col == 2 || col == 3) {
                    code &= 3;
                } else if (col == 4 || col == 5) {
                    code &= 1;
                } else if (col == 6 || col == 7) {
                    code &= 4;
                } else if (col == 8 || col == 9) {
                    code &= 6;
                }
            }

            /* 没有下一个预约，或下一个预约在另一行 */
            if (i + 1 == reservedSeats.length || cur != reservedSeats[i + 1][0]) {
                // System.out.println("cur: " + cur + ", code: " + code);
                if (code == 0) {
                    count -= 2;
                } else if (code != 7) {
                    count -= 1;
                }
                /* 将 code 恢复为 0b111 将 cur 改为下一个预约的行号 */
                code = 7;
                if (i + 1 < reservedSeats.length) {
                    cur = reservedSeats[i + 1][0];
                }
            }
        }

        return count;
    }
}