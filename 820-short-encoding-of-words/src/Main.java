import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words;

        words = new String[]{"time", "me", "bell"};
        System.out.println(solution.minimumLengthEncoding(words));
    }
}

class Solution {
    public int minimumLengthEncoding(String[] words) {

        int len = 0;
        for (String word : words) {
            len += (word.length() + 1);
        }

        Arrays.sort(words, Comparator.comparingInt(String::length));
        for (int i = 0; i < words.length; i++) {
            String current = words[i];
            int currentLength = current.length();
            for (int j = i + 1; j < words.length; j++) {
                /* 当且仅当尾后缀一致时，删去 current */
                if (currentLength + words[j].indexOf(current) == words[j].length()) {
                    len -= (currentLength + 1);
                    break;
                }
            }
        }

        return len;
    }
}