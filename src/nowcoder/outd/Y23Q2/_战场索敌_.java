package nowcoder.outd.Y23Q2;

import java.util.Scanner;

/**
 * 有一个大小是 N*M 的战场地图，被墙壁 '#' 分隔成大小不同的区域，上下左右四个方向相邻的空地 '.'，属于同一个区域，
 * 只有空地上可能存在敌人'E'，请求出地图上总共有多少区域里的敌人数小于K。
 *
 * 输入描述：
 * 	第一行输入为N，M，K;
 * 	N表示地图的行数，M表示地图的列数，K表示目标敌人数量；N，M<=100
 * 	之后为一个 N * M 大小的字符数组
 * 输出描述：
 * 	敌人数小于K的区域数量
 *
 * 示例1：
 * 	输入：
 * 		3 5 2
 * 		..#EE
 * 		E.#E.
 * 		###..
 * 	输出：
 * 		1
 * 说明：
 * 	地图被墙壁分为两个区域，左边区域有1个敌人，右边区域有3个敌人，符合条件的区域数量是1
 */
public class _战场索敌_ {

    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int k = Integer.parseInt(split[2]);
        char[][] map = new char[n][m];
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            char[] line = scanner.nextLine().toCharArray();
            for (int j = 0; j < line.length; j++) {
                map[i][j] = line[j];
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    if (map[i][j] == '#') {
                        visited[i][j] = true;
                    } else {
                        int f = f(map, i, j, 0);
                        if (f < k) {
                            count++;
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }

    private static int f(char[][] map, int i, int j, int count) {
        if (i >= map.length || j >= map[0].length || i < 0 || j < 0) {
            return 0;
        }

        visited[i][j] = true;
        if (map[i][j] == 'E') {
            count++;
        }

        // 上下左右
        if (i + 1 < map.length && !visited[i + 1][j] && map[i + 1][j] != '#') {
            count += f(map, i + 1, j, 0);
        }
        if (i - 1 >= 0 && !visited[i - 1][j] && map[i - 1][j] != '#') {
            count += f(map, i - 1, j, 0);
        }
        if (j + 1 < map[0].length && !visited[i][j + 1] && map[i][j + 1] != '#') {
            count += f(map, i, j + 1, 0);
        }
        if (j - 1 >= 0 && !visited[i][j - 1] && map[i][j - 1] != '#') {
            count += f(map, i, j - 1, 0);
        }

        return count;
    }
}
