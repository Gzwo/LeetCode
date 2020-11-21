package v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr;
        List<List<Integer>> answer;

        arr = new int[]{4, 2, 1, 3};
        answer = solution.minimumAbsDifference(arr);
        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i).get(0) + ", " + answer.get(i).get(1));
        }
    }
}

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> answer = new LinkedList<>();

        /* 升序 */
        Arrays.sort(arr);

        int minAbsDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            /* 不需要调用 Math.abs() 因为已经保证了升序 */
            int curAbsDiff = arr[i + 1] - arr[i];
            /* minAbsDiff 更新后清空答案 */
            if (curAbsDiff < minAbsDiff) {
                minAbsDiff = curAbsDiff;
                answer.clear();
            }
            /* 确认当前数对差等于 minAbsDiff 后将其加入答案 */
            if (curAbsDiff == minAbsDiff) {
                List<Integer> pair = new ArrayList<>(2);
                pair.add(arr[i]);
                pair.add(arr[i + 1]);
                answer.add(pair);
            }
        }
        return answer;
    }
}