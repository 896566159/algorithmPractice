package nowcoder.outd.Y22Q4;

import java.util.Scanner;

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
