import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums;
        String[] answer;

        nums = new int[]{5, 4, 3, 2, 1};
        answer = solution.findRelativeRanks(nums);
        for (String ans : answer) {
            System.out.printf("%s ", ans);
        }
        System.out.println();


        nums = new int[]{4, 3, 5, 2, 1};
        answer = solution.findRelativeRanks(nums);
        for (String ans : answer) {
            System.out.printf("%s ", ans);
        }
        System.out.println();
    }
}

class Solution {
    public String[] findRelativeRanks(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new String[0];
        }

        int N = nums.length;

        Integer[] indices = new Integer[N];
        for (int i = 0; i < N; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, Comparator.comparingInt(o -> nums[(int) o]).reversed());

        String[] medals = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};

        String[] answer = new String[N];
        for (int i = 0; i < N; i++) {
//            System.out.printf("%4d", indices[i]);
            if (i < 3) {
                answer[indices[i]] = medals[i];
            } else {
                answer[indices[i]] = String.valueOf(i + 1);
            }
        }

        return answer;
    }
}