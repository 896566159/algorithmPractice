package nowcoder.outd.Y22Q3;

import java.util.Scanner;

/**
 * 一天一只顽猴想去从山脚爬到山顶，途中经过一个有个 N 个台阶的阶梯，但是这猴子有一个习惯：
 * 每一次只能跳1步或跳3步，试问猴子通过这个阶梯有多少种不同的跳跃方式？
 *
 * 输入描述:
 * 	输入只有一个整数N（0<N<=50）此阶梯有多少个台阶。
 * 输出描述:
 * 	输出有多少种跳跃方式（解决方案数）。
 *
 * 示例1:
 * 	输入:
 * 		50
 * 	输出:
 * 		122106097
 *
 * 示例2:
 * 	输入:
 * 		3
 * 	输出:
 * 		2
 */
public class _猴子爬山_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n < 3) {
            System.out.println(1);
            return;
        }

        int firt = 1;
        int second = 1;
        int third = 2;
        int sum = third;

        for (int i = 4; i <= n; i++) {
            sum = third + firt;
            firt = second;
            second = third;
            third = sum;
        }

        System.out.println(sum);
    }
}
