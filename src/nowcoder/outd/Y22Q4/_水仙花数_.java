package nowcoder.outd.Y22Q4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 所谓水仙花数，是指一个 n 位的正整数，其各位数字的 n 次方和等于该数本身。
 * 例如 153 是水仙花数，153 是一个 3 位数，并且153 = 1^3 + 5^3 + 3^3。
 * 输入描述：
 * 	第一行输入一个整数 n，表示一个 n 位的正整数。n 在 3 到 7 之间，包含 3 和 7。
 * 	第二行输入一个正整数 m，表示需要返回第 m 个水仙花数。
 * 输出描述：
 * 	返回长度是 n 的第 m 个水仙花数。个数从 0 开始编号。
 * 	若 m 大于水仙花数的个数，返回最后一个水仙花数 和 m 的乘积。
 * 	若输入不合法，返回-1。
 *
 * 示例1：
 * 	输入：
 * 		3
 * 		0
 * 	输出：
 * 		153
 *
 * 说明：
 * 	153是第一个水仙花数
 *
 * 示例2：
 * 	输入：
 * 		9
 * 		1
 * 	输出：
 * 		-1
 * 说明：
 * 	9 超出范围
 */
public class _水仙花数_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        if (n < 3 || n > 7) {
            System.out.println(-1);
            return;
        }

        int m = Integer.parseInt(scanner.nextLine());
        List<Integer> list = new ArrayList<>();
        double max = Math.pow(10, n + 1);

        for (int i = 153; i < max; i++) {
            int digits = String.valueOf(i).length();
            int num = i;
            long sum = 0;

            while (num > 0) {
                sum += Math.pow((num % 10), digits);

                if (sum > i) {
                    break;
                }
                num /= 10;
            }

            if (sum == i) {
                list.add(i);
            }
        }

        if (m > list.size()) {
            System.out.println(list.get(list.size() - 1) * m);
        } else {
            System.out.println(list.get(m - 1));
        }
    }
}
