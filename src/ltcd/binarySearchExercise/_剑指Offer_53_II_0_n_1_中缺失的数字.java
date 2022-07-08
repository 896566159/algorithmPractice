package ltcd.binarySearchExercise;

public class _剑指Offer_53_II_0_n_1_中缺失的数字 {

    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = (left + right) >> 1;

            if (nums[mid] <= mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

}
