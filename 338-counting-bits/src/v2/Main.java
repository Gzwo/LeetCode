package v2;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int num;
        int[] bitCounts;

        num = 15;
        bitCounts = solution.countBits(num);
        for (int bitCount : bitCounts) {
            System.out.printf("%2d", bitCount);
        }
    }
}

/* the medium way */
class Solution {
    public int[] countBits(int num) {
        int[] bitCounts = new int[num + 1];

        for (int i = 0; i <= num / 2; i++) {
            /* bitCounts[4] = bitCounts[2] */
            bitCounts[i * 2] = bitCounts[i];
            if (2 * i + 1 <= num) {
                /* bitCounts[5] = bitCounts[2] + 1 */
                bitCounts[2 * i + 1] = bitCounts[i] + 1;
            }
        }

        return bitCounts;
    }
}