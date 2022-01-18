package ltcd.dynamicProgrammingExercise;

public class _300_最长递增子序列 {

    public int lengthOfLIS(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int max = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j], dp[i]);
                }
            }

            max = Math.max(dp[i], max);
        }

        return max;
    }

}
