public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String date;

        date = "2019-01-09";
        System.out.println(solution.dayOfYear(date)); // 9

        date = "2000-12-31";
        System.out.println(solution.dayOfYear(date)); // 366

        date = "1900-12-31";
        System.out.println(solution.dayOfYear(date)); // 365

        date = "1900-03-01";
        System.out.println(solution.dayOfYear(date)); // 60

        date = "2019-03-01";
        System.out.println(solution.dayOfYear(date)); // 60
    }
}

class Solution {
    public int dayOfYear(String date) {
        String[] parsedDate = date.split("-");
        int Y = Integer.parseInt(parsedDate[0]),
                M = Integer.parseInt(parsedDate[1]),
                D = Integer.parseInt(parsedDate[2]);

        /* is it leap year? */
        int[] P;
        if (Y % 400 == 0 || (Y % 4 == 0 && Y % 100 != 0)) {
            P = new int[]{0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335};
        } else {
            P = new int[]{0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        }

        return P[M - 1] + D;
    }
}