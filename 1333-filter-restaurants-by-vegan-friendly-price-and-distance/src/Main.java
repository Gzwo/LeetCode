import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] restaurants;
        int veganFriendly, maxPrice, maxDistance;
        List<Integer> filtered;

        restaurants = new int[][]{
                {1, 4, 1, 40, 10},
                {2, 8, 0, 50, 5},
                {3, 8, 1, 30, 4},
                {4, 10, 0, 10, 3},
                {5, 1, 1, 15, 1}};
        veganFriendly = 1;
        maxPrice = 50;
        maxDistance = 10;
        filtered = solution.filterRestaurants(restaurants, veganFriendly, maxPrice, maxDistance);
        for (int i = 0; i < filtered.size(); i++) {
            System.out.printf("%2d", filtered.get(i));
        }


    }
}

class Solution {
    /* restaurants[i] = {id, rating, veganFriendly, price, distance} */
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> sorted = new ArrayList<>();

        if (restaurants == null || restaurants.length == 0 ||
                restaurants[0] == null || restaurants[0].length == 0) {
            return sorted;
        }

        sorted = new ArrayList<>(restaurants.length);

        List<int[]> filtered = new ArrayList<>(restaurants.length);

        for (int[] restaurant : restaurants) {
            if (veganFriendly <= restaurant[2] &&
                    restaurant[3] <= maxPrice &&
                    restaurant[4] <= maxDistance) {
                filtered.add(restaurant);
            }
        }

        filtered.sort((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o2[0] - o1[0];
            } else {
                return o2[1] - o1[1];
            }
        });

        for (int[] r : filtered) {
            sorted.add(r[0]);
        }

        return sorted;
    }
}