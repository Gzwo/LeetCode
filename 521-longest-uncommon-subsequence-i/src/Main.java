public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String a, b;

        a = "aba";
        b = "cdc";
        System.out.println(solution.findLUSlength(a, b));

        a = "aaa";
        b = "aaa";
        System.out.println(solution.findLUSlength(a, b));

        a = "aaa";
        b = "bbb";
        System.out.println(solution.findLUSlength(a, b));

        a = "abcd";
        b = "bcd";
        System.out.println(solution.findLUSlength(a, b));
    }
}

class Solution {
    public int findLUSlength(String a, String b) {
        if (a == null && b == null) {
            return 0;
        }
        if (a == null) {
            return b.length();
        }
        if (b == null) {
            return a.length();
        }
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }
}