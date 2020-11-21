package v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> nob;
        int tomatoSlices, cheeseSlices;

        tomatoSlices = 16;
        cheeseSlices = 7;
        nob = solution.numOfBurgers(tomatoSlices, cheeseSlices);
        if (nob.size() == 0) {
            System.out.println("no solution");
        } else {
            System.out.println(nob.get(0) + ", " + nob.get(1));
        }

        tomatoSlices = 16988;
        cheeseSlices = 7985;
        nob = solution.numOfBurgers(tomatoSlices, cheeseSlices);
        if (nob.size() == 0) {
            System.out.println("no solution");
        } else {
            System.out.println(nob.get(0) + ", " + nob.get(1));
        }

        tomatoSlices = 2;
        cheeseSlices = 1;
        nob = solution.numOfBurgers(tomatoSlices, cheeseSlices);
        if (nob.size() == 0) {
            System.out.println("no solution");
        } else {
            System.out.println(nob.get(0) + ", " + nob.get(1));
        }

        tomatoSlices = 4;
        cheeseSlices = 17;
        nob = solution.numOfBurgers(tomatoSlices, cheeseSlices);
        if (nob.size() == 0) {
            System.out.println("no solution");
        } else {
            System.out.println(nob.get(0) + ", " + nob.get(1));
        }

        tomatoSlices = 17;
        cheeseSlices = 4;
        nob = solution.numOfBurgers(tomatoSlices, cheeseSlices);
        if (nob.size() == 0) {
            System.out.println("no solution");
        } else {
            System.out.println(nob.get(0) + ", " + nob.get(1));
        }
    }
}

/* 二分 */
class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        /* 剪枝：番茄片是奇数一定无解 */
        if (tomatoSlices % 2 == 1) {
            return new ArrayList<>();
        }

        /* 二分查找 */
        int l = 0, r = cheeseSlices;
        while (l <= r) {
            int m = (l + r) / 2;
            int n = cheeseSlices - m;
            if (4 * m + 2 * n == tomatoSlices) {
                return Arrays.asList(m, n);
            } else if (4 * m + 2 * n < tomatoSlices) {
                l = m + 1;
            } else /* tomatoSlices < 4 * m + 2 * n */ {
                r = m - 1;
            }
        }
        if (4 * l + 2 * (cheeseSlices - l) == tomatoSlices) {
            return Arrays.asList(l, cheeseSlices - l);
        } else {
            return new ArrayList<>();
        }
    }
}