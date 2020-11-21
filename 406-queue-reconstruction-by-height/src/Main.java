import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] people;
        int[][] q;

        people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        q = solution.reconstructQueue(people);
        for (int[] p : q) {
            System.out.printf("%2d, %2d; ", p[0], p[1]);
        }

    }
}

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        /* custom sort: sort by h, ascending, then by k, descending */
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        /* reconstruct queue */
        int[][] q = new int[people.length][];
        for (int i = 0; i < people.length; i++) {
            int beforeCur = people[i][1] + 1;
            for (int j = 0; j < people.length; j++) {
                if (q[j] == null) {
                    beforeCur--;
                    if (beforeCur == 0) {
                        q[j] = people[i];
                        break;
                    }
                }
            }
        }
        return q;
    }
}