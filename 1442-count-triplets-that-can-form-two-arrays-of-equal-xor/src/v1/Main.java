package v1;

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

/* Prefix Sum + Brutal Force */
class Solution {
    public int countTriplets(int[] arr) {

        if (arr == null || arr.length < 2) {
            return 0;
        }

        int N = arr.length;
        int[] P = new int[N + 1];
        for (int i = 0; i < N; i++) {
            P[i + 1] = P[i] ^ arr[i];
        }

        int count = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j; k < N; k++) {
                    if ((P[i] ^ P[j]) == (P[j] ^ P[k + 1])) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}