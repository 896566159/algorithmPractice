package ltcd.dynamicProgrammingExercise;

public class _213_打家劫舍_II {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int robFirst = rob(nums, 0, nums.length - 1);
        int notRobFirst = rob(nums, 1, nums.length);

        return Math.max(robFirst, notRobFirst);
    }

    private int rob(int[] nums, int start, int end) {
        int[] dp = new int[end - start];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i <= end - start; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        return dp[end];
    }
}
