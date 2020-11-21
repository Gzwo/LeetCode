import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s;
        int a, b;

        s = "5525";
        a = 9;
        b = 2;
        System.out.println(solution.findLexSmallestString(s, a, b));
    }
}

class Solution {

    public String findLexSmallestString(String s, int a, int b) {

        /* 处理特殊情形1：s不符合题意 */
        if (s == null || s.length() == 0 || s.length() % 2 != 0) {
            return s;
        }

        /* 简单的预处理 */
        b = b % s.length();

        /* 处理特殊情形2：a == 0 且 b == 0 */
        if (a == 0 && b == 0) {
            return s;
        }

        /* BFS */
        String best = s;
        Set<String> seen = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        seen.add(s);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            String added = add(cur, a);
            if (!seen.contains(added)) {
                seen.add(added);
                queue.add(added);
                best = best.compareTo(added) < 0 ? best : added;
            }
            String rotated = rotate(cur, b);
            if (!seen.contains(rotated)) {
                seen.add(rotated);
                queue.add(rotated);
                best = best.compareTo(rotated) < 0 ? best : rotated;
            }
        }

        return best;
    }

    /* add */
    private String add(String s, int a) {
        char[] cs = s.toCharArray();
        for (int i = 1; i < cs.length; i += 2) {
            cs[i] = (char) ('0' + (cs[i] - '0' + a) % 10);
        }
        return String.valueOf(cs);
    }

    /* rotate */
    private String rotate(String s, int b) {
        return s.substring(b) + s.substring(0, b);
    }

}