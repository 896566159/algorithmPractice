package ltcd.bethFirstSearchExercise;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class _994_腐烂的橘子_ {

    public int orangesRotting(int[][] grid) {
        Set<int[]> rotPoints = new HashSet<>();
        int m = grid.length;
        int n = grid[0].length;
        int countFresh = 0;
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    rotPoints.add(new int[] {i, j});
                } else if (grid[i][j] == 1){
                    countFresh++;
                }
            }
        }

        if (rotPoints.isEmpty()) {
            return 0;
        }

        // 从每一个腐烂的橘子同时向上下左右感染
        while (true) {
            Set<int[]> tmp = new HashSet<>();
            Iterator<int[]> iterator = rotPoints.iterator();
            while (iterator.hasNext()) {
                int[] rot = iterator.next();
                int x = rot[0];
                int y = rot[1];

                // 上
                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    countFresh--;
                    grid[x - 1][y] = 2;
                    tmp.add(new int[] {x - 1, y});
                }
                // 下
                if (x + 1 < m && grid[x + 1][y] == 1) {
                    countFresh--;
                    grid[x + 1][y] = 2;
                    tmp.add(new int[] {x + 1, y});
                }
                // 左
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    countFresh--;
                    grid[x][y - 1] = 2;
                    tmp.add(new int[] {x, y - 1});
                }
                // 右
                if (y + 1 < n && grid[x][y + 1] == 1) {
                    countFresh--;
                    grid[x][y + 1] = 2;
                    tmp.add(new int[] {x, y + 1});
                }
            }

            if (tmp.isEmpty()) {
                break;
            }
            rotPoints = tmp;
            res++;
        }

        return countFresh == 0 ? res : -1;
    }

}
