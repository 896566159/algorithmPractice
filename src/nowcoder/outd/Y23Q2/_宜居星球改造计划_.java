package nowcoder.outd.Y23Q2;

import java.util.*;

/**
 * 2XXX年，人类通过对火星的大气进行宜居改造分析，使得火星已在理论上具备人类宜居的条件，由于技术原因，无法一次性将火星大气全部改造，只能通过局部处理形式，
 * 假设将火星待改造的区域为row * column的网格每个网格有3个值，宜居区、可改造区、死亡区，使用YES、NO、NA代替，
 * YES表示该网格已经完成大气改造，
 * NO表示该网格未进行改造，后期可进行改造，
 * NA表示死亡区，不作为判断是否改造完成的宜居，无法穿过
 * 初始化下，该区域可能存在多个宜居区，并且每个宜居区能同时在每个太阳日单位向上下左右四个方向的相邻格子进行扩散，自动将4个方向相邻的真空区改造成宜居区;
 * 请计算这个待改造区域的网格中，可改造区是否能全部变成宜居区，如果可以，则返回改造的太阳日天数，不可以则返回-1。
 *
 * 输入描述:
 * 	输入row*column个网格数据，每个网格值枚举值如下: YES，NO，NA，样例:
 * 	YES YES NO
 * 	NO NO NO
 * 	NA NO YES
 * 输出描述:
 * 	能全部变成宜居区，如果可以，则返回改造的太阳日天数，不可以则返回-1.
 * 补充说明:
 * 	grid[i]只有3种情况，YES、NO、NA
 * 	row == grid.length, column == grid[i].length, 1 <= row, column <= 8
 *
 * 示例1
 * 	输入:
 * 		YES YES NO
 * 		NO NO NO
 * 		YES NO NO
 * 	输出:
 * 		2
 * 说明: 经过2个太阳日，完成宜居改造.
 *
 * 示例2
 * 	输入:
 * 		YES NO NO NO
 * 		NO NO NO NO
 * 		NO NO NO NO
 * 		NO NO NO NO
 * 	输出:
 * 		6
 * 说明: 经过6个太阳日，可完成改造
 *
 *
 * 示例3
 * 	输入:
 * 		NO NA
 * 	输出:
 * 		-1
 * 说明: 无改造初始条件，无法进行改造
 *
 *
 * 示例4
 * 	输入:
 * 		YES NO NO YES
 * 		NO NO YES NO
 * 		NO YES NA NA
 * 		YES NO NA NO
 * 	输出:
 * 		-1
 * 说明: 右下角的区域，被周边三个死亡区挡住，无法实现改造
 */
public class _宜居星球改造计划_ {

    static int countNO = 0;
    static int countYES = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split;
        int step = 0;

        List<int[]> points = new ArrayList<>();
        List<String[]> input = new ArrayList<>();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if ("".equals(line)) {
                // 空行跳出
                break;
            }
            input.add(line.split(" "));
        }

        int m = input.size();
        int n = input.get(0).length;
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (input.get(i)[j].equals("YES")) {
                    grid[i][j] = 1;
                    countYES++;
                    points.add(new int[]{i, j});
                } else if (input.get(i)[j].equals("NO")) {
                    grid[i][j] = 0;
                    countNO++;
                } else {
                    grid[i][j] = -1;
                }
            }
        }

        // 改造初始条件，无法进行改造
        if (countYES == 0) {
            System.out.println(-1);
            return;
        }

        // 从每一个 YES 同时开始从上下左右改造
        while (true) {
            Set<int[]> tmp = new HashSet<>();
            for (int i = 0; i < points.size(); i++) {
                int[] point = points.get(i);
                int x = point[0];
                int y = point[1];

                // 下
                if (x + 1 < m && grid[x + 1][y] == 0) {
                    grid[x + 1][y] = 1;
                    countNO--;
                    tmp.add(new int[] {x + 1, y});
                }
                // 上
                if (x - 1 >= 0 && grid[x - 1][y] == 0) {
                    grid[x - 1][y] = 1;
                    countNO--;
                    tmp.add(new int[] {x - 1, y});
                }
                // 左
                if (y - 1 >= 0 && grid[x][y - 1] == 0) {
                    grid[x][y - 1] = 1;
                    countNO--;
                    tmp.add(new int[] {x, y - 1});
                }
                // 右
                if (y + 1 < n && grid[x][y + 1] == 0) {
                    grid[x][y + 1] = 1;
                    countNO--;
                    tmp.add(new int[] {x, y + 1});
                }
            }

            // 没有改造区被改造——①不可访问其他改造区 ②其他改造区已经全部改造结束
            if (tmp.isEmpty()) {
                break;
            }
            step++;
            points = new ArrayList<>(tmp);
        }

        if (countNO == 0) {
            System.out.println(step);
        } else {
            System.out.println(-1);
        }
    }

}
