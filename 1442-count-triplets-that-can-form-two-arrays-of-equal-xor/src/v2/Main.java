package v2;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr;

        arr = new int[]{2, 3, 1, 6, 7};
        System.out.println(solution.countTriplets(arr)); // 4

        arr = new int[]{1, 1, 1, 1, 1};
        System.out.println(solution.countTriplets(arr)); // 10

        arr = new int[]{2, 3};
        System.out.println(solution.countTriplets(arr)); // 0

        arr = new int[]{1, 3, 5, 7, 9};
        System.out.println(solution.countTriplets(arr)); // 3

        arr = new int[]{7, 11, 12, 9, 5, 2, 7, 17, 22};
        System.out.println(solution.countTriplets(arr)); // 8

        arr = new int[]{2, 2};
        System.out.println(solution.countTriplets(arr)); // 1
    }
}

/* a == b means a ^ b == 0 */
class Solution {
    public int countTriplets(int[] arr) {

        if (arr == null || arr.length < 2) {
            return 0;
        }

        int N = arr.length;
        int count = 0;

        for (int i = 0; i < N - 1; i++) {
            int sum = 0;
            for (int k = i; k < N; k++) {
                sum ^= arr[k];

                /* sum = a ^ b when i < k
                   if sum == 0, it means a == b,
                   therefore, j is every number in (i,k] */
                if (i < k && sum == 0) {
                    count += (k - i);
                }
            }
        }

        return count;
    }
}