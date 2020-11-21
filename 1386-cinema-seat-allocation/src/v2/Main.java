package v2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

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

//        System.out.println("\n===== method start =====");

        /* 所能够安排的家庭数，初始化为最大可能值 */
        int count = 2 * n;

        Map<Integer, Integer> reserved = new HashMap<>();
        for (int[] reservedSeat : reservedSeats) {
            Integer seats = reserved.getOrDefault(reservedSeat[0], 0);
            seats |= (1 << reservedSeat[1]);
            reserved.put(reservedSeat[0], seats);
        }

        for (Integer seats : reserved.values()) {
//            System.out.println("seats: " + Integer.toBinaryString(seats));
            int code = 7;
            /* 2 ~ 9 */
            if ((seats & (1 << 2)) != 0 || (seats & (1 << 3)) != 0) {
//                System.out.println("2 or 3");
                code &= 3;
            }
            if ((seats & (1 << 4)) != 0 || (seats & (1 << 5)) != 0) {
//                System.out.println("4 or 5");
                code &= 1;
            }
            if ((seats & (1 << 6)) != 0 || (seats & (1 << 7)) != 0) {
//                System.out.println("6 or 7");
                code &= 4;
            }
            if ((seats & (1 << 8)) != 0 || (seats & (1 << 9)) != 0) {
//                System.out.println("8 or 9");
                code &= 6;
            }


            /* reservation caused decrease */
            if (code == 0) {
                count -= 2;
            } else if (code != 7) {
                count -= 1;
            }
        }

        return count;
    }
}