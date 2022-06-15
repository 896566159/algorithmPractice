package ltcd.preSum;

public class _643_子数组最大平均数_I {

    public double findMaxAverage1(int[] nums, int k) {
        int ans = Integer.MIN_VALUE;
        int left = 0;
        int right = k;
        int length = nums.length;
        int[] preSum = new int[length + 1];

        for (int i = 0; i < length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        while (right < length + 1) {
            ans = Math.max(ans, preSum[right] - preSum[left]);
            left++;
            right++;
        }

        return (double) ans / k;
    }

    public double findMaxAverage(int[] nums, int k) {
        double ans = Double.MIN_VALUE;
        int left = 0;
        int right = 0;
        int length = nums.length;
        double sum = 0.d;

        while (right - left + 1 < k) {
            sum += nums[right];
            right++;
        }

        while (right < length) {

            sum += nums[right];

            ans = ans > (sum / k) ? ans : (sum / k);
            sum -= nums[left];
            left++;
            right++;
        }

        return ans;
    }

}
