package ltcd.dynamicProgrammingExercise;

import java.util.Arrays;

public class _935_骑士拨号器 {
//    public int knightDialer1(int n) {
//        if (n == 1) {
//            return 10;
//        }
//
//        int mod = (int) (1e9 + 7);
//        int[][] dp = new int[n][4];
//        dp[0][0] = 1;
//        dp[0][1] = 1;
//        dp[0][2] = 1;
//        dp[0][3] = 1;
//
//        for (int i = 1; i < n; i++) {
//            dp[i][0] = dp[i -1][1] + dp[i - 1][2];
//            dp[i][1] = 2 * dp[i -1][0];
//            dp[i][2] = 2 * dp[i -1][2] + dp[i - 1][3];
//            dp[i][3] = 3 * dp[i -1][2];
//
//            for (int j = 0; j < 4; j++) {
//                dp[i][j] %= mod;
//            }
//        }
//
//        int sum = 0;
//        for (int i = 0; i < 4; i++) {
//            sum += dp[n - 1][i];
//            sum %= mod;
//        }
//
//        return sum;
//    }

    public int knightDialer(int n) {
        int mod = (int) (1e9 + 7);
        int[][] dp = new int[n][10];
        Arrays.fill(dp[0], 1);

        for (int i = 1; i < n; i++) {
            dp[i][0] = (dp[i - 1][4] + dp[i - 1][6]) % mod;
            dp[i][1] = (dp[i - 1][6] + dp[i - 1][8]) % mod;
            dp[i][2] = (dp[i - 1][7] + dp[i - 1][9]) % mod;
            dp[i][3] = (dp[i - 1][4] + dp[i - 1][8]) % mod;
            dp[i][4] = (dp[i - 1][0] + dp[i - 1][3] + dp[i - 1][9]) % mod;
            dp[i][5] = dp[i - 1][5];
            dp[i][6] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][7]) % mod;
            dp[i][7] = (dp[i - 1][2] + dp[i - 1][6]) % mod;
            dp[i][8] = (dp[i - 1][1] + dp[i - 1][3]) % mod;
            dp[i][8] = (dp[i - 1][2] + dp[i - 1][4]) % mod;
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[n - 1][i];
            sum %= mod;
        }

        return sum;
    }

}
