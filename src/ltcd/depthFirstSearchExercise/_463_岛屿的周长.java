package ltcd.depthFirstSearchExercise;

public class _463_岛屿的周长 {

    int ans = 0;

    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                }
            }
        }

        return ans;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }

        grid[i][j] = 2;

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);

        if (i - 1 < 0 || (i - 1 >= 0 && grid[i - 1][j] != 2)) {
            ans++;
        }
        if (i + 1 >= grid.length || (i + 1 < grid.length && grid[i + 1][j] != 2)) {
            ans++;
        }
        if (j - 1 < 0 || (j - 1 >= 0 && grid[i][j - 1] != 2)) {
            ans++;
        }
        if (j + 1 >= grid[0].length || (j + 1 < grid[0].length && grid[i][j + 1] != 2)) {
            ans++;
        }

    }

}
