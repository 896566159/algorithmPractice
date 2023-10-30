package nowcoder.outd.Y22Q4;

import java.lang.reflect.Array;
import java.util.Arrays;
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
 *  1
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


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // 初始化，有 n 棵树
        int[] tree = new int[n];
        // 数成活的话，标记为 0
        Arrays.fill(tree, 0);
        // 标记哪些树未成活
        for (int i = 0; i < m; i++) {
            int index = scanner.nextInt() - 1;
            // 树未成活，标记为 1
            tree[index] = 1;
        }
        int k = scanner.nextInt();

        // 如果未成活树全部都补种
        if (k >= m) {
            System.out.println(n);
            return;
        }

        // 左右指针，窗口中未成活数量等于补种数量 k
        int left = 0;
        int right = 0;
        int windows = 0;
        int max = 0;
        // 开始处理
        while (right < n) {
            while (right < n && windows <= k) {
                if (tree[right] == 1) {
                    windows++;
                }
                right++;
            }

            // [left， right - 2]这个区间内有 k + 1 颗未成活的树。故长度是：right - 2 - left + 1 = right - left - 1
            // 特殊情况是：right已经遍历到底了，[left， right = n + 1] 区间未成活的树 <= k 颗，直接 right - left
            int len = right == n && tree[right - 1] != 1 ? n - left : right - left - 1;
            max = Math.max(len, max);
            while (left < right && tree[left] == 0) {
                left++;
            }
            left++;
            windows--;
        }

        System.out.println(max);
    }

}
