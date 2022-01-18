package ltcd.dynamicProgrammingExercise;

public class _剑指_Offer_II_091_粉刷房子 {

    public int minCost(int[][] costs) {
        int[][] dp = new int[costs.length][3];

        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for (int i = 1; i < costs.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][j] = costs[i][j] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                } else if (j == 1) {
                    dp[i][j] = costs[i][j] + Math.min(dp[i - 1][0], dp[i - 1][2]);
                } else {
                    dp[i][j] = costs[i][j] + Math.min(dp[i - 1][0], dp[i - 1][1]);
                }
            }
        }

        return Math.min(Math.min(dp[costs.length - 1][0], dp[costs.length - 1][1]), dp[costs.length - 1][2]);
    }

}
