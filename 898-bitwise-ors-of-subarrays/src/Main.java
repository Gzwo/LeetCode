import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A;

        A = null;
        System.out.println(solution.subarrayBitwiseORs(A)); // 0

        A = new int[0];
        System.out.println(solution.subarrayBitwiseORs(A)); // 0

        A = new int[]{1};
        System.out.println(solution.subarrayBitwiseORs(A)); // 1

        A = new int[]{1, 2, 4};
        System.out.println(solution.subarrayBitwiseORs(A)); // 6

        A = new int[]{1, 11, 6, 11};
        System.out.println(solution.subarrayBitwiseORs(A)); // 4
    }
}

/* 实际上是一种类似动态规划的思想：遍历 A 并将以 A[i] 为末位的子数组按位或的结果逐个加入集合
 * 同时不需要为每个 A[i] 维护一个单独的子集，只需要从 A[i] 向前遍历，逐位覆盖原来的数字即可
 * 这个过程在 A[j] | A[i] == A[i] 时可以提前退出（剪枝） */
class Solution {
    public int subarrayBitwiseORs(int[] A) {

        /* 处理特殊情形：A 为空或长度小于 2 */
        if (A == null || A.length < 2) {
            return A == null ? 0 : A.length;
        }
        Set<Integer> seen = new HashSet<>(65536);
        for (int i = 0; i < A.length; i++) {
            seen.add(A[i]);
            for (int j = i - 1; 0 <= j; j--) {
                if ((A[j] | A[i]) == A[j]) {
                    break;
                }
                A[j] |= A[i];
                seen.add(A[j]);
            }

//            System.out.println("i: " + i + ", seen.size(): " + seen.size());

        }

        return seen.size();
    }
}