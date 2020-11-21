package v1;

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
        List<Integer> answer = new LinkedList<>();

        Integer[] indices = new Integer[SIZE];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (o1, o2) -> {
            return favoriteCompanies.get(o2).size() - favoriteCompanies.get(o1).size();
        });
        favoriteCompanies.sort((o1, o2) -> {
            return o2.size() - o1.size();
        });

        Set<String>[] map = new HashSet[SIZE];
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            /* 取出当前的清单 */
            List<String> cur = favoriteCompanies.get(i);
            /* 将当前清单转为集合并存入哈希表 */
            map[i] = new HashSet<>(cur);
            /* 初始化 flag 默认为真 */
            boolean curQualified = true;
            /* 往回检索 */
            for (int j = 0; j < i; j++) {
                Set<String> preSet = map[j];
                if (preSet.containsAll(cur)) {
                    curQualified = false;
                    break;
                }
            }
            if (curQualified) {
                answer.add(indices[i]);
            }
        }

        /* 依题意将答案升序排列 */
        answer.sort(Comparator.comparingInt(Integer::intValue));
        return answer;
    }
}