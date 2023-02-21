package ltcd.depthFirstSearchExercise;

public class _剑指_Offer_13_机器人的运动范围 {


    public int movingCount(int m, int n, int k) {

        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    private int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || (i / 10 + i % 10 + j / 10 + j % 10) > k) {
            return 0;
        }

        visited[i][j] = true;

        return 1 + dfs(i + 1, j, m, n, k, visited) + dfs(i, j + 1, m, n, k, visited) + dfs(i - 1, j, m, n, k, visited) + dfs(i, j - 1, m, n, k, visited);
    }

    public static void main(String[] args) {
        System.out.println(new _剑指_Offer_13_机器人的运动范围().movingCount(2, 3, 1));
    }

}
