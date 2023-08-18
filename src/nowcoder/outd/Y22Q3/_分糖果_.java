package nowcoder.outd.Y22Q3;

import java.util.Scanner;

/**
 * 小明从糖果盒中随意抓一把糖果，每次小明会取出一半的糖果分给同学们。
 * 当糖果不能平均分配时，小明可以选择从糖果盒中（假设盒中糖果足够）取出一个糖果或放回一个糖果。
 * 小明最少需要多少次（取出、放回和平均分配均记一次），能将手中糖果分至只剩一颗。
 *
 * 输入描述：
 * 	抓取的糖果数（<10000000000）
 *
 * 输出描述：
 * 	最少分至一颗糖果的次数：
 *
 * 示例1：
 * 	输入：
 * 		15
 * 	输出：
 * 		5
 *
 * 解释：
 * 	(1)15+1=16;
 * 	(2)16/2=8;
 * 	(3)8/2=4;
 * 	(4)4/2=2;
 * 	(5)2/2=1;
 */
public class _分糖果_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int dfs = dfs(n, 0);
        System.out.println(dfs);

        System.out.println("网上的做法:动态规划，从底向顶");
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2] + 1;
            } else {
                dp[i] = Math.min(dp[(i - 1) / 2], dp[(i + 1) / 2]) + 2;
            }
        }
        System.out.println(dp[n]);
    }

    private static int  dfs(int n, int count) {
        if (n == 1) {
            return count;
        }

        if (n % 2 == 0) {
            return dfs(n / 2, count + 1);
        } else {
            return Math.min(dfs((n + 1) / 2, count + 2), dfs((n - 1) / 2, count + 2));
        }
    }

}
