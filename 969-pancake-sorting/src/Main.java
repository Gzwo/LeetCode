import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr;
        List<Integer> pancakes;


        // 1
        arr = new int[]{3, 2, 4, 1};
        pancakes = solution.pancakeSort(arr);

        System.out.println("ans:");
        for (Integer pancake : pancakes) {
            System.out.println(pancake);
        }


        // 2
        arr = new int[]{1, 2, 3};
        pancakes = solution.pancakeSort(arr);

        System.out.println("ans:");
        for (Integer pancake : pancakes) {
            System.out.println(pancake);
        }


    }
}

class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> pancakes = new LinkedList<>();

        for (int j = arr.length, i = findMax(arr, j);
             j != 0; i = findMax(arr, j)) {
            /* if the element on index-0 was the greatest,
               there is no need to flip(i + 1), just flip(j) */
            if (i == 0) {
                pancakes.add(j);
                flip(arr, j);
            } else if (i + 1 != j) {
                pancakes.add(i+1);
                flip(arr, i + 1);
                pancakes.add(j);
                flip(arr, j);
            }
            /* find one max element in each loop
               and put it at the back of the array */
            j--;
        }

        return pancakes;
    }

    /* find max index, end is not included */
    private int findMax(int[] arr, int end) {
        int max = Integer.MIN_VALUE, maxIdx = -1;
        for (int i = 0; i < end; i++) {
            if (max < arr[i]) {
                max = arr[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    /* start = 0, end is not included */
    private void flip(int[] arr, int end) {
        int l = 0, r = end - 1;
        while (l < r) {
            /* swap */
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            /* move cursor */
            l++;
            r--;
        }
    }
}