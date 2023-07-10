package nowcoder.outd.Y22Q4;

import java.util.Scanner;

/**
 * 商人经营一家店铺，有 number 种商品，
 * 由于仓库限制每件商品的最大持有数量是 item[index]
 * 每种商品的价格是 item-price[item_index][day]
 * 通过对商品的买进和卖出获取利润
 * 请给出商人在 days 天内能获取的最大的利润
 *
 * 注:同一件商品可以反复买进和卖出
 * 输入描述：
 * 3 第一行输入商品的数量 number
 * 3 第二行输入商品售货天数 days
 * 4 5 6 第三行输入仓库限制每件商品的最大持有数量是item[index]
 * 1 2 3 第一件商品每天的价格
 * 4 3 2 第二件商品每天的价格
 * 1 5 3 第三件商品每天的价格
 *
 * 示例1：
 * 	输入：
 * 		3
 * 		3
 * 		4 5 6
 * 		1 2 3
 * 		4 3 2
 * 		1 5 3
 * 	输出：
 * 		32
 *
 * 示例2：
 * 	输入：
 * 		1
 * 		1
 * 		1
 * 		1
 * 	输出：
 * 		0
 */
public class _最大利润_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 获取输入信息
        // 几种商品
        int number = scanner.nextInt();
        // 几天
        int days = scanner.nextInt();
        // 每种商品的最大囤货数量
        int[] item = new int[number];
        // 每种商品的在days天内的价格变动情况
        int[][] prices = new int[number][days];

        // 获取每种商品的最大囤货数量
        for (int i = 0; i < number; i++) {
            item[i] = scanner.nextInt();
        }

        // 获取每种商品在每天的价格变化情况
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < days; j++) {
                prices[i][j] = scanner.nextInt();
            }
        }

        // 计算最大利润
        int ans = getResult(number, days, item, prices);
        System.out.println(ans);
    }

    /**
     * @param number: 几种商品
     * @param days: 几天
     * @param item: 每种商品的最大囤货数量
     * @param prices: 每种商品的在days天内的价格变动情况
     * @return: 最大利润
     */
    private static int getResult(int number, int days, int[] item, int[][] prices) {
        int ans = 0;

        // 遍历每种商品
        for (int i = 0; i < number; i++) {
            // 获取当前商品的价格变化情况
            int[] price = prices[i];

            // 遍历商品的每天价格
            for (int j = 0; j < days - 1; j++) {
                // 如果今天价格小于明天价格，即可盈利
                if (price[j] < price[j + 1]) {
                    // 加入盈利金额
                    ans += (price[j + 1] - price[j]) * item[i];
                }
            }
        }

        return ans;
    }

}
