public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s;

        s = "aaaabbbbcccc";
        System.out.println(solution.sortString(s));

        s = "rat";
        System.out.println(solution.sortString(s));

        s = "leetcode";
        System.out.println(solution.sortString(s));

        s = "ggggggg";
        System.out.println(solution.sortString(s));

        s = "spo";
        System.out.println(solution.sortString(s));


    }

}

class Solution {
    public String sortString(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }

        int[] map = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            map[s.charAt(i) - 'a']++;
        }

        StringBuilder b = new StringBuilder(n);
        while (b.length() != n) {
            for (int i = 0; i < 26; i++) {
                if (0 < map[i]) {
                    b.append((char) ('a' + i));
                    map[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (0 < map[i]) {
                    b.append((char) ('a' + i));
                    map[i]--;
                }
            }
        }

        return b.toString();
    }
}