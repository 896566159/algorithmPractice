package ltcd.dynamicProgrammingExercise;

public class _剑指_Offer_II_090_环形房屋偷盗 {

    public int rob(int[] nums) {
        int r = recur(1, nums.length, nums);
        int l = recur(0, nums.length - 1, nums);

        return Math.max(l, r);
    }

    private int recur(int l, int r, int[] nums) {
        if (r - l <= 0) {
            return nums[l];
        }

        int[] dp = new int[nums.length];
        dp[0] = 0;
        dp[1] = nums[l];

        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i -2] + nums[i + l - 1]);
        }

        return dp[nums.length];
    }

    public static void main(String[] args) {
        new _剑指_Offer_II_090_环形房屋偷盗().rob(new int[]{1,2,3,1});
    }

}
