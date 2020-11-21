import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n;
        List<String> logs;
        int[] timeTable;

        n = 2;
        logs = Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6");
        timeTable = solution.exclusiveTime(n, logs);
        for (int time : timeTable) {
            System.out.println(time);
        }
    }
}

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] timeTable = new int[n];
        if (n == 0 || logs.size() == 0) return timeTable;

        /* Use a stack to record the method on CPU */
        Deque<Integer[]> stack = new LinkedList<>();

        for (String logStr : logs) {
            Integer[] log = parseLog(logStr);

            /* start */
            if (log[1] == 0) {
                if (!stack.isEmpty()) {
                    Integer[] caller = stack.peek();
                    timeTable[caller[0]] += (log[2] - caller[2]);
                }
                stack.push(log);
            } else /* log[1] == 1 */ {
                Integer[] running = stack.poll();
                timeTable[running[0]] += (log[2] - running[2] + 1);
                if (!stack.isEmpty()) {
                    stack.peek()[2] = log[2] + 1;
                }
            }
        }

        return timeTable;
    }

    private Integer[] parseLog(String logStr) {
        Integer[] log = new Integer[3];
        String[] contents = logStr.split(":");
        log[0] = Integer.parseInt(contents[0]);
        log[1] = contents[1].equals("start") ? 0 : 1;
        log[2] = Integer.parseInt(contents[2]);
        return log;
    }
}