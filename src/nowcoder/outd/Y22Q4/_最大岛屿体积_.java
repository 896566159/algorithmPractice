package nowcoder.outd.Y22Q4;

import java.util.Scanner;

/**
 * 给你一个由 大于0的数（陆地）和 0（水）组成的的二维网格，
 * 请你计算网格中最大岛屿的体积。
 * 陆地的数表示所在岛屿的体积。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 输入描述：
 * 	第一行是二维网格的宽和高。
 * 	后面几行是二维网格。
 *
 * 输出描述：
 * 	输出岛屿的最大体积。
 *
 * 样例：
 * 	输入：
 * 		5 5
 * 		0 1 1 0 0
 * 		0 1 1 0 0
 * 		0 0 0 0 0
 * 		0 0 1 2 3
 * 		0 0 1 3 9
 * 	输出：
 * 		19
 */
public class _最大岛屿体积_ {

    static boolean[][] visited;
    static int max = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] in = scanner.nextLine().split(" ");
        int m = Integer.parseInt(in[0]);
        int n = Integer.parseInt(in[1]);
        int[][] matrix = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String[] split = scanner.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(split[j]);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && matrix[i][j] != 0) {
                    dfs(matrix, i, j, matrix[i][j]);
                } else if (matrix[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }
        System.out.println(max);

//        int[][] dp = new int[m + 1][n + 1];
//        // 初始化 dp 的第一列数据
//        for (int i = 0; i < m; i++) {
//            dp[i + 1][0] = matrix[i][0];
//        }
//        // 初始化 dp 的第一行数据
//        for (int i = 0; i < n; i++) {
//            dp[0][i + 1] = matrix[0][i];
//        }
//        int maxIsland = 0;
//        for (int i = 1; i <= m; i++) {
//            for (int j = 1; j <= n; j++) {
//                if (matrix[i - 1][j - 1] == 0) {
//                    dp[i][j] = 0;
//                } else {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + matrix[i - 1][j - 1];
//                    maxIsland = Math.max(maxIsland, dp[i][j]);
//                }
//            }
//        }
//
//        System.out.println(maxIsland);
    }

    private static void dfs(int[][] matrix, int i, int j, int sum) {
        // 被访问过了或者下标越界了
        if (i >= matrix.length || j >= matrix[0].length || visited[i][j]) {
            return;
        }

        visited[i][j] = true;
        // 向下
        if (i + 1 < matrix.length && matrix[i + 1][j] != 0) {
            sum += matrix[i + 1][j];
            dfs(matrix, i + 1, j, sum);
        }
        // 向右
        if (j + 1 < matrix[0].length && matrix[i][j + 1] != 0) {
            sum += matrix[i][j + 1];
            dfs(matrix, i, j + 1, sum);
        }
        max = Math.max(max, sum);
    }
}
