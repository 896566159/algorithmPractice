package ltcd.arrayExercise.matrixExercise;

import java.util.ArrayDeque;
import java.util.Queue;

public class _542_01矩阵 {

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0 || 0 == matrix[0].length) {
            return new int[][]{};
        }

        Queue<int[]> queue = new ArrayDeque<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        // 首先将所有的 0 都入队，并且将 1 的位置设置成 -1，表示该位置是 未被访问过的 1
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i , j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }

        //[dx, dy]表示上、下、左、右
        int[] dx = new int[]{-1, 0, 0, 1};
        int[] dy = new int[]{0, -1, 1, 0};

        while (!queue.isEmpty()) {
            int[] point = queue.poll();//从队列中弹出一个元素，该元素 matrix 中为 0 的元素位置[x, y]
            int x = point[0];
            int y = point[1];

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                // 如果四邻域的点是 -1，表示这个点是未被访问过的 1
                // 所以这个点到 0 的距离就可以更新成 matrix[x][y] + 1。
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols) {

                    if (matrix[newX][newY] == -1) {
                        matrix[newX][newY] = matrix[x][y] + 1;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }

        return matrix;
    }
}
