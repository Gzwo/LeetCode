import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();
        int[][] blocked;
        int[] source;
        int[] target;

//        // false
//        blocked = new int[][]{{3, 0}, {2, 1}, {1, 2}, {0, 3}};
//        source = new int[]{0, 0};
//        target = new int[]{3, 3};
//        System.out.println(solution.isEscapePossible(blocked, source, target));
//
//        // true
//        blocked = new int[][]{{3, 0}, {2, 1}, {1, 2}};
//        source = new int[]{0, 0};
//        target = new int[]{3, 3};
//        System.out.println(solution.isEscapePossible(blocked, source, target));
//
//        // true
//        blocked = new int[][]{{3, 0}, {2, 1}, {1, 2}, {0, 3}};
//        source = new int[]{0, 0};
//        target = new int[]{1, 1};
//        System.out.println(solution.isEscapePossible(blocked, source, target));

        // true
        blocked = new int[][]{{5, 20}, {10, 10}, {15, 10}, {10, 30}, {15, 30}, {20, 30}};
        source = new int[]{10, 20};
        target = new int[]{20, 30};
        System.out.println(solution.isEscapePossible(blocked, source, target));
    }
}

/* 剪枝BFS */
class Solution {
    private Set<Long> blockedSet;
    private Set<Long> visitedSet;

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        /* Blocked Set */
        blockedSet = new HashSet<>(200);
        for (int[] block : blocked) {
            blockedSet.add(mapper(block));
        }

        return escape(source, target) && escape(target, source);
    }

    private boolean escape(int[] start, int[] end) {
        /* Initialization of the visited set */
        visitedSet = new HashSet<>();

        /* check if the start(source or target) is valid */
        if (!isValid(start)) {
            return false;
        }

        /* BFS */
        Queue<int[]> q = new LinkedList<>();
        visitedSet.add(mapper(start));
        q.add(start);

        /* Exits: 1.target/source reached
         *        2.visited set is big enough
         *        3.path blocked */
        int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            for (int[] d : dir) {
                int[] next = new int[]{cell[0] + d[0], cell[1] + d[1]};
                if (isValid(next)) {
                    /* Pruning: check if the next cell is the end */
                    if (next[0] == end[0] && next[1] == end[1]) {
                        return true;
                    }
                    visitedSet.add(mapper(next));
                    q.add(next);
                }
            }
            /* Pruning: check if the visited set's size is over 19900 */
            if (19900 < visitedSet.size()) return true;
        }
        /* if Queue is empty before visited set's size reaches 19900,
           this means the current start is blocked */
        return false;
    }

    private boolean isValid(int[] cell) {
        /* check if cell is out of boundaries */
        if (cell[0] < 0 || cell[1] < 0 ||
                1000000 <= cell[0] || 1000000 <= cell[1]) {
            return false;
        }
        /* check if cell is blocked or visited */
        long mappedCell = mapper(cell);
        return !blockedSet.contains(mappedCell) &&
                !visitedSet.contains(mappedCell);
    }

    private long mapper(int[] cell) {
        return 1000001 * (long) cell[0] + cell[1];
    }
}