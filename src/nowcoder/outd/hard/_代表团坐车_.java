package nowcoder.outd.hard;

import java.util.Scanner;

/**
 * 某组织举行会议，来了多个代表团同时到达，接待处只有一辆汽车，可以同时接待多个代表团，为了提高车辆利用率，请帮接待员计算可以坐满车的接待方案，输出方案数量。
 * 约束:
 * 	1.一个团只能上一辆车，并且代表团人数(代表团数量小于30，每人代表团人数小于30)小于汽车容量(汽车容量小于100)
 * 	2.需要将车辆坐满
 * 输入描述:
 * 	第一行 代表团人数，英文逗号隔开，代表团数量小于30，每个代表团人数小于30
 * 	第二行 汽车载客量，汽车容量小于100
 * 输出描述:
 * 	坐满汽车的方案数量
 * 	如果无解输出0
 *
 * 示例1：
 * 	输入:
 * 		5,4,2,3,2,4,9
 * 		10
 * 	输出:
 * 		4
 * 说明: 以下几种方式都可以坐满车，[2,3 5]、[2,4,4]、[2,3,5]、[2,4,4]
 */
public class _代表团坐车_ {

    static int res = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");
        int target = Integer.parseInt(scanner.nextLine());
        int n = split.length;
        int[] presentations = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            presentations[i] = Integer.parseInt(split[i]);
            sum += presentations[i];
        }

        // 初始化动态规划数组，dp[i]表示载客量为i时的方案数
        int[] dp = new int[target + 1];
        // 载客量为 0 时，只有一种方案（不接待任何代表团）
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            // 从后往前遍历，避免重复计算
            for (int j = target; j >= presentations[i]; j--) {
                // 转移方程：dp[j] += dp[j - group]，表示加上接待当前代表团后的方案数
                dp[j] += dp[j - presentations[i]];
            }
        }


        System.out.println(dp[target]);
    }

}
