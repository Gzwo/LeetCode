import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] logs;
        String[] reordered;

        logs = new String[]{
                "a1 9 2 3 1",
                "g1 act car",
                "zo4 4 7",
                "ab1 off key dog",
                "a8 act zoo"};
        reordered = solution.reorderLogFiles(logs);
        for (String reorderedLog : reordered) {
            System.out.println(reorderedLog);
        }
    }
}

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (l1, l2) -> {

            int splitPoint1 = l1.indexOf(' '), splitPoint2 = l2.indexOf(' ');

            String content1 = l1.substring(splitPoint1 + 1);
            String content2 = l2.substring(splitPoint2 + 1);

            boolean isDigit1 = Character.isDigit(content1.charAt(0));
            boolean isDigit2 = Character.isDigit(content2.charAt(0));

            /* 情形1：l1 与 l2 都是数字日志，按原序排列 */
            if (isDigit1 && isDigit2) {
                return 0;
            }

            /* 情形2：l1 与 l2 分别为字母日志和数字日志，将字母日志排在前，数字日志排在后 */
            if (isDigit1 || isDigit2) {
                return isDigit1 ? 1 : -1;
            }

            /* 情形3：l1 与 l2 都是字母日志，先比较日志内容，根据字典序排列 */
            if (!content1.equals(content2)) {
                return content1.compareTo(content2);
            }

            /* 情形4：l1 与 l2 都是字母日志，且日志内容相同，根据其标识符排列
               由于已知日志内容相同，所以不需要单独取出标识符，直接比较 l1 和 l2 */
            return l1.compareTo(l2);

        });

        return logs;
    }
}