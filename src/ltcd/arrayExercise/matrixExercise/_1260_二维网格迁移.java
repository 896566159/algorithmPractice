package ltcd.arrayExercise.matrixExercise;

import java.util.ArrayList;
import java.util.List;

public class _1260_二维网格迁移 {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        k %= m * n;
        int tmp = k;
        List<Integer> list = new ArrayList<>();

        //移动后成为第一行的元素
        for (int i = m - 1; i >= 0 && tmp > 0; i--) {

            for (int j = n - 1; j >= 0 && tmp > 0; j--) {
                list.add(0, grid[i][j]);
                tmp--;
            }
        }

        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            temp.add(list.get(i));

            if (temp.size() == n) {
                ans.add(new ArrayList<>(temp));
                temp = new ArrayList<>();
            }
        }

        list = temp;
        tmp = m * n - k;
        for (int i = 0; i < m && tmp > 0; i++) {

            for (int j = 0; j < n && tmp > 0; j++) {
                tmp--;
                list.add(grid[i][j]);

                if (list.size() == n) {
                    ans.add(new ArrayList<>(list));
                    list = new ArrayList<>();
                }
            }
        }

        return ans;
    }

}
