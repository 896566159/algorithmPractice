package ltcd.dualPointerExercise;

import java.util.Arrays;

public class _977_有序数组的平方 {

    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] help = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length - 1;

        while (left < right) {
            if (nums[right] * nums[right] > nums[left] * nums[left]) {
                help[index--] = nums[right] * nums[right];
                right--;
            } else {
                help[index--] = nums[left] * nums[left];
                left++;
            }
        }

        return help;
    }

    public int[] sortedSquares1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

}
