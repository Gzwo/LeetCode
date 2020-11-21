import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s;

        s = "aabcbc";
        System.out.println(solution.isValid(s)); // true

        s = "abcabcababcc";
        System.out.println(solution.isValid(s)); // true

        s = "abccba";
        System.out.println(solution.isValid(s)); // false
    }
}

class Solution {

    public boolean isValid(String s) {
        /* 剪枝：处理长度非法的用例 */
        if (s.length() % 3 != 0) {
            return false;
        }

        /* 栈的常规应用，相当于括号匹配的进阶版本 */
        Deque<Character> stack = new LinkedList<>();
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (c == 'b') {
                if (!stack.isEmpty() && stack.peek() == 'a') {
                    stack.pop();
                    stack.push('b');
                } else {
                    return false;
                }
            } else if (c == 'c') {
                if (!stack.isEmpty() && stack.peek() == 'b') {
                    stack.pop();
                } else {
                    return false;
                }
            } else /* if(cs[i] == 'a') */ {
                stack.push('a');
            }
        }

        return stack.isEmpty();
    }
}