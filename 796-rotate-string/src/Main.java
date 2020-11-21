public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String A, B;

        A = "abcde";
        B = "cdeab";
        System.out.println(solution.rotateString(A, B)); // true

        A = "abcdea";
        B = "cdeab";
        System.out.println(solution.rotateString(A, B)); // false

        A = "abced";
        B = "cdeab";
        System.out.println(solution.rotateString(A, B)); // false
    }
}

class Solution {
    public boolean rotateString(String A, String B) {

        if (A == null || B == null) {
            return false;
        }

        if (A.length() != B.length()) {
            return false;
        }

        StringBuilder A2 = new StringBuilder(A + A);
        return A2.toString().contains(B);
    }
}