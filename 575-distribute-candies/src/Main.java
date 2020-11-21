import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candies;

        candies = new int[]{1, 1, 2, 3};
        System.out.println(solution.distributeCandies(candies));
    }
}

/* 能分得的糖果数最多为 candies.length / 2 因此只要统计 candies 中不同数字（糖果的种类数）即可 */
class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> candySet = new HashSet<>();
        for (int candy : candies) {
            candySet.add(candy);
        }
        return Math.min(candySet.size(), candies.length / 2);
    }
}