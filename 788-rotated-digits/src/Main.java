public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int N;

        N = 1;
        System.out.println(solution.rotatedDigits(N));

        N = 10;
        System.out.println(solution.rotatedDigits(N));

        N = 10000;
        System.out.println(solution.rotatedDigits(N));
    }
}

class Solution {
    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            boolean has347 = false, has2569 = false;
            int cur = i;
            while (cur != 0) {
                int lastDigit = cur % 10;
                if (lastDigit == 3 || lastDigit == 4 || lastDigit == 7) {
                    has347 = true;
                    break;
                }
                if (!has2569 && (lastDigit == 2 || lastDigit == 5 || lastDigit == 6 || lastDigit == 9)) {
                    has2569 = true;
                }
                cur /= 10;
            }
            if (!has347 && has2569) {
                count++;
            }
        }
        return count;
    }
}