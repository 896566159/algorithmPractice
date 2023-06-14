package ltcd.binarySearchExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 将两个数组之差视作从 nums 中选取 n 个正号，其余 n 个数取负号，然后元素求和
 * 折半枚举：
 *  枚举 nums 的前 n 个元素取正号或取负号的所有情况，按取正的个数分组，并按照元素和排序。
 *  然后枚举 nums 的后 n 个元素取正或者其余负的所有情况，然后对应的组里二分找元素和最近的数，答案记为所有情况中最小的差值
 *
 *
 * Integer.bitCount(int num) 方法用于统计二进制中 1 的个数
 * 1 对于一个长度为2 * n的数组，分成两个长度为 n 的子数组做差，也就是取 n 个为正号，取 n 个为负号，进行作差
 * 2 那么，就可以枚举前 n 部分，取前 n 个中 cnt 个为正号，n - cnt 为负号，即可以通过二进制枚举法，枚举出每个 cnt 个的情况
 * 3 有了前半部分，那么后半部分同样通过枚举，因为前 n 个有 cnt 为正号，也就意味着后 n 个同样要有 cnt 个为正号，这样做差后，正好形成：
 * （前n个中有cnt取正号 + 前n个中有n-cnt取负号）- （后n个中有cnt取正号 + 后n个中有n-cnt取负号）
 * 4 那么最终也就是取：前半部分和后半部分最相近的值，这里可以通过二分查找在前半部分排序中找到和后半部分最想近的值，二分查找进行加速
 */
public class _2035_将数组分成两个数组并最小化数组和的差_ {

    public static void main(String[] args) {
        _2035_将数组分成两个数组并最小化数组和的差_ v = new _2035_将数组分成两个数组并最小化数组和的差_();
        System.out.println(v.minimumDifference(new int[]{2, -1, 0, 4, -2, -9}));
    }

    public int minimumDifference(int[] nums) {
        int m = nums.length;
        int n = m / 2;
        List<Integer>[] sums = new List[n + 1];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 1 << n; i++) {
            // cnt 为取的正号的数量
            int cnt = Integer.bitCount(i);
            int sum = 0;

            // 枚举半部分
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    sum += nums[j];
                } else {
                    sum -= nums[j];
                }
            }

            // 判空
            if (sums[cnt] == null) {
                sums[cnt] = new ArrayList<>();
            }
            // 当前 n 个中取 cnt 个正号、n - cnt 个负号时，sum 的结果
            sums[cnt].add(sum);
        }

        // 排序前面的每一种枚举结果
        for (int i = 0; i <= n; i++) {
            Collections.sort(sums[i]);
        }

        // 枚举后半段的情况，假设后面有 3 个正号，实际上也对应前面有 3 个正号，这样作差，正好抵消
        for (int i = 0; i < 1 << n; i++) {
            // cnt 为取的正号的数量
            int cnt = Integer.bitCount(i);
            int sum = 0;

            // 枚举后半部分
            for (int j = n; j < m; j++) {
                int t = j - n;
                if (((i >> t) & 1) == 1) {
                    sum += nums[j];
                } else {
                    sum -= nums[j];
                }
            }

            // 二分搜索，在前面相同正号数量的位置，找相近的数，找比 sum 大的位置
            List<Integer> list = sums[cnt];
            int l = 0;
            int r = list.size() - 1;
            while (l < r) {
                int mid = (r - l) / 2 + l;
                if (list.get(mid) >= sum) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            // 检查右边，可能右边也比当前 sum 小
            min = Math.min(min, Math.abs(list.get(l) - sum));
            // 检查左边
            if (l > 0) {
                min = Math.min(min, sum - list.get(l - 1));
            }

            // 如果差值已经是 0 了，最小了。直接返回答案
            if (min == 0) {
                return 0;
            }
        }

        return min;
    }

}
