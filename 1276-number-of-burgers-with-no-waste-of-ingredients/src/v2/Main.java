package v2;

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

/* 数学：雉兔同笼 */
class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        int m = tomatoSlices / 2 - cheeseSlices;
        if (0 <= m && m <= cheeseSlices && 4 * m + 2 * (cheeseSlices - m) == tomatoSlices) {
            return Arrays.asList(m, cheeseSlices - m);
        } else {
            return new ArrayList<>();
        }
    }
}