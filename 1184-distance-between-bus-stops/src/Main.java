public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] distance;
        int start, destination;

        distance = new int[]{1, 2, 3, 4};
        start = 0;
        destination = 1;
        System.out.println(solution.distanceBetweenBusStops(distance, start, destination)); // 1

        distance = new int[]{10, 2, 3, 4};
        start = 0;
        destination = 1;
        System.out.println(solution.distanceBetweenBusStops(distance, start, destination)); // 9
    }
}

class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (distance == null || distance.length == 0) return 0;

        /* possible swap start and destination */
        if (destination < start) {
            int tmp = destination;
            destination = start;
            start = tmp;
        }

        int n = distance.length, cardinalPath = 0, ordinalPath = 0;
        for (int i = 0; i < n; i++) {
            if (start <= i && i < destination) {
                ordinalPath += distance[i];
            } else {
                cardinalPath += distance[i];
            }
        }

        return Math.min(ordinalPath, cardinalPath);
    }
}