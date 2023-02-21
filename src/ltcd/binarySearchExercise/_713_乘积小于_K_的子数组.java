package ltcd.binarySearchExercise;

public class _713_乘积小于_K_的子数组 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
        int len = nums.length;
        long multiplication = 1;

        while (right < len) {
            multiplication *= nums[right++];

            while (multiplication >= k && left < right) {
                multiplication /= nums[left++];
            }

            count += right - left;
        }

        return count;
    }

}
