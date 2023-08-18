package nowcoder.outd.Y22Q3;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * 输入一行字符串，字符串可转换为 N*N 的数组，数组可认为是一个水域，
 * 判断多少天后，水域被全部污染。
 * 数组中只有0和1，0表示纯净，1表示污染，
 * 每天只可污染上下左右的水域，
 * 如果开始全部被污染，或永远无法污染，则返回-1。
 *
 * 示例1：
 * 	输入：
 * 		1,0,1,0,0,0,1,0,1
 * 	输出：
 * 		2
 * 解释：
 * 	转化为数组为：
 * 	1 0 1
 * 	0 0 0
 * 	1 0 1
 * 	第一天后水域变为
 * 	1 1 1
 * 	1 0 1
 * 	1 1 1
 * 	第二天全部被污染
 * 	1 1 1
 * 	1 1 1
 * 	1 1 1
 *
 * 示例2：
 * 	输入：
 * 		0,0,0,0
 * 	输出：
 * 		-1
 */
public class _污染水域_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");
        int n = (int) Math.sqrt(split.length);
        int[][] matrix = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        int[][] direction = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> pollution = new ArrayDeque<>();

        for (int i = 0; i < split.length; i++) {
            int value = Integer.parseInt(split[i]);
            matrix[i / n][i % n] = value;
            if (value == 1) {
                pollution.offer(new int[] {i / n, i % n});
                visited[i / n][i % n] = true;
            }
        }

        if (pollution.isEmpty()) {
            System.out.println(-1);
            return;
        }

        int levelSize = pollution.size();
        int levels = 0;
        while (!pollution.isEmpty()) {
            int[] poll = pollution.poll();
            levelSize--;

            // 开始污染
            for (int[] item : direction) {
                int newX = item[0] + poll[0];
                int newY = item[1] + poll[1];

                // 没有越界、没有被污染
                if (newX >= 0 && newX < n && newY >= 0 && newY < n && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    pollution.add(new int[]{newX, newY});
                }
            }

            // 一层遍历结束，层数 + 1，重新初始化新的一层污染点数量
            if (levelSize == 0) {
                levels++;
                levelSize = pollution.size();
            }
        }

        System.out.println(levels - 1);
    }

}
