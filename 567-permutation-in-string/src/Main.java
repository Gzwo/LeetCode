public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1, s2;

        s1 = "ab";
        s2 = "eidbaooo";
        System.out.println(solution.checkInclusion(s1, s2)); // true

        s1 = "ab";
        s2 = "eidboaoo";
        System.out.println(solution.checkInclusion(s1, s2)); // false

        s1 = "oooa";
        s2 = "eidbaooo";
        System.out.println(solution.checkInclusion(s1, s2)); // true

    }
}

/* Sliding Window */
class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1 == null || s1.length() == 0) {
            return true;
        }

        if (s2 == null || s2.length() == 0 || s2.length() < s1.length()) {
            return false;
        }

        /* Demand Size */
        int DS = s1.length();

        int[] demand = new int[26];
        for (int i = 0; i < DS; i++) {
            demand[s1.charAt(i) - 'a']++;
            demand[s2.charAt(i) - 'a']--;
        }

        /* left boundary */
        boolean inclusion = true;
        for (int i = 0; i < 26; i++) {
            if (demand[i] != 0) {
                inclusion = false;
                break;
            }
        }

        if (inclusion) {
            return true;
        }

        /* Supply Size */
        int SS = s2.length();
        for (int l = 0, r = DS; r < SS; l++, r++) {
            int lChar = s2.charAt(l) - 'a';
            int rChar = s2.charAt(r) - 'a';
            demand[lChar]++;
            demand[rChar]--;

            if (demand[lChar] != 0 || demand[rChar] != 0) {
                continue;
            }

            inclusion = true;
            for (int i = 0; i < 26; i++) {
                if (demand[i] != 0) {
                    inclusion = false;
                    break;
                }
            }

            if (inclusion) {
                return true;
            }
        }

        return false;
    }
}