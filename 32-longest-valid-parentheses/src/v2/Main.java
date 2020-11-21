package v2;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //    5 2
        //    )()))
        //    12 2
        //    ())())))((((
        //    20 8
        //    ()()(()))(())(((()((
        //    20 6
        //    )(()))((())((()()()(
        //    20 4
        //    ()()((()((()((()((((
        //    20 12
        //    ))()()))()()(())()()

        String[] s = new String[]{
                ")()))",
                "())())))((((",
                "()()(()))(())(((()((",
                ")(()))((())((()()()(",
                "()()((()((()((()((((",
                "))()()))()()(())()()"};

        for (String s1 : s) {
            System.out.println(solution.longestValidParentheses(s1));
        }

    }
}

/* 两个计数器，从左到右和从右到左各走一次并在 lc == rc 时更新 longest */
class Solution {
    public int longestValidParentheses(String s) {
        /* init */
        char[] cs = s.toCharArray();
        /* lc: left-bracket count, rc: right-bracket count */
        int lc = 0, rc = 0, longest = 0;

        /* left to right */
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '(') lc++;
            else rc++;
            /* update */
            if (lc < rc) lc = rc = 0;
            else if (lc == rc)
                longest = Math.max(longest, rc << 1);
        }

        /* right to left */
        lc = rc = 0;
        for (int i = cs.length - 1; i >= 0; i--) {
            if (cs[i] == '(') lc++;
            else rc++;
            /* update */
            if (lc > rc) lc = rc = 0;
            else if (lc == rc)
                longest = Math.max(longest, rc << 1);
        }

        return longest;
    }
}