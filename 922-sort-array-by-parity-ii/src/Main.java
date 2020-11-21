public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A;
        int[] sorted;

        A = new int[]{4, 2, 5, 7};
        sorted = solution.sortArrayByParityII(A);
        for (int j : sorted) {
            System.out.printf("%2d", j);
        }
        System.out.println();

        A = new int[]{9, 7, 5, 3, 8, 6, 4, 2};
        sorted = solution.sortArrayByParityII(A);
        for (int j : sorted) {
            System.out.printf("%2d", j);
        }
        System.out.println();
    }
}

class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int even = 0, odd = 1;
        while (even < A.length && odd < A.length) {
            while (even < A.length && A[even] % 2 == 0) even += 2;
            while (odd < A.length && A[odd] % 2 == 1) odd += 2;
            if (even < A.length && odd < A.length) {
                /* swap */
                int tmp = A[even];
                A[even] = A[odd];
                A[odd] = tmp;
                /* move cursors */
                even += 2;
                odd += 2;
            }
        }
        return A;
    }
}