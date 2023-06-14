package nowcoder.outd.Y22Q4;

import java.util.*;

/**
 * 篮球(5V5)比赛中，每个球员拥有一个战斗力，每个队伍的所有球员战斗力之和为该队伍的总体战斗力。
 * 现有10个球员准备分为两队进行训练赛，教练希望 2 个队伍的战斗力差值能够尽可能的小，以达到最佳训练效果。
 * 给出10个球员的战斗力，如果你是教练，你该如何分队，才能达到最佳训练效果? 请说出该分队方案下的最小战斗力差值。
 * 输入描述:
 * 10个篮球队员的战斗力(整数，范围[1,10000]),战斗力之间用空格分隔，如:10 9 8 7 6 5 4 3 2 1
 * 不需要考虑异常输入的场景。
 * 输出描述:
 * 最小的战斗力差值，如:1
 *
 * 示例1：
 * 	输入：
 * 		10 9 8 7 6 5 4 3 2 1
 * 	输出：
 * 		1
 * 说明：
 * 	1 2 5 9 10分为一队，3 4 6 7 8分为一队，两队战斗力之差最小，输出差值1。
 * 备注：球员分队方案不唯一，但最小战斗力差值固定是1。
 */
public class _篮球比赛_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int m = split.length;
        int arr[] = new int[m];
        int min = Integer.MAX_VALUE;

        // 初始化数组
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }

        int n = m / 2;
        List<Integer>[] sums = new List[n + 1];

        // 枚举前半段中的 n 个数，取 cnt 个正号， n - cnt 个负号
        for (int i = 0; i < (1 << n); i++) {
            int cnt = Integer.bitCount(i);
            int sum = 0;

            // 枚举，n 个数中，取 cnt 个正号， n - cnt 个负号
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    // 取正号
                    sum += arr[j];
                } else {
                    // 去负号
                    sum -= arr[j];
                }
            }

            if (sums[cnt] == null) {
                sums[cnt] = new ArrayList<>();
            }
            sums[cnt].add(sum);
        }

        // 对前半段的枚举结果做排序，以便于后面二分查找
        for (int i = 0; i <= n; i++) {
            Collections.sort(sums[i]);
        }

        // 枚举后半段中的 n 个数，取 cnt 个正号， n - cnt 个负号
        for (int i = 0; i < (1 << n); i++) {
            int cnt = Integer.bitCount(i);
            int sum = 0;

            // 枚举，n 个数中，取 cnt 个正号， n - cnt 个负号
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    // 取正号
                    sum += arr[j + n];
                } else {
                    // 去负号
                    sum -= arr[j + n];
                }
            }

            // ----查找在前半段中的枚举结果，找出前半段中同样是 cnt 个正号、n - cnt 个负号得到的所有结果，看哪个结果和当前结果最接近----
            List<Integer> preSum = sums[cnt];
            int l = 0;
            int r = preSum.size() - 1;
            while (l < r) {
                int mid = (r - l) / 2 + l;
                if (preSum.get(mid) >= sum) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            // 前后两部分的和 作差
            min = Math.min(min, Math.abs(preSum.get(l) - sum));
            if (l > 0) {
                min = Math.min(min, sum - preSum.get(l - 1));
            }

            // 如果差值已经是 0 了，最小了。直接返回答案
            if (min == 0) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(min);
    }

}
