package ltcd.preSum;

public class _303_区域和检索_数组不可变 {

    //preSum[i] 表示原数组 nums[0] ~ nums[i - 1]
    int[] preSum = null;

    public _303_区域和检索_数组不可变(int[] nums) {

        int length = nums.length;
        preSum = new int[length + 1];
        preSum[0] = 0;

        for (int i = 0; i < length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }

}
