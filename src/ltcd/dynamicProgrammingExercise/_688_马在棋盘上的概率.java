package ltcd.dynamicProgrammingExercise;

public class _688_马在棋盘上的概率 {

//    1.定义状态：“马” 仍留在棋盘上的概率
//    dp[i][j]： 位置(i, j)有马的概率
//    2.初始化状态：dp[r][c] = 1
//    3.状态转移
//        用两个dp数组，cur记录当前概率，nxt记录移动一次以后的概率
//        next[x][y] += cur[i][j] / 8
//        其中，(x, y) 是移动后位置，(i, j) 是移动前位置
//        也就是说 (i, j) 有1/8的概率移动到 (x, y)
//    4.返回cur所有位置的概率和

    public double knightProbability(int n, int K, int row, int column) {
        if (n <= 2 && K > 0) {
            return 0;
        }

        if (K == 0) {
            return 1;
        }

        int[] dx = {1, 1, 2, 2, -1, -1, -2, -2};
        int[] dy = {2, -2, 1, -1, 2, -2, 1, -1};
        double[][] cur = new double[n][n];
        cur[row][column] = 1;

        for (int k = 0; k < K; k++) {
            double[][] next = new double[n][n];
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    for (int i = 0; i < 8; i++) {
                        int newX = x + dx[i];
                        int newY = y + dy[i];

                        if (newX >= 0 && newX < n && newY >= 0 && newY < n) {
                            next[newX][newY] += cur[x][y] / 8.0;
                        }
                    }
                }
            }
            cur = next;
        }

        double res = 0.0;
        for (double[] r : cur) {
            for (double p: r) {
                res += p;
            }
        }

        return res;
    }

}
