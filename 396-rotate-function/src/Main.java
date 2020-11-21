public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A;

        A = new int[]{4, 3, 2, 6};
        System.out.println(solution.maxRotateFunction(A));
    }
}

class Solution {
    public int maxRotateFunction(int[] A) {
        int rotatedSum = 0, sum = 0;
        for (int i = 0; i < A.length; i++) {
            rotatedSum += (i * A[i]);
            sum += A[i];
        }
        int maxSum = rotatedSum;
        for (int i = A.length - 1; 0 <= i; i--) {
            rotatedSum += (-A[i] * A.length + sum);
            maxSum = Math.max(rotatedSum, maxSum);
        }
        return maxSum;
    }
}