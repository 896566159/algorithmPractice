package ltcd.mathExercise;

import java.util.Arrays;

public class _1877_数组中最大数对和的最小值 {

//    把第 k 大的和第 k 小的拼在一起，不仅能使得最大和最小，还能使得最小和最大
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int ans = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            ans = Math.min(nums[left--] + nums[right++], ans);
        }

        return ans;
    }

}
