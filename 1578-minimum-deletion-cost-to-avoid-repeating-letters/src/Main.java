public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s;
        int[] cost;

        s = "aabaa";
        cost = new int[]{1, 2, 3, 4, 1};
        System.out.println(solution.minCost(s, cost)); // 2

        s = "abaac";
        cost = new int[]{1, 2, 3, 4, 5};
        System.out.println(solution.minCost(s, cost)); // 3

        s = "abc";
        cost = new int[]{1, 2, 3};
        System.out.println(solution.minCost(s, cost)); // 0

        s = "aaabbbabbbb";
        cost = new int[]{3, 5, 10, 7, 5, 3, 5, 5, 4, 8, 1};
        System.out.println(solution.minCost(s, cost)); // 26

    }
}

class Solution {
    public int minCost(String s, int[] cost) {
        /* mc: min-cost, return value */
        int mc = 0;

        char preChar = '.';
        int preCost = 0;
        /* the key is to locate the maximum cost in a series of repeated characters */
        for (int i = 0; i < cost.length; i++) {
            /* when repeated characters are found,
               make sure the maximum cost of
               this series of repeated characters
               is not added to min-cost */
            if (preChar == s.charAt(i)) {
                if (preCost > cost[i]) {
                    mc += cost[i];
                } else {
                    mc += preCost;
                    /* make sure preCost is the maximum cost of a series of repeated characters */
                    preCost = cost[i];
                }
            }
            /* make sure to update preChar and preCost
               when a different character shows up
               so that they represents the first repeated character
               in a series of repeated characters */
            else {
                preChar = s.charAt(i);
                preCost = cost[i];
            }
        }

        return mc;
    }
}