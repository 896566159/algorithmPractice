package nowcoder.outd.Y23Q2;

import java.util.Arrays;
import java.util.Scanner;


/**
 * 小牛的孩子生日快要到了，他打算给孩子买蛋糕和小礼物，蛋糕和小礼物各买一个，他的预算不超过x元。蛋糕cake和小礼物gift都有多种价位的可供选择。
 * 请返回小牛共有多少种购买方案
 *
 * 输入描述:
 * 	第一行表示cake的单价，以逗号分隔
 * 	第二行表示gift的单价，以逗号分隔
 * 	第三行表示x预算
 * 输出描述:
 * 	输出数字表示购买方案的总数
 * 备注:
 * 	1 < cake.length ≤ 10^5
 * 	1 < gift.length <10^5。
 * 	1 < cake[i]，gift[i] < 10^5。
 * 	1 < X < 2*10^5
 *
 * 示例1：
 * 	输入：
 * 		10,20,5
 * 		5,5,2
 * 		15
 * 	输出：
 * 		6
 * 解释:
 * 	小牛有6种购买方案，所选蛋糕与所选礼物在数组中对应的下标分别是:
 * 	第1种方案: cake[0] + gift[0] = 10 + 5 = 15
 * 	第2种方案: cake[0] + gift[1] = 10 + 5 = 15
 * 	第3种方案: cake[0] + gift[2] = 10 + 2 = 12
 * 	第4种方案: cake[2] + gift[0] = 5 + 5  = 10
 * 	第5种方案: cake[2] + gift[1] = 5 + 5  = 10
 * 	第6种方案: cake[2] + gift[2] = 5 + 2  = 7
 */
public class _生日礼物_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line1 = scanner.nextLine().split(",");
        String[] line2 = scanner.nextLine().split(",");
        int[] cakes = new int[line1.length];
        int[] gifts = new int[line2.length];

        for (int i = 0; i < line1.length; i++) {
            cakes[i] = Integer.parseInt(line1[i]);
        }

        for (int i = 0; i < line2.length; i++) {
            gifts[i] = Integer.parseInt(line2[i]);
        }

        int plan = Integer.parseInt(scanner.nextLine());
        Arrays.sort(cakes);
        Arrays.sort(gifts);

        int count = 0;
        for (int i = 0; i < gifts.length; i++) {
            int gift = gifts[i];
            int left = 0;
            int right = cakes.length;

            while (right > left) {
                int mid = (right - left) / 2 + left;
                if (cakes[mid] + gift > plan) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            count += left;
        }

        System.out.println(count);
    }

}
