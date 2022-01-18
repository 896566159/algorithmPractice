package ltcd.dynamicProgrammingExercise;

public class _64_最小路径和 {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        if (grid.length == 1 && grid[0].length == 1) {
            return grid[0][0];
        }

        int minPath = 0;
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] dp = new int[rows + 1][columns + 1];

        dp[0][0] = 0;
        for (int i = 1; i <= columns; i++) {
            dp[0][i] = 0;
            dp[1][i] = grid[0][i - 1] + dp[1][i - 1];
        }

        for (int i = 1; i <= rows; i++) {
            dp[i][0] = 0;
            dp[i][1] = grid[i - 1][0] + dp[i - 1][1];
        }

        for (int i = 2; i <= rows; i++) {
            for (int j = 2; j <= columns; j++) {
                int left = dp[i - 1][j];
                int top = dp[i][j - 1];
                dp[i][j] = Math.min(left, top) + grid[i - 1][j - 1];
            }
        }

        return dp[rows][columns];
    }
}
