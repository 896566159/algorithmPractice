package ltcd.arrayExercise;

import java.util.Arrays;

public class _2341_数组能形成多少数对 {

    public int[] numberOfPairs(int[] nums) {

        Arrays.sort(nums);
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (i < nums.length && nums[i] == nums[i - 1]) {
                count++;
                i++;
            }
        }

        return new int[]{count, nums.length - count * 2};
    }

}
