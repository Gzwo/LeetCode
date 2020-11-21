import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A;
        List<Boolean> answer;

        A = new int[]{0, 1, 1, 1, 1, 1, 1};
        answer = solution.prefixesDivBy5(A);
        for (Boolean a : answer) {
            System.out.println(a);
        }

    }
}

class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {

//        if (A == null || A.length == 0) {
//            return new ArrayList<>();
//        }

        Boolean[] answer = new Boolean[A.length];
        int cur = 0;
        for (int i = 0; i < A.length; i++) {
            cur = ((cur << 1) + A[i]) % 5;
            /* update answer */
            answer[i] = cur == 0;
        }
        return Arrays.asList(answer);
    }
}