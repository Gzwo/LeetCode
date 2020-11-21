import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums;
        List<String> summaries;

        System.out.println("========== test 1 ==========");
        nums = new int[]{0, 1, 2, 4, 5, 7};
        summaries = solution.summaryRanges(nums);
        for (String summary : summaries) {
            System.out.println(summary);
        }

        System.out.println("========== test 2 ==========");
        nums = new int[]{0, 2, 3, 4, 6, 8, 9};
        summaries = solution.summaryRanges(nums);
        for (String summary : summaries) {
            System.out.println(summary);
        }

        System.out.println("========== test 3 ==========");
        nums = new int[]{};
        summaries = solution.summaryRanges(nums);
        for (String summary : summaries) {
            System.out.println(summary);
        }

        System.out.println("========== test 4 ==========");
        nums = new int[]{-1};
        summaries = solution.summaryRanges(nums);
        for (String summary : summaries) {
            System.out.println(summary);
        }

        System.out.println("========== test 5 ==========");
        nums = new int[]{0};
        summaries = solution.summaryRanges(nums);
        for (String summary : summaries) {
            System.out.println(summary);
        }

    }
}

class Solution {
    public List<String> summaryRanges(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>(0);
        }

        List<String> summaries = new ArrayList<>(nums.length);
        for (int i = 1, start = nums[0]; i <= nums.length; i++) {
            int pre = nums[i - 1];
            /* 两种条件下输出新区间：1.当前数字与前一数字不连续；2.数组已经读完。 */
            if (i == nums.length || pre + 1 != nums[i]) {
                StringBuilder builder = new StringBuilder(String.valueOf(start));
                /* 两种区间：1.只有一个数字；2.多于1个数字。 */
                if (start != pre) {
                    builder.append("->").append(pre);
                }
                summaries.add(builder.toString());

                /* 如果数组已经读完，到这里就可以退出循环了 */
                if (i == nums.length) {
                    break;
                }
                /* 当前数字是新的 start */
                start = nums[i];
            }
        }

        return summaries;
    }
}