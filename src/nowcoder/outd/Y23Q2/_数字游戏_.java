package nowcoder.outd.Y23Q2;

import java.util.Scanner;

/**
 * 小明玩一个游戏。系统发1+n张牌，每张牌上有一个整数。第一张给小明，后n张按照发牌顺序排成连续的一行。
 * 需要小明判断，后n张牌中，是否存在连续的若干张牌，其和可以整除小明手中牌上的数字.
 *
 * 输入描述:
 * 	输入数据有多组，每组输入数据有两行，输入到文件结尾结束
 * 	第一行有两个整数n和m，空格隔开。m代表发给小明牌上的数字
 * 	第二行有n个数，代表后续发的n张牌上的数字，以空格隔开。
 * 输出描述:
 * 	对每组输入，如果存在满足条件的连续若干张牌，则输出1:否则，输出0
 * 补充说明:
 * 	1 <= n <= 1000
 * 	1 <= 牌上的整数 <= 400000
 * 	输入的组数，不多于1000
 * 	用例确保输入都正确，不需要考虑非法情况
 *
 * 示例1:
 * 	输入:
 * 		6 7
 * 		2 12 6 3 5 5
 * 		10 11
 * 		1 1 1 1 1 1 1 1 1 1
 * 	输出:
 * 		1
 * 		0
 * 说明:
 * 	两组输入。
 * 	第一组小明牌的数字为7，再发了6张牌。第1、2两张牌数字和为14，可以整除7，输出1。
 * 	第二组小明牌的数字为11，再发了10张牌，这10张牌数字和为10，无法整除11，输出0。
 */
public class _数字游戏_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String first = scanner.nextLine();
            if (first.equals("")) {
                break;
            }
            String[] second = scanner.nextLine().split(" ");
            String[] split = first.split(" ");
            int n = Integer.parseInt(split[0]);
            int m = Integer.parseInt(split[1]);
            int[] nums = new int[n];
            int[] preSum = new int[n + 1];

            boolean flag = false;
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(second[i]) % m;
                preSum[i + 1] = (preSum[i] + nums[i]) % m;
                // 如果出现连续的
                if (i > 0 && preSum[i + 1] == 0) {
                    System.out.println(1);
                    flag = true;
                    break;
                }
            }

            if (flag) {
                continue;
            }
            // 至少需要两个数字才满足连续
            for (int i = 2; i < n - 1; i++) {

                for (int j = i + 1; j < n; j++) {
                    if ((preSum[j] - preSum[j - i]) % m == 0 ) {
                        System.out.println(1);
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }

            if (!flag) {
                System.out.println(0);
            }
        }
    }
}
