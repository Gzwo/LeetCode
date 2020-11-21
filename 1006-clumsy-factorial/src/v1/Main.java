package v1;

import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int N;

        N = 4;
        System.out.println(solution.clumsy(N)); // 7

        N = 10;
        System.out.println("ans: " + solution.clumsy(N)); // 12

        N = 1;
        System.out.println(solution.clumsy(N));

        N = 10000;
        System.out.println(solution.clumsy(N));

    }
}

class Solution {
    public int clumsy(int N) {
        Deque<Integer> st = new LinkedList<>();
        st.push(N);
        for (int i = 1; i < N; i++) {
            int cur = N - i;
            if (i % 4 == 1) {
                Integer pre = st.poll();
                pre *= cur;
                st.push(pre);
            }
            if (i % 4 == 2) {
                Integer pre = st.poll();
                pre /= cur;
                st.push(pre);
            }
            if (i % 4 == 3) {
                st.push(cur);
            }
            if (i % 4 == 0) {
                st.push(-cur);
            }
        }

        int clumsyFactorial = 0;
        while (!st.isEmpty()) {
            clumsyFactorial += st.poll();
        }
        return clumsyFactorial;
    }
}