package nowcoder.outd.Y22Q4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 双十一众多商品进行打折销售，小明想购买自己心仪的一些物品，但由于受购买资金限制，所以他决定从众多心仪商品中购买三件，而且想尽可能的花完资金。
 * 现在请你设计一个程序帮助小明计算尽可能花费的最大资金数额。
 * 输入描述:
 * 	输入第一行为一维整型数组 M，数组长度小于100，数组元素记录单个商品的价格，单个商品价格小于1000。
 * 	输入第二行为购买资金的额度 R，R小于100000。
 * 输出描述:
 * 	输出为满足上述条件的最大花费额度。
 * 注意：如果不存在满足上述条件的商品，请返回-1。
 * 备注: 输入格式是正确的，无需考虑格式错误的情况。
 *
 * 示例1:
 * 	输入:
 * 		23,26,36,27
 * 		78
 * 	输出:
 * 		76
 * 说明:
 * 	金额23、26和27相加得到76，而且最接近且小于输入金额78。
 *
 * 示例2:
 * 	输入:
 * 		23,30,40
 * 		26
 * 	输出:
 * 		-1
 * 说明:
 * 	因为输入的商品，无法组合出来满足三件之和小于 26.故返回-1。
 */
public class _最大花费金额_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        // 输入所有商品的价格
        String[] products = line.split(",");
        int n = products.length;
        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(products[i]);
        }

        // 输入手上的金钱
        int money = Integer.parseInt(scanner.nextLine());
        // 排序
        Arrays.sort(price);

        // 如果商品不足 3件 或者 最小的3件物品金额大于 money
        if (price.length < 3 || (price[0] + price[1] + price[2] > money)) {
            System.out.println(-1);
            return;
        }

        // 初始化
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - 1;
            // 找小于等于 且最接近 target 的组合
            int target = money - price[i];

            while (left < right) {
                int mid = (left + right) / 2;
                int sum = price[left] + price[right];

                if (sum > target) {
                    right = mid;
                } else if (sum < target) {
                    ans = Math.min(ans, money - (price[left] + price[right] + price[i]));
                    left = mid + 1;
                } else {
                    // 找到了刚好能够凑满金额的组合
                    System.out.println(money);
                    return;
                }
            }
        }

        // 输出
        System.out.println(ans == Integer.MAX_VALUE ? -1 : money - ans);
    }

}
