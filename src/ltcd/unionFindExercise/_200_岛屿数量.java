package ltcd.unionFindExercise;

public class _200_岛屿数量 {

    public static void main(String[] args) {
        _200_岛屿数量 v = new _200_岛屿数量();
        System.out.println(v.numIslandsdfs(new char[][]{{'1', '1', '1', '1', '1', '0', '1', '1', '1', '1'}, {'1', '0', '1', '0', '1', '1', '1', '1', '1', '1'}, {'0', '1', '1', '1', '0', '1', '1', '1', '1', '1'}, {'1', '1', '0', '1', '1', '0', '0', '0', '0', '1'}, {'1', '0', '1', '0', '1', '0', '0', '1', '0', '1'}, {'1', '0', '0', '1', '1', '1', '0', '1', '0', '0'}, {'0', '0', '1', '0', '0', '1', '1', '1', '1', '0'}, {'1', '0', '1', '1', '1', '0', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1', '1', '1', '1', '0', '1'}, {'1', '0', '1', '1', '1', '1', '1', '1', '1', '0'}}));
    }


    char[][] grid;
    int m;
    int n;
    /**
     * 深度优先解法
     * @param grid
     * @return
     */
    public int numIslandsdfs(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                count = grid[i][j] == '1' ? count + 1 : count;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // 如果当前是陆地，检查上下左右是否能和当前的陆地合并成一块
                if (this.grid[i][j] == '1') {
                    grid[i][j] = '0';
                    dfs(i, j, i + 1, j);
                    dfs(i, j, i - 1, j);
                    dfs(i, j, i, j + 1);
                    dfs(i, j, i, j - 1);
                }
            }
        }

        return count;
    }

    private void dfs(int i, int j, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '0') {
            return;
        }

        count--;
        grid[x][y] = '0';
        dfs(x, y, x + 1, y);
        dfs(x, y, x - 1, y);
        dfs(x, y, x, y + 1);
        dfs(x, y, x, y - 1);
    }

    // 记录每个元素指向的代表元
    int[] fa;
    // 以当前元素为代表元的子集合中的元素个数
    int[] size;
    // 不同的代表元的集合数量
    int count;

    /**
     * 并查集解法
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        count = 0;
        fa = new int[m * n];
        size = new int[m * n];

        // 初始化
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 矩阵从上到下、从左到右编号：[0 ~ n * m - 1]
                fa[i * n + j] = i * n + j;
                size[i * n + j] = 1;

                count = grid[i][j] == '1' ? count + 1 : count;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // 如果当前是陆地，检查上下左右是否能和当前的陆地合并成一块
                if (grid[i][j] == '1') {
                    int cur = i * n + j;

                    // 上
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        int up = (i - 1) * n + j;
                        // 合并
                        union(cur, up);
                    }

                    // 下
                    if (i + 1 < m && grid[i + 1][j] == '1') {
                        int down = (i + 1) * n + j;
                        // 合并
                        union(cur, down);
                    }

                    // 左
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        int left = i * n + j - 1;
                        // 合并
                        union(cur, left);
                    }

                    // 右
                    if (j + 1 < n && grid[i][j + 1] == '1') {
                        int right = i * n + j + 1;
                        // 合并
                        union(cur, right);
                    }
                }
            }
        }

        return count;
    }

    private void union(int a, int b) {
        int rootA = find(a);
        int upB = find(b);

        if (rootA == upB) {
            return;
        }

        // 不同的连通数量减一
        count--;
        if (size[rootA] < size[upB]) {
            fa[rootA] = upB;
            size[upB] += size[rootA];
        } else {
            fa[upB] = rootA;
            size[rootA] += size[upB];
        }
    }

    private int find(int target) {
        if (target == fa[target]) {
            return target;
        }

        // 路径压缩
        return fa[target] = find(fa[target]);
    }

}
