package ltcd.preSum;

public class _724_寻找数组的中心下标 {

    public int pivotIndex(int[] nums) {
        int length = nums.length;
        int preSum = 0;

        for (int i = 0; i < length; i++) {
            preSum += nums[i];
        }

        int leftSum = 0;
        for (int i = 0; i < length; i++) {
            if (preSum - leftSum - nums[i] == leftSum) {//左半边 = 右边
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }

}
