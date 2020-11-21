package v1;

import java.util.Deque;
import java.util.LinkedList;

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

/* 可以将问题分解成 2 个环节：
 * 1.用栈将能够匹配的括号进行标记，分出两种状态：合法、非法
 * 2.对连续标记进行计数并找出最长连续合法括号子串的长度 */
class Solution {
    public int longestValidParentheses(String s) {
        /* init */
        char[] cs = s.toCharArray();
        /* lc: left-bracket count, rc: right-bracket count */

        Deque<Integer> leftBrackets = new LinkedList<>();
        boolean[] legalBrackets = new boolean[cs.length];
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '(') leftBrackets.push(i);
            else {
                if (leftBrackets.isEmpty()) continue;
                legalBrackets[i] = true;
                legalBrackets[leftBrackets.pop()] = true;
            }
        }

        /* 找到最长的连续合法括号子串 */
        int longest = 0, count = 0;
        for (boolean legalBracket : legalBrackets) {
            if (legalBracket) count++;
            else count = 0;
            longest = Math.max(longest, count);
        }

        return longest;
    }
}