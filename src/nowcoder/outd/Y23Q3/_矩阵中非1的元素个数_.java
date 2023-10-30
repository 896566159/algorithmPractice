package nowcoder.outd.Y23Q3;

import java.util.Scanner;

public class _矩阵中非1的元素个数_ {

    // 矩阵
    static int[][] matrix;
    // 标记在回溯的过程中，是否被访问过
    static boolean[][] visited;
    // 访问节点的上下左右节点时的方向
    static int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int m = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);
        matrix = new int[m][n];
        visited = new boolean[m][n];

        // 输入处理
        for (int i = 0; i < m; i++) {
            split = scanner.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(split[j]);
            }
        }

        // 默认左上角的位置为 1
        matrix[0][0] = 1;
        int notOne = 0;
        dfs(0, 0);

        // 统计输出
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 1) {
                    notOne++;
                }
            }
        }
        System.out.println(notOne);
    }

    // 回溯尝试感染1附近的所有0
    private static void dfs(int i, int j) {
        // 0被感染成1
        matrix[i][j] = 1;
        // 上下左右
        for (int[] direction : directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];

            if (newI >= 0 && newI < matrix.length && newJ >= 0 && newJ < matrix[0].length
                && matrix[newI][newJ] != 2
                && !visited[newI][newJ]) {
                visited[newI][newJ] = true;
                dfs(newI, newJ);
            }
        }
    }
}
