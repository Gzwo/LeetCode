
public class Main {
    public static void main(String[] args) {
        v1.Solution solution = new v1.Solution();

        int[][] grid;

        grid = new int[][]{
                {2, 4, 3},
                {6, 5, 2}};
        System.out.println(solution.hasValidPath(grid));

        grid = new int[][]{
                {1, 2, 1},
                {1, 2, 1}};
        System.out.println(solution.hasValidPath(grid));
    }
}
