package nowcoder.outd.Y22Q4;

import java.util.Scanner;

/**
 * 近些年来，我国防沙治沙取得显著成果。某沙漠新种植 N 棵胡杨(编号1-N)，排成一排。一个月后，有 M 棵胡杨未能成活。
 * 现可补种胡杨 K 棵，请问如何补种 (只能补种，不能新种)，可以得到最多的连续胡杨树?
 * 输入描述:
 *  N 总种植数量
 *  M 未成活胡杨数量
 *  M 个空格分隔的数，按编号从小到大排列，表示该位置的树未成活
 *  K 最多可以补种的数量
 * 其中:
 *  1 <= N <= 100000
 *  1 <= M <= N
 *  0 <= K <= M
 * 输出描述：
 *  补种之后，最多的连续胡杨棵树
 *
 * 示例1:
 * 输入:
 *  5
 *  2
 *  2 4
 * 输出:
 *  3
 * 说明: 补种到 2 或 4 结果一样，最多的连续胡杨棵树都是 3
 *
 * 示例2:
 * 输入：
 *  10
 *  3
 *  2 4 7
 *  1
 * 输出：
 *  6
 * 说明：补种第 7 棵树，最多的连续胡杨棵树为 6 (5,6,7,8.9,10)
 */
public class _补种未成活胡杨_ {

    static int res;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = scanner.nextInt() - 1;
        }
        int k = scanner.nextInt();

        if (k >= m) {
            System.out.println(n);
            return;
        }

        boolean[] used = new boolean[n];
        dfs(n, arr, used, k, 0);
        System.out.println(res);
    }

    private static void dfs(int n, int[] arr, boolean[] used, int k, int count) {
        // 可以补种的树全部已经补种结束
        if (count == k) {
            int pre = 0;
            for (int i : arr) {
                // 没有补种，则断掉了
                if (!used[i]) {
                    res = Math.max(res, i - pre);
                    pre = i;
                }
            }

            // 最后一段连续的长度
            if (pre != n) {
                res = Math.max(res, n - pre);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (!used[arr[i]]) {
                used[arr[i]] = true;
                dfs(n, arr, used, k, count + 1);
                used[arr[i]] = false;
            }
        }
    }

}
