package nowcoder.outd.Y23Q2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 给你一个由0(空地)、1(银矿) 、2(金矿)组成的的地图，矿堆只能由上下左右相邻的金矿或银矿连接形成。超出地图范围可以认为是空地。
 * 假设银矿价值1 ，金矿价值2 ，请你找出地图中最大价值的矿堆并输出该矿堆的价值
 * 输入描述：
 * 	地图元素信息如:
 * 		22220
 * 		00000
 * 		00000
 * 		11111
 * 	地图范围最大 300*300
 * 	0<= 地图元素 <=2
 * 输出描述:
 * 	矿堆的最大价值
 *
 * 示例1:
 * 	输入:
 * 		22220
 * 		00000
 * 		00000
 * 		01111
 * 	输出:
 * 		8
 *
 * 示例2:
 * 	输入:
 * 		22220
 * 		00020
 * 		00010
 * 		01111
 * 	输出:
 * 		15
 *
 *
 * 示例3:
 * 	输入:
 * 		20000
 * 		00020
 * 		00000
 * 		00111
 * 	输出:
 * 		3
 */
public class _寻找最大价值的矿堆_ {

    static boolean[][] visited;
    static int[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> area = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("")) {
                break;
            }
            area.add(line);
        }

        int m = area.size();
        int n = area.get(0).length();
        matrix = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String s = area.get(i);
            int j = 0;
            for (char c : s.toCharArray()) {
                matrix[i][j++] = c - '0';
            }
        }

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    visited[i][j] = true;
                    continue;
                }

                if (!visited[i][j]) {
                    max = Math.max(trans(i, j, 0), max);
                }
            }
        }

        System.out.println(max);
    }

    private static int trans(int i, int j, int value) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j] || matrix[i][j] == 0) {
            // 改点贡献度为 0
            return 0;
        }

        // 标记改点访问过
        visited[i][j] = true;
        value += trans(i + 1, j, 0);
        value += trans(i - 1, j, 0);
        value += trans(i, j + 1, 0);
        value += trans(i, j - 1, 0);

        // 当前该点的值 + 上下左右的值
        return value + matrix[i][j];
    }

}
