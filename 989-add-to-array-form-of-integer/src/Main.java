import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A;
        int K;

        List<Integer> ans;

        A = new int[]{1, 2, 0, 0};
        K = 34;
        ans = solution.addToArrayForm(A, K);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();

        A = new int[]{9, 9, 9, 8};
        K = 88;
        ans = solution.addToArrayForm(A, K);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}

class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        /* 将 K 也转为数组形式 */
        char[] KChars = String.valueOf(K).toCharArray();
        int[] KArr = new int[KChars.length];
        for (int i = 0; i < KChars.length; i++) {
            KArr[i] = KChars[i] - '0';
        }

        /* 计算 */
        LinkedList<Integer> answer = new LinkedList<>();
        int carry = 0;
        int AIdx = A.length - 1, KIdx = KArr.length - 1;
        while (0 <= AIdx || 0 <= KIdx || carry != 0) {
            int cur = 0;
            if (0 <= AIdx) {
                cur += A[AIdx];
                AIdx--;
            }
            if (0 <= KIdx) {
                cur += KArr[KIdx];
                KIdx--;
            }
            if (0 < carry) {
                cur += carry;
            }
            carry = cur / 10;
            cur %= 10;
            /* 头插法 */
            answer.addFirst(cur);
        }
        return answer;
    }
}