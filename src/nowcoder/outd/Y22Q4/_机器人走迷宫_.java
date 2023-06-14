package nowcoder.outd.Y22Q4;

import java.util.Scanner;

/**
 * 机器人走一个迷宫，给出迷宫的 x和y(x*y的迷宫) 并且迷宫中有障碍物，输入 k 表示障碍物有 k 个，并且会将障碍物的坐标挨个输入。
 * 机器人从 0,0 的位置走到 x,y 的位置并且只能向 x,y 增加的方向走，不能回退，
 * 如代码类注释展示的样子，# 表示可以走的方格，0代表障碍，机器人从0,0的位置只能 向上或者向右 走到出口，
 * 其中会有不可达方格和陷阱方格。
 * 不可达方格为第四行前三个，该机器人在行走路径上不可能走到的方格，陷阱方格如第一行最后两个，走进之后则不能抵达终点。
 * 要求: 输出陷阱 和 不可达方格方格数量。
 * 输入描述：
 * 1）第一行为房间的 X 和 Y （0 <= X/Y <= 1000）
 * 2) 第一行为房间中的墙壁障碍物个数 N，0<= N <=X*Y ）
 * 3) 接下来会有 N 行墙壁的坐标，同一行中若有多个障碍物，以空格隔开，所有数据输入均合法。
 * 输出描述：
 * 陷阱方格与不可达方格数量，以空格隔开。
 *
 * 示例1：
 * 	输入：
 * 		6 4
 * 		5
 * 		0 2
 * 		1 2
 * 		2 2
 * 		4 1
 * 		5 1
 * 	输出：
 * 		2 3
 */
public class _机器人走迷宫_ {

    static int pitfall = 0;
    static int inaccessed = 0;
    static int[][] visited;
    static int[][] arr;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] mn = s.split(" ");
        int n = Integer.parseInt(mn[0]);
        int m = Integer.parseInt(mn[1]);
        // 创建迷宫
        arr = new int[m][n];
        int k = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < k; i++) {
            String line = scanner.nextLine();
            String[] split = line.split(" ");
            int y = Integer.parseInt(split[0]);
            int x = Integer.parseInt(split[1]);
            // -1 表示该位置是障碍物
            arr[x][y] = -1;
        }

        // 尝试从 (0, 0) 出发，向上或向右 走到 (m, n)
        visited = new int[m][n];
        dfs(0, 0);

        // 统计陷进和不可达数量
        // 0 是没有被访问过的点——不可达的点
        // 1 是被访问过的点，且可达出口——可达出口的点
        // -2 是被访问过的点，但是不可达出口——是陷进点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pitfall += visited[i][j] == 0 ? 1 : 0;
                inaccessed += visited[i][j] == -2 ? 1 : 0;
            }
        }
        System.out.println(inaccessed + " " + pitfall);
        int a = arr[3][2];
    }

    // x:横坐标，y:众坐标
    private static boolean dfs(int x, int y) {
        // 超出边界
        if (x >= arr.length || y >= arr[0].length) {
            return false;
        }

        // 到达出口
        if (x == arr.length - 1 && y == arr[0].length - 1) {
            // 出口的点也应该修改为可达
            visited[x][y] = 1;
            return true;
        }

        if (arr[x][y] == -1) {
            // 该点是障碍物，无法通过改点达到出口
            visited[x][y] = 2;
            return false;
        }

        // 如果向上或者向下走可以到达出口，则改点可到出口，不是陷阱
        boolean up = dfs(x, y + 1);
        boolean right = dfs(x + 1, y);

        if (right || up) {
            // 可达出口，标记为 1
            visited[x][y] = 1;
        } else {
            // 不可达出口，则标记为 2
            visited[x][y] = -2;
        }

        return visited[x][y] == 1;
    }

}
