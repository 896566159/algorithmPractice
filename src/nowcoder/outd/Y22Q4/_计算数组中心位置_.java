package nowcoder.outd.Y22Q4;

import java.util.Scanner;

/**
 * 给你一个整数数组 nums，请计算数组的中心位置，数组的中心位置是数组的一个下标，
 * 其左侧所有元素相乘的积等于右侧所有元素相乘的积。数组第一个元素的左侧积为1，最后一个元素的右侧积为1。
 * 如果数组有多个中心位置，应该返回最靠近左边的那一个，如果数组不存在中心位置，返回-1。
 *
 * 输入描述：
 * 	输入只有一行，给出N个正整数用空格分隔：nums = 2 5 3 6 5 6
 * 	1 <= nums.length <= 1024
 * 	1 <= nums[i] <= 10
 * 输出描述：
 * 	中心位置
 *
 * 示例1：
 * 	输入：
 * 		2 5 3 6 5 6
 * 	输出：
 * 		3
 * 解释：中心位置是3
 */
public class _计算数组中心位置_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int n = split.length;
        int[] nums = new int[n];

        long mul = 1;
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(split[i]);
            mul *= nums[i];
        }

        long cur = 1;
        for (int i = 0; i < n; i++) {
            if (cur == (mul / nums[i] / cur)) {
                System.out.println(i);
                return;
            }
            cur *= nums[i];
        }
    }

}
