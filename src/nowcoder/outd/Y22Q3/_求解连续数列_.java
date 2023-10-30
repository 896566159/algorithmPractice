package nowcoder.outd.Y22Q3;

import java.util.Scanner;

/**
 * 已知连续正整数数列{K}=K1,K2,K3…Ki的各个数相加之和为S，i=N (0<S<100000, 0<N<100000), 求此数列K。
 *
 * 输入描述：
 * 	输入包含两个参数，
 * 	1）连续正整数数列和S，
 * 	2）数列里数的个数N。
 * 输出描述：
 * 	如果有解输出数列K，如果无解输出-1。
 *
 * 示例1：
 * 	输入：
 * 		525 6
 * 	输出：
 * 		85 86 87 88 89 90
 *
 * 示例2：
 * 	输入：
 * 		3 5
 * 	输出：
 * 		-1
 *
 * 示例2：
 * 	输入：
 * 		20 4
 * 	输出：
 * 		-1
 */
public class _求解连续数列_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        int n = scanner.nextInt();

        int left = 0;
        int right = 0;
        int mid = sum / n;
        if (n % 2 == 0) {
            // 如果 n 是偶数，则 mid 是靠近左边的那个中间数
            left = mid - (n/ 2) + 1;
            right = mid + (n / 2);
        } else {
            left = mid - (n / 2);
            right = mid + (n / 2);
        }

        // 非正整数
        if (left <= 0) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(left);
            int target = left;
            for (int i = left + 1; i <= right; i++) {
                sb.append("," + i);
                target += i;
            }

            // 还要在检查一遍数列和是否正确。比如：20 4——>{4,5,6,7}，数列不正确
            if (target == sum) {
                System.out.print(sb.toString());
            } else {
                System.out.print(-1);
            }
        }
    }
}
