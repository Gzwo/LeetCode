package v1;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int num;
        int[] bitCounts;

        num = 5;
        bitCounts = solution.countBits(num);
        for (int bitCount : bitCounts) {
            System.out.printf("%2d", bitCount);
        }
    }
}

/* the easy way */
class Solution {
    public int[] countBits(int num) {
        int[] bitCounts = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            bitCounts[i] = Integer.bitCount(i);
        }
        return bitCounts;
    }
}