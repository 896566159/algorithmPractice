package ltcd.slidingWindowExercise.difficult;

import java.util.Arrays;

public class _594_最长和谐子序列 {

    public int findLHS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int ans = 0;

        for (int i = 0, j = 0; j < nums.length; j++) {
            while (i < j && nums[j] - nums[i] > 1) {
                i++;
            }
            if (nums[j] - nums[i] == 1) {
                ans = Math.max(ans, j - i + 1);
            }
        }

        return ans;
    }

}
