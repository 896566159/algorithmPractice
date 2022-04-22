package ltcd.arrayExercise;

import java.util.Arrays;

public class _2006_差的绝对值为K的数对数目 {

    public int countKDifference(int[] nums, int k) {
        Arrays.sort(nums);
        if (nums[nums.length - 1] - nums[0] < k) {
            return 0;
        }

        int ans = 0;
        int right = nums.length - 1;

        for (int left = 0; left < nums.length; left++) {
            right = nums.length - 1;
            while (left < right) {
                if (nums[right] - nums[left] == k) {
                    ans++;
                }
            }
        }

        return ans;
    }

}
