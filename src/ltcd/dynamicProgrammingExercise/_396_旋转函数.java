package ltcd.dynamicProgrammingExercise;

public class _396_旋转函数 {

    public int maxRotateFunction(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int f0 = 0;

        for (int i = 0; i < len; i++) {
            f0 += i * nums[i];
            sum += nums[i];
        }

        int ans = f0;
        //F(K) = F(K - 1) + sum - n * nums[n - k]
        for (int i = 1; i < len; i++) {
            f0 = f0 + sum - len * nums[len - i];
            ans = Math.max(ans, f0);
        }

        return ans;
    }

}
