import javax.print.attribute.standard.MediaSize;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String a, b;

        a = "ulacfd";
        b = "jizalu";
        System.out.println(solution.checkPalindromeFormation(a, b)); // true

        a = "x";
        b = "y";
        System.out.println(solution.checkPalindromeFormation(a, b)); // true

        a = "abcdefg";
        b = "zzzzcba";
        System.out.println(solution.checkPalindromeFormation(a, b)); // true

        a = "xa";
        b = "y";
        System.out.println(solution.checkPalindromeFormation(a, b)); // false

        a = "qwe";
        b = "xyz";
        System.out.println(solution.checkPalindromeFormation(a, b)); // false

        a = "xxa";
        b = "yyb";
        System.out.println(solution.checkPalindromeFormation(a, b)); // false

    }
}

class Solution {
    public boolean checkPalindromeFormation(String a, String b) {

        if (a == null || b == null ||
                (a.length() == 0 && b.length() == 0) ||
                (a.length() == 1 && b.length() == 1)) {
            return true;
        }

        if (a.length() != b.length()) {
            return false;
        }

        int LEN = a.length();

        /* a 或 b 本身是回文字符串 */
        if (partlyPalindrome(0, LEN, a, a) == LEN / 2 ||
                partlyPalindrome(0, LEN, b, b) == LEN / 2) {
            return true;
        }

        /* 尝试：aPrefix + bSuffix */
        int a2b = partlyPalindrome(0, LEN, a, b);
        if (partlyPalindrome(a2b, LEN - a2b, a, a) == (LEN - a2b) / 2 ||
                partlyPalindrome(a2b, LEN - a2b, b, b) == (LEN - a2b) / 2) {
            return true;
        }

        /* 尝试：bPrefix + aSuffix */
        int b2a = partlyPalindrome(0, LEN, b, a);
        if (partlyPalindrome(b2a, LEN - b2a, a, a) == (LEN - b2a) / 2 ||
                partlyPalindrome(b2a, LEN - b2a, b, b) == (LEN - b2a) / 2) {
            return true;
        }

        /* 以上情形都未构成回文字符串才能判假 */
        return false;
    }


    private int partlyPalindrome(int start, int end, String s1, String s2) {
        int l = start, r = end - 1;

        while (l < r) {
            if (s1.charAt(l) != s2.charAt(r)) {
                return l - start;
            }
            l++;
            r--;
        }
        return end / 2;
    }

}