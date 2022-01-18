package ltcd.dynamicProgrammingExercise.knapsnack;

public class _416_分割等和子集 {

    public boolean canPartition(int[] nums) {

        int length = nums.length;
        int sum = 0;

        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }

        if ((sum & 1) == 1) {//sum % 2 != 0
            return false;
        }

        int target = sum >> 1;
        boolean[][] dp = new boolean[length][target + 1];

        // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= target; j++) {
                //先把上一行结果先抄下来
                dp[i][j] = dp[i - 1][j];

                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }

                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[length - 1][target];
    }

}
