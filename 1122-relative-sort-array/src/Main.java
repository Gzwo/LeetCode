public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1, arr2, answer;

        arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        arr2 = new int[]{2, 1, 4, 3, 9, 6};
        answer = solution.relativeSortArray(arr1, arr2);
        for (int e : answer) {
            System.out.printf("%3d", e);
        }
        System.out.println();
    }
}

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        /* 处理特殊情形：arr1 或 arr2 为空数组或长度为 0 */
        if (arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0) {
            return arr1;
        }

        /* 一般情形：计数排序 */
        int[] numCounts = new int[1001];
        for (int a : arr1) {
            numCounts[a]++;
        }
        int[] answer = new int[arr1.length];
        int j = 0;
        for (int i = 0; i < arr2.length; i++) {
            while (0 < numCounts[arr2[i]]) {
                numCounts[arr2[i]]--;
                answer[j++] = arr2[i];
            }
        }
        for (int i = 0; i < numCounts.length; i++) {
            while (0 < numCounts[i]) {
                numCounts[i]--;
                answer[j++] = i;
            }
        }
        return answer;
    }
}