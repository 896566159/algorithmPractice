package ltcd.arrayExercise.matrixExercise;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 使用bfs
 */
public class _1162_地图分析 {

    public int maxDistance(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int ans = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        int rows = grid.length;
        int cols = grid[0].length;

        //将所有 1 都入队，将所有 0 改成 -1 表示没有访问过
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                } else {
                    grid[i][j] = -1;
                }
            }
        }

        //所有点都是 0
        if (queue.isEmpty()) {
            return -1;
        }

        //dx、dy 表示坐标位置偏移，即上、下、左、右
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        //如果队列不是空，则说明未将所有的 -1 重新填充过
        while (!queue.isEmpty()) {
            int[] point = queue.poll();//访问过的元素的坐标
            int x = point[0];
            int y = point[1];

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                //如果当前点的上、下、左、右几个点中有一个是 -1 为访问过的，则将改点更改距离（海洋到陆地的距离）
                //并将该点入队
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == -1) {
                    grid[newX][newY] = grid[x][y] + 1;
                    ans = Math.max(ans, grid[newX][newY]);
                    queue.offer(new int[]{newX, newY});
                }
            }
        }

        return ans;
    }

}
