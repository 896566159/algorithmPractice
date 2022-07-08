package ltcd.dynamicProgrammingExercise;

public class _剑指_Offer_4_I_剪绳子 {

    public int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= n; i++) {

            int max = 0;
            for (int j = 1; j < i; j++) {
                max = Math.max(dp[i - j] * dp[j], max);
            }
            dp[i] = max;
        }

        return dp[n];
    }

}
