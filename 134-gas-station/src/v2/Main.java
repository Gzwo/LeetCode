package v2;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] gas;
        int[] cost;

        gas = new int[]{1, 2, 3, 4, 5};
        cost = new int[]{3, 4, 5, 1, 2};
        System.out.println(solution.canCompleteCircuit(gas, cost));

        gas = new int[]{2, 3, 4};
        cost = new int[]{3, 4, 3};
        System.out.println(solution.canCompleteCircuit(gas, cost));

        gas = new int[]{1, 1, 2};
        cost = new int[]{1, 2, 1};
        System.out.println(solution.canCompleteCircuit(gas, cost));

        gas = new int[]{1, 2, 3, 4, 5, 5, 70};
        cost = new int[]{2, 3, 4, 3, 9, 6, 2};
        System.out.println(solution.canCompleteCircuit(gas, cost));

    }
}

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
            return -1;
        }

        int N = gas.length, S = 0, answer = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            S += (gas[i] - cost[i]);
            if (S < min) {
                min = S;
                answer = (i + 1) % N;
            }
        }

        /* answer exists? */
        return 0 <= S ? answer : -1;
    }
}