package ltcd.dynamicProgrammingExercise;

public class _63_不同路径_II {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }

        int[][] dp = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];

        dp[0][0] = 0;
        dp[1][1] = obstacleGrid[0][0] == 1 ? 0 : 1;

        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = 0;

            if (obstacleGrid[0][i - 1] == 1 || (dp[1][i - 1] == 0 && i != 1)) {
                dp[1][i] = 0;
            } else {
                dp[1][i] = 1;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = 0;

            if (obstacleGrid[i - 1][0] == 1 || (dp[i - 1][1] == 0 && i != 1)) {
                dp[i][1] = 0;
            } else {
                dp[i][1] = 1;
            }
        }

        for (int i = 2; i < dp.length; i++) {
            for (int j = 2; j < dp[0].length; j++) {
                if (obstacleGrid[i - 2][j - 2] == 1) {
                    dp[i][j] = 0;
                } else if (obstacleGrid[i - 1][j - 1] == 1) {//obstacleGrid[i - 1][j - 1] == 1
                    int top = obstacleGrid[i - 2][j - 1] == 1 ? 0 : dp[i - 1][j];
                    int left = obstacleGrid[i - 1][j - 2] == 1 ? 0 : dp[i][j - 1];
                    dp[i][j] = top + left;
                }
//                } else if (obstacleGrid[i - 1][j - 1] != 1){
//                    int top = obstacleGrid[i - 1][j] == 1 ? 0 : dp[i - 1][j];
//                    int left = obstacleGrid[i][j - 1] == 1 ? 0 : dp[i][j - 1];
//                    dp[i][j] = top + left;
//                }
            }
        }

        return dp[obstacleGrid.length][obstacleGrid[0].length];
    }

    public static void main(String[] args) {
        new _63_不同路径_II().uniquePathsWithObstacles(new int[][]{{0,0,0},  {0,1,0}, {0,0,0}});
    }

}
