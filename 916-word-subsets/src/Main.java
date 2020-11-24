import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] A, B;
        List<String> universalWords;

        A = new String[]{"amazon", "apple", "facebook", "google", "leetcode"};
        B = new String[]{"e", "o"};
        universalWords = solution.wordSubsets(A, B);
        for (String universalWord : universalWords) {
            System.out.println(universalWord);
        }

    }
}

/* 将 A 看作供应方，将 B 看作需求方，只要供应大于等于需求就是 通用的 */
class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {

        if (A == null || A.length == 0) {
            return new ArrayList<>(0);
        }

        if (B == null || B.length == 0) {
            return Arrays.asList(A);
        }

        /* Minimum Demand Of Characters */
        int[] MinDOC = new int[26];
        for (String b : B) {
            /* Demand Of Characters */
            int[] DOC = new int[26];
            for (int i = 0; i < b.length(); i++) {
                char c = b.charAt(i);
                DOC[c - 'a']++;
                MinDOC[c - 'a'] = Math.max(MinDOC[c - 'a'], DOC[c - 'a']);
            }
        }

        List<String> universalWords = new ArrayList<>(A.length);

        for (String a : A) {
            /* Supply Of Characters */
            int[] SOC = new int[26];
            for (int i = 0; i < a.length(); i++) {
                char c = a.charAt(i);
                SOC[c - 'a']++;
            }

            boolean sufficient = true;

            for (int i = 0; i < 26; i++) {
                if (SOC[i] < MinDOC[i]) {
                    sufficient = false;
                    break;
                }
            }

            if (sufficient) {
                universalWords.add(a);
            }
        }

        return universalWords;
    }
}