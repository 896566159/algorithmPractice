package ltcd.slidingWindowExercise;

import java.util.ArrayList;
import java.util.List;

public class _剑指_Offer_57_II_和为s的连续正数序列 {

    //滑动窗口
    public int[][] findContinuousSequence1(int target) {
        int left = 1;//窗口左边界
        int right = 1;//窗口右边界
        int sum = 0;//窗口中的数的和
        List<int[]> list = new ArrayList<>();

        while (right < target) {
            if (sum < target) {
                sum += right;
                right++;
            } else if (sum > target) {
                sum -= left;
                left++;
            } else {
                int[] arr = new int[right - left];
                for (int i = left; i < right; i++) {
                    arr[i - 1] = i;
                }

                list.add(arr);
                sum -= left;
                left++;
            }
        }

        return list.toArray(new int[list.size()][]);
    }

}
