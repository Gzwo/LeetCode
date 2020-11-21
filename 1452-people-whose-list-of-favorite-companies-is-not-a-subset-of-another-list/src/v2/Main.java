package v2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> fc;
        List<Integer> answer;

        fc = new LinkedList<>();
        fc.add(Arrays.asList("leetcode", "google", "facebook"));
        fc.add(Arrays.asList("google", "microsoft"));
        fc.add(Arrays.asList("google", "facebook"));
        fc.add(Arrays.asList("google"));
        fc.add(Arrays.asList("amazon"));

        answer = solution.peopleIndexes(fc);
        for (Integer a : answer) {
            System.out.printf("%2d, ", a);
        }
    }
}

class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int SIZE = favoriteCompanies.size();
        List<Integer> answer = new ArrayList<>(SIZE);
        /* 哈希表：以集合的数据结构记录每个清单 */
        Set<String>[] map = new HashSet[SIZE];
        for (int i = 0; i < SIZE; i++) {
            map[i] = new HashSet<>(favoriteCompanies.get(i));
        }

        /* 遍历所有清单，判断是否符合筛选条件 */
        for (int i = 0; i < SIZE; i++) {
            /* 取出当前的清单 */
            List<String> cur = favoriteCompanies.get(i);
            /* 初始化 flag 默认为真 */
            boolean curQualified = true;
            /* 检索 */
            for (int j = 0; j < SIZE; j++) {
                /* 仅需比较比当前清单更大的其他清单 */
                if (map[j].size() <= map[i].size()) {
                    continue;
                }
                Set<String> preSet = map[j];
                if (preSet.containsAll(cur)) {
                    curQualified = false;
                    break;
                }
            }
            if (curQualified) {
                answer.add(i);
            }
        }

        /* 记录的顺序是自然升序，无须再排序 */
        return answer;
    }
}