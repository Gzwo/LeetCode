import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ages;

        ages = new int[]{15, 15, 16, 16};
        System.out.println(solution.numFriendRequests(ages));

        ages = new int[]{16, 16};
        System.out.println(solution.numFriendRequests(ages));

        ages = new int[]{16, 17, 18};
        System.out.println(solution.numFriendRequests(ages));

        ages = new int[]{20, 30, 100, 110, 120};
        System.out.println(solution.numFriendRequests(ages));
    }
}

/* 前缀和的应用 */
class Solution {

    private static final int MAX_AGE = 120;

    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int[] prefixSums = new int[MAX_AGE + 1];
        for (int i = 1, j = 0; i <= MAX_AGE; i++) {
            prefixSums[i] = prefixSums[i - 1];
            while (j < ages.length && ages[j] == i) {
                prefixSums[i] += 1;
                j++;
            }
        }

        int count = 0;
        for (int i = 15; i <= MAX_AGE; i++) {
            count += (prefixSums[i] - prefixSums[i / 2 + 7] - 1) *
                    (prefixSums[i] - prefixSums[i - 1]);
        }

//        for (int i = 0; i < prefixSums.length; i++) {
//            System.out.printf("%3d", i);
//        }
//        System.out.println();
//        for (int prefixSum : prefixSums) {
//            System.out.printf("%3d", prefixSum);
//        }
//        System.out.println();

        return count;
    }
}