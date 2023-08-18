package nowcoder.outd.Y22Q3;

import java.util.Scanner;

/**
 * 给定一个含有N个正整数的数组，求出有多少个连续区间（包括单个正整数），它们的和大于等于x。
 *
 * 输入描述：
 * 	第一行两个整数N x（0 < N <= 100000, 0 <= x <= 10000000)
 * 	第二行有N个正整数（每个正整数小于等于100)。
 * 输出描述：
 * 	输出一个整数，表示所求的个数。
 *
 * 示例1：
 * 输入：
 * 	3 7
 * 	3 4 7
 * 输出：
 * 	4
 *
 * 示例2：
 * 	输入：
 * 		10 10000000
 * 		1 2 3 4 5 6 7 8 9 10
 * 	输出：
 * 		0
 */
public class _数组连续和_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int x = Integer.parseInt(split[1]);
        int[] arr = new int[n];
        // preSum[i] 表示从 [0, i-1] 的累加和
        int[] preSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            preSum[i + 1] = preSum[i] + arr[i];
        }

        int right = 1;
        int count = 0;

        while (right <= n) {
            int left = 0;
            while (left < right && preSum[right] - preSum[left] >= x) {
                left++;
                count++;
            }

            right++;
        }

        System.out.println(count);
        // 暴力
        System.out.println("暴力循环结果");
        method(arr, n, x);
    }

    private static void method(int[] arr, int n, int x) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            // 求从 [i, n - 1] 所有的和
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum >= x) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
