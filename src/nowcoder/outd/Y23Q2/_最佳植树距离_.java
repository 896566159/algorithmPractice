package nowcoder.outd.Y23Q2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 小明在直线的公路上种树，现在给定可以种树的坑位的数量和位置，以及需要种多少棵树苗，问树苗之间的最小间距是多少时，可以保证种的最均匀（两棵树苗之间的最小间距最大）
 * 输入描述：
 * 	输入三行：
 * 		第一行一个整数：坑位的数量
 * 		第二行以空格分隔的数组：坑位的位置
 * 		第三行一个整数：需要种植树苗的数量
 * 输出描述：
 * 	树苗之间的最小间距
 *
 * 示例1：
 * 	输入：
 * 		7
 * 		1 3 6 7 8 11 13
 * 		3
 * 	输出：
 * 		6
 * 说明：三颗树苗分别种在1、7、13的位置，可以保证种的最均匀，树苗之间的最小间距为6。
 */
public class _最佳植树距离_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] nums = new int[n];
        String[] split = scanner.nextLine().split(" ");
        int k = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        // 排序
        Arrays.sort(nums);

        // 两棵树苗之间的最小间距最大，一定在 [1, (max - min) / k]
        int left = 1;
        int right = (nums[n - 1] - nums[0]) / (k - 1) + 1;

        // 开区间
        while (left + 1 < right) {
            // 循环不变量
            int mid = (right - left) / 2 + left;
            if (f(nums, mid) >= k) {
                // 一下轮二分范围：(mid, right)
                left = mid;
            } else {
                // 一下轮二分范围：(left, mid)
                right = mid;
            }
        }

        System.out.println(left);
    }

    private static int f(int[] nums, int d) {
        int cut = 1;
        int pre = nums[0];

        for (int num : nums) {
            if (num >= pre + d) {
                cut++;
                pre = num;
            }
        }

        return cut;
    }

}
