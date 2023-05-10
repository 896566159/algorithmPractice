package ltcd.arrayExercise.matrixExercise;

public class _剑指OfferII_107_矩阵中的距离_ {

    public static void main(String[] args) {
        _剑指OfferII_107_矩阵中的距离_ v = new _剑指OfferII_107_矩阵中的距离_();
//        v.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}});
        v.updateMatrix(new int[][]{{0, 1}});
    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] dp = new int[m][n];

        // 初始化dp
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = mat[i][j] == 0 ? 0 : 1000;
            }
        }

        // 从左上角开始
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j]);
                }

                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j - 1] + 1, dp[i][j]);
                }
            }
        }

        // 从右下角开始
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i + 1 < m) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }

                if (j + 1 < n) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }

        return dp;
    }

}
