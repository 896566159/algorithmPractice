package ltcd.dynamicProgrammingExercise;

public class _1220_统计元音字母序列的数目 {

    public int countVowelPermutation(int n) {
        int mod = (int)1e9 + 7;
        long[][] dp = new long[n][5];
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][2] = 1;
        dp[0][3] = 1;
        dp[0][4] = 1;

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][2];
            dp[i][2] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][3] + dp[i - 1][4];
            dp[i][3] = dp[i - 1][2] + dp[i - 1][4];
            dp[i][4] = dp[i - 1][0];

            for (int j = 0; j < 5; j++) {
                dp[i][j] %= mod;
            }
        }

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += dp[n - 1][i];
        }

        return sum % mod;
    }

}
