package ltcd.dynamicProgrammingExercise;

public class _576_出界的路径数 {

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int mod = (int) (1e9 + 7);
        int[][][] dp = new int[m][n][maxMove + 1];

        for (int k = 1; k <= maxMove; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0) dp[i][j][k]++;
                    if (j == 0) dp[i][j][k]++;
                    if ( i == m - 1) dp[i][j][k]++;
                    if ( j == n - 1) dp[i][j][k]++;

                    for (int[] dir: dirs) {
                        int nextI = i + dir[0];
                        int nextJ = j + dir[1];

                        if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n) {
                            dp[i][j][k] = (dp[i][j][k] + dp[nextI][nextJ][k - 1]) % mod;
                        }
                    }
                }
            }
        }

        return dp[startRow][startColumn][maxMove];
    }

}
