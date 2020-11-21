package v1;

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
        int[] counts = new int[5];
        int n = text.length();
        for (int i = 0; i < n; i++) {
            char c = text.charAt(i);
            switch (c) {
                case 'b' -> counts[0]++;
                case 'a' -> counts[1]++;
                case 'l' -> counts[2]++;
                case 'o' -> counts[3]++;
                case 'n' -> counts[4]++;
            }
        }
        counts[2] /= 2;
        counts[3] /= 2;
        int ans = Integer.MAX_VALUE;
        for (int count : counts) {
            ans = Math.min(count, ans);
        }
        return ans;
    }
}