package nowcoder.outd.Y22Q4;

import java.util.Scanner;

/**
 * 某云短信厂商，为庆祝国庆，推出充值优惠活动。
 * 现在给出客户预算，和优惠售价序列，求最多可获得的短信总条数。
 *
 * 输入描述：
 * 	第一行客户预算 M，其中 0 ≤ M ≤ 10^6
 * 	第二行给出售价表， P1, P2, … Pn , 其中 1 ≤ n ≤ 100 ,
 * 	Pi为充值 i 元获得的短信条数。
 * 	1 ≤ Pi ≤ 1000 , 1 ≤ n ≤ 100
 *
 * 输出描述：
 * 	最多获得的短信条数
 *
 * 示例1：
 * 	输入：
 * 		6
 * 		10 20 30 40 60
 * 	输出：
 * 		70
 *
 * 说明：分别充值1元和5元，可以获得10+60条短信，共70条，最大。
 *
 * 示例2：
 * 	输入：
 * 		15
 * 		10 20 30 40 60 60 70 80 90 150
 * 	输出：
 * 		210
 * 说明：分别充值10元和5元，可以获得150+60条短信，共210条，最大。
 */
public class _最多获得的短信条数_ {

    public static void main(String[] args) {
        //处理输入
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] split = scanner.nextLine().split(" ");
        int[] dp = new int[n + 2];

        int choices = split.length;
        int[] p = new int[choices];
        for (int i = 0; i < choices; i++) {
            p[i] = Integer.parseInt(split[i]);
            dp[i + 1] = p[i];
        }

        for (int i = 1; i <= n; i++) {
            int max = dp[i];

            for (int j = 0; j < choices && j < i; j++) {
                max = Math.max(p[j] + dp[i - j - 1], max);
            }

            dp[i] = max;
        }

        System.out.println(dp[n - 1]);
    }

}
