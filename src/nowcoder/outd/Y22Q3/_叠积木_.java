package nowcoder.outd.Y22Q3;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 给出一个列表如[[6,7,],[5,4],[3,2]],表示木块的长和宽，
 * 当木块的长和宽不大于另个木块的长和宽时，就可以放在上面，
 * 此外数组还可以左右翻转。
 * 求最多能搭多少层。
 *
 * 输入描述：
 * 	一个二维数组，里面是每个积木的长和宽，可以左右翻转。
 * 输出描述：
 * 	最多能搭多少层。
 *
 * 示例1：
 * 	输入：
 * 		[[5,4],[6,3],[6,7],[6,6],[4,6]]
 * 		1
 * 	输出：
 * 		4
 */
public class _叠积木_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().replace("],[", "#").replace("[", "").replace("]", "").split("#");
        int n = split.length;
        int[][] blocks = new int[n][2];

        // 处理输入
        for (int i = 0; i < n; i++) {
            String[] item = split[i].split(",");
            int len1 = Integer.parseInt(item[0]);
            int len2 = Integer.parseInt(item[1]);
            // 默认将长的一边作为长，短的一边作为宽
            blocks[i][0] = Math.min(len1, len2);
            blocks[i][1] = Math.max(len1, len2);
        }

        // 排序，按照最长的一边排序
        Arrays.sort(blocks, (a, b)->a[1] - b[1]);

        // 动态规划，dp[i] 表示如果积木为 i 时，最大积木嵌套数
        int[] dp = new int[n];
        Arrays.fill(dp, 0);  // 初始化为1

        int max = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (blocks[i][0] >= blocks[j][0]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }

            // 叠上该木块
            dp[i] += 1;
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

}
