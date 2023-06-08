package ltcd.dynamicProgrammingExercise;

public class _1130_叶值的最小代价生成树 {

    int[][] g;
    Integer[][] dp;
    public int mctFromLeafValues(int[] arr) {
        int length = arr.length;
        dp = new Integer[length][length];
        g = new int[length][length];

        for (int i = 0; i < length; i++) {
            g[i][i] = arr[i];
            for (int j = i + 1; j < length; j++) {
                g[i][j] = Math.max(g[i][j - 1], arr[i]);
            }
        }

        return dfs(0, length - 1);
    }

    private int dfs(int i, int j) {
        if (i == j) {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int ans = 1 << 30;
        for (int k = i; k < j; k++) {
            ans = Math.min(ans, dfs(i, k) + dfs(k + 1, j) + g[i][k] * g[k + 1][j]);
        }

        return dp[i][j] = ans;
    }

}
