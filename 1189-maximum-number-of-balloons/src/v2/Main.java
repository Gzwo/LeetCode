package v2;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String text;

        text = "loonbalxballpoon";
        System.out.println(solution.maxNumberOfBalloons(text));

        text = "nlaebolko";
        System.out.println(solution.maxNumberOfBalloons(text));

        text = "leetcode";
        System.out.println(solution.maxNumberOfBalloons(text));
    }
}

class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] counts = new int[26];
        int n = text.length();
        for (int i = 0; i < n; i++) {
            counts[text.charAt(i) - 'a']++;
        }
        counts['l' - 'a'] /= 2;
        counts['o' - 'a'] /= 2;

        /* 短板效应 */
        char[] cs = new char[]{'b', 'a', 'l', 'o', 'n'};
        int ans = Integer.MAX_VALUE;
        for (char c : cs) {
            ans = Math.min(counts[c - 'a'], ans);
        }
        return ans;
    }
}