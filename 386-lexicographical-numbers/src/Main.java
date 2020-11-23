import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n;
        List<Integer> answer;

        n = 13;
        answer = solution.lexicalOrder(n);
        for (Integer ans : answer) {
            System.out.printf("%4d", ans);
        }
        System.out.println();

        n = 130;
        answer = solution.lexicalOrder(n);
        for (Integer ans : answer) {
            System.out.printf("%4d", ans);
        }
        System.out.println();


    }
}

/* 深搜 + 剪枝 */
class Solution {
    public List<Integer> lexicalOrder(int n) {

        if (n <= 0) {
            return new ArrayList<>(0);
        }

        List<Integer> answer = new ArrayList<>(n + 1);
        dfs(0, 0, n, answer);

        return answer;
    }

    private void dfs(int cur, int depth, int n, List<Integer> answer) {

        if (depth == 0) {
            for (int i = 1; i < 10; i++) {
                if (i <= n) {
                    answer.add(i);
                    dfs(i, depth + 1, n, answer);
                } else {
                    break;
                }
            }
        } else {
            for (int i = 0; i < 10; i++) {
                if (10 * cur + i <= n) {
                    answer.add(10 * cur + i);
                    dfs(10 * cur + i, depth + 1, n, answer);
                }
            }
        }

    }
}