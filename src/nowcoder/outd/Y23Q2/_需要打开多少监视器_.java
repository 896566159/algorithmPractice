package nowcoder.outd.Y23Q2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 某长方形停车场，每个车位上方都有对应监控器，当且仅当在当前车位或者前后左右四个方向任意一个车位范围停车时，监控器才需要打开:
 * 给出某一时刻停车场的停车分布，请统计最少需要打开多少个监控器
 * 	输入描述：
 * 		第一行输入m，n表示长宽，满足1 < m,n <= 20;
 * 		后面输入m行，每行有n个0或1的整数，整数间使用一个空格隔开，表示该行已停车情况，其中0表示空位，1表示已停:
 * 	输出描述：
 * 		最少需要打开监控器的数量
 * 示例1：
 * 	输入：
 * 		3 3
 * 		0 0 0
 * 		0 1 0
 * 		0 0 0
 * 	输出：
 * 		5
 * 说明：中间1的位置上需要打开监视器，且其上下左右皆需要打开监视器，共5个。
 */
public class _需要打开多少监视器_ {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(" ");
        int m = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);
        int[][] nums = new int[m][n];

        for (int i = 0; i < m; i++) {
            split = in.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                nums[i][j] = Integer.parseInt(split[j]);
            }
        }

        Set<int[]> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[i][j] == 1) {
                    set.add(new int[] {i, j});
                } else {
                    if ((i - 1 >= 0 && nums[i - 1][j] == 1)
                        || (i + 1 < m && nums[i + 1][j] == 1)
                        || (j - 1 >= 0 && nums[i][j - 1] == 1)
                        || (j + 1 < n && nums[i][j + 1] == 1)) {
                        set.add(new int[] {i, j});
                    }
                }
            }
        }

        System.out.println(set.size());
    }
}
