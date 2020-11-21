public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int radius, x_center, y_center;
        int x1, y1, x2, y2;

        radius = 1;
        x_center = 0;
        y_center = 0;
        x1 = 1;
        y1 = -1;
        x2 = 3;
        y2 = 1;
        System.out.println(solution.checkOverlap(radius, x_center, y_center, x1, y1, x2, y2));

        radius = 1;
        x_center = 1;
        y_center = 1;
        x1 = -3;
        y1 = -3;
        x2 = 3;
        y2 = 3;
        System.out.println(solution.checkOverlap(radius, x_center, y_center, x1, y1, x2, y2));

        radius = 1;
        x_center = 1;
        y_center = 1;
        x1 = 1;
        y1 = -3;
        x2 = 2;
        y2 = -1;
        System.out.println(solution.checkOverlap(radius, x_center, y_center, x1, y1, x2, y2));

        radius = 1206;
        x_center = -5597;
        y_center = -276;
        x1 = -5203;
        y1 = -1795;
        x2 = -4648;
        y2 = 1721;
        System.out.println(solution.checkOverlap(radius, x_center, y_center, x1, y1, x2, y2));

        radius = 3;
        x_center = 0;
        y_center = 0;
        x1 = -4;
        y1 = 1;
        x2 = 10000;
        y2 = 2;
        System.out.println(solution.checkOverlap(radius, x_center, y_center, x1, y1, x2, y2));
    }
}

class Solution {

    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        /* get x, y on rectangle which is closest to the circle's center */
        int x, y;
        /* get x on rectangle which is closest to x_center */
        if (x_center < x1) {
            x = x1;
        } else if (x2 < x_center) {
            x = x2;
        } else /* x1 <= x_center && x_center <= x2 */ {
            x = x_center;
        }
        /* get y on rectangle which is closest to y_center */
        if (y_center < y1) {
            y = y1;
        } else if (y2 < y_center) {
            y = y2;
        } else /* y1 <= y_center && y_center <= y2 */ {
            y = y_center;
        }

        return isInCircle(x, y, radius, x_center, y_center);

    }

    private boolean isInCircle(int x, int y, int radius, int x_center, int y_center) {
        int dx = Math.abs(x - x_center);
        int dy = Math.abs(y - y_center);
        return dx * dx + dy * dy <= radius * radius;
    }
}