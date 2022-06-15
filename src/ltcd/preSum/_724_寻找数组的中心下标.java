package ltcd.preSum;

public class _724_寻找数组的中心下标 {

    public int pivotIndex(int[] nums) {
        int length = nums.length;
        int[] preSum = new int[length + 1];
        preSum[0] = 0;

        for (int i = 0; i < length; i++) {
            preSum[i + 1] = nums[i] + preSum[i];
        }

        int leftSum = 0;
        for (int i = 0; i < length; i++) {
            if (preSum[length] - leftSum == leftSum) {//左半边 = 右边
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }

}
