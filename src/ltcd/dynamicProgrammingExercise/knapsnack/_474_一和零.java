package ltcd.dynamicProgrammingExercise.knapsnack;

public class _474_一和零 {

    public int findMaxForm(String[] strs, int m, int n) {

        int length = strs.length;
        int[][][] dp = new int[length + 1][m + 1][n + 1];

        for (int i = 1; i < length; i++) {

            int[] count = countZeroAndOne(strs[i - 1]);
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    dp[i][j][k] = (j >= count[0] && count[1] <= k) ? dp[i - 1][j][k] : Math.max(dp[i - 1][j][k], dp[i - 1][j - count[0]][k - count[1]] + 1);
                    // 先把上一行抄下来
//                    dp[i][j][k] = dp[i - 1][j][k];
//                    int zeros = count[0];
//                    int ones = count[1];
//                    if (j >= zeros && k >= ones) {
//                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeros][k - ones] + 1);
//                    }
                }
            }
        }

        return dp[length][m][n];
    }

    private int[] countZeroAndOne(String str) {
        int[] cnt = new int[2];
        for (char c : str.toCharArray()) {
            cnt[c - '0']++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        new _474_一和零().findMaxForm(new String[]{"10","0001","111001","1","0"}, 5, 3);
    }

}
