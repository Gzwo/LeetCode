public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n;

        n = 1234;
        System.out.println(solution.thousandSeparator(n)); // 1.234

        n = 987;
        System.out.println(solution.thousandSeparator(n)); // 987

        n = 1000000;
        System.out.println(solution.thousandSeparator(n)); // 1.000.000

        n = 0;
        System.out.println(solution.thousandSeparator(n)); // 0
    }
}

class Solution {
    public String thousandSeparator(int n) {
        char[] cs = String.valueOf(n).toCharArray();
        StringBuilder builder = new StringBuilder(cs.length + (cs.length / 3));
        for (int i = cs.length - 1; i >= 0; i--) {
            builder.append(cs[i]);
            if ((cs.length - i) % 3 == 0 && i != 0) {
                builder.append('.');
            }
        }
        return builder.reverse().toString();
    }
}