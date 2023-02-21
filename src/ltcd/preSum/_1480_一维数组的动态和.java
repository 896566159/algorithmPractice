package ltcd.preSum;

public class _1480_一维数组的动态和 {

    public int[] runningSum(int[] nums) {

        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] += preSum;
            preSum = nums[i];
        }

        return nums;
    }

}
