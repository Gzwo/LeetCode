public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A;
        int K;

        A = new int[]{9, 1, 2, 3, 9};
        K = 3;
        System.out.println(solution.largestSumOfAverages(A, K));
    }
}

class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        double answer = 0.0;

        int N = A.length;

        /* Prefix-Sums */
        int[] P = new int[N + 1];
        for (int i = 0; i < N; i++) {
            P[i + 1] = P[i] + A[i];
        }

        double[] dp = new double[N];
        /* 初始化为以 i 为 start，以 N 为 end(not included) 的子数组和 */
        for (int i = 0; i < N; i++) {
            dp[i] = (P[N] - P[i]) / (double) (N - i);
        }




        return answer;
    }
}