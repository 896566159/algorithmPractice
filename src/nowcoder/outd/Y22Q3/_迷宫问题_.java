package nowcoder.outd.Y22Q3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 定义一个二维数组 N*M，如 5 x 5 数组下所示:
 * int maze[5][5] = {
 * 0 1 0 0 0
 * 0 1 1 1 0
 * 0 0 0 0 0
 * 0 1 1 1 0
 * 0 0 0 1 0
 * }
 * 它表示一迷宫，其中的 1 表示墙壁，0 表示可以走的路，
 * 只能横着走或竖着走，不能斜着走，
 * 要求编程序找出从左上角到右下角的最短路径
 * 入口点为[00]既第一格是可以走的路。
 * 数据范围: 2<=nm<=10，输入的内容只包含 0<=val<=1.
 *
 * 输入描述：
 * 	输入两个整数，分别表示二维数组的行数，列数。再输入相应的数组，其中的 1 表示墙壁，
 * 	0 表示可以走的路。数据保证有唯一解不考虑有多解的情况，即迷宫只有一条通道。
 * 输出描述：
 * 	左上角到右下角的最短路径，格式如样例所示
 *
 * 示例1：
 * 	输入：
 * 		5 5
 * 		0 1 0 0 0
 * 		0 1 0 1 0
 * 		0 0 0 0 0
 * 		0 1 1 1 0
 * 		0 0 0 1 0
 * 	输出：
 * 		(0,0)
 * 		(1,0)
 * 		(2,0)
 * 		(2,1)
 * 		(2,2)
 * 		(2,3)
 * 		(2,4)
 * 		(3,4)
 * 		(4,4)
 *
 * 示例2：
 * 	输入：
 * 		5 5
 * 		0 1 0 0 0
 * 		0 1 0 1 0
 * 		0 0 0 1 0
 * 		0 1 1 1 0
 * 		0 0 0 0 0
 * 	输出：
 * 		(0,0)
 * 		(1,0)
 * 		(2,0)
 * 		(3,0)
 * 		(4,0)
 * 		(4,1)
 * 		(4,2)
 * 		(4,3)
 * 		(4,4)
 */
public class _迷宫问题_ {

    static int[][] matrix;
    static boolean[][] visited;
    static boolean isBlock = true;
    static int[][] direction = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static List<int[]> res;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[0]);
        matrix = new int[n][m];
        visited = new boolean[n][m];
        res = null;

        // 初始化矩阵
        for (int i = 0; i < n; i++) {
            split = scanner.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(split[j]);
            }
        }

        if (matrix[n - 1][m - 1] == 1) {
            System.out.println(-1);
            return;
        }

        List<int[]> path = new ArrayList<>();
        path.add(new int[] {0, 0});
        // 一开始出发，从左上角 [0, 0] 位置开始，尝试到达右下角
        dfs(0, 0, path);

        // 如果能够成功达到右下角，则输出最短路径上的点
        if (!isBlock) {
            for (int[] item : res) {
                System.out.println("(" + item[0] + "," + item[1] + ")");
            }
        }
    }

    // 尝试从 [i, j] 这个位置到达终点，能达到的话是否是最短路径
    private static void dfs(int i, int j, List<int[]> path) {
        // 达到右下角，判断是否是最短路径，是则更新
        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
            isBlock = false;
            // 此次能够顺利到达右下角，并且路径上的点比较少——故更新答案
            if (res == null || res.size() > path.size()) {
                res = new ArrayList<>(path);
            }
            return;
        }

        // 越界、被访问过、是墙（无法通过）
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || visited[i][j] || matrix[i][j] == 1) {
            return;
        }

        // 标记 [i, j] 位置已经被访问过了。如果不进行标记，那么就会再访问，那就是走了回头路，进入死循环了
        visited[i][j] = true;
        // 上下左右
        for (int[] item : direction) {
            int newX = item[0] + i;
            int newY = item[1] + j;

            path.add(new int[] {newX, newY});
            dfs(newX, newY, path);
            // 回溯
            path.remove(path.size() - 1);
        }
        // 回溯
        visited[i][j] = false;
    }

}
