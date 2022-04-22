package ltcd.dynamicProgrammingExercise;

public class _剑指_Offer_47_礼物的最大价值 {

    public int maxValue(int[][] grid) {
        
        int col = grid[0].length + 1;
        int row = grid.length + 1;
        int[][] dp = new int[grid.length][grid[0].length];

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                int left = dp[i][j - 1];
                int top = dp[i - 1][j];
                dp[i][j] = Math.max(left, top) + grid[i - 1][j - 1];
            }
        }
        
        return dp[row][col];
    }

}
