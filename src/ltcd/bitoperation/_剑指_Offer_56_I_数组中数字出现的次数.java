package ltcd.bitOperation;

public class _剑指_Offer_56_I_数组中数字出现的次数 {

    public int[] singleNumbers(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int zeroCount = 0;

        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            }

            min = Math.min(min, num);
            max = Math.max(max, num);
            sum ^= num;
        }

        //需要判断一下，只出现了一次的那两个数中是包含0
        if (zeroCount == 1) {
            return new int[]{sum, 0};
        }

        //二分法，找出一个介于只出现了一次的两个数之间的一个数，将原数组拆分成两个部分
        int lo = min;
        int hi = max;

        while (lo <= hi) {
            //根据 lo 的正负性来判断二分位置，防止越界
            int mid = (lo < 0 && hi > 0) ? (lo + hi) >> 1 : lo + (hi - lo) / 2;
            int loSum = 0;
            int hiSum = 0;

            for (int num : nums) {
                if (num <= mid) {
                    loSum ^= num;
                } else {
                    hiSum ^= num;
                }
            }

            //如果两个都不等于0，则说明两个目标数已经落在了2个数组里面
            if (loSum != 0 && hiSum != 0) {
                return new int[]{loSum, hiSum};
            }

            //两个目标数都大于当前的mid，所以比mid小的数异或和变成了0
            if (loSum == 0) {
                lo = mid + 1;
            } else {//两个目标数都小于当前的mid，所以比mid小的数异或和变成了0
                hi = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        new _剑指_Offer_56_I_数组中数字出现的次数().singleNumbers(new int[]{3,2,0,3});
    }

}
