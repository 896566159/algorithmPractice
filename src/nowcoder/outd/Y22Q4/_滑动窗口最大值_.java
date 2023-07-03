package nowcoder.outd.Y22Q4;

import java.util.Scanner;

/**
 * 题目描述：
 * 有一个 N 个整数的数组，和一个长度为 M 的窗口，窗口从数组内的第一个数开始滑动直到窗口不能滑动为止，每次窗口滑动产生一个窗口和（窗口内所有数的和），求窗口滑动产生的所有窗口和的最大值。
 * 输入描述：
 * 	第一行输入一个正整数 N，表示整数个数。（0<N<100000）
 * 	第二行输入 N 个整数，整数的取值范围为[-100,100]。
 * 	第三行输入一个正整数 M，M代表窗口的大小，M<=100000，且M<=N。
 * 输出描述：
 * 	窗口滑动产生所有窗口和的最大值。
 * 示例：
 *
 * 输入：
 * 	6
 * 	12 10 20 30 15 23
 * 	3
 * 输出：
 * 	68
 */
public class _滑动窗口最大值_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] split = scanner.nextLine().split(" ");
        int m = Integer.parseInt(scanner.nextLine());
        int[] nums = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(split[i]);
            // 初始化第一个窗口
            if (i < m) {
                sum += nums[i];
            }
        }

        int max = sum;
        for (int i = m; i < n; i++) {
            sum -= nums[i - m];
            sum += nums[i];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }

}
