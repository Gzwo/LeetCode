import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1, nums2, answer;

        nums1 = new int[]{1, 2, 2, 1};
        nums2 = new int[]{2, 2};
        answer = solution.intersection(nums1, nums2);
        for (int ans : answer) {
            System.out.printf("%2d ", ans);
        }
        System.out.println();

    }
}

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Set<Integer> set1 = new HashSet<>(nums1.length);
        Set<Integer> set2 = new HashSet<>(nums2.length);
        for (int e : nums1) {
            set1.add(e);
        }

        List<Integer> answerBuilder = new ArrayList<>(Math.min(nums1.length, nums2.length));

        for (int e : nums2) {
            if (!set2.contains(e)) {
                set2.add(e);
                if (set1.contains(e)) {
                    answerBuilder.add(e);
                }
            }
        }

        int[] answer = new int[answerBuilder.size()];
        for (int i = 0; i < answerBuilder.size(); i++) {
            answer[i] = answerBuilder.get(i);
        }

        return answer;
    }
}