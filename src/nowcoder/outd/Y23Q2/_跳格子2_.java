package nowcoder.outd.Y23Q2;

import java.util.Scanner;

/**
 * 小明和朋友玩跳格子游戏，有 n 个连续格子组成的圆圈，每个格子有不同的分数，小朋友可以选择从任意格子起跳，但是不能跳连续的格子，不能回头跳，也不能超过一圈:
 * 给定一个代表每个格子得分的非负整数数组，计算能够得到的最高分数
 * 输入描述：
 * 	给定一个数例，第一个格子和最后一个格子收尾相连，如: 2 3 2
 * 输出描述：
 * 	输出能够得到的最高分，如: 3
 * 说明：
 * 	1 <= nums.length <= 100
 * 	0 <= nums[i] <= 1000
 *
 * 示例1：
 * 	输入：
 * 		2 3 2
 * 	输出：
 * 		3
 * 说明：只能跳 3 这个格子，因为第一个格子和第三个格子收尾相连
 *
 * 示例2：
 * 	输入：
 * 		1 2 3 1
 * 	输出：
 * 		4
 * 说明：1+3=4
 */
public class _跳格子2_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int n = split.length;
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        int choice1 = rob(nums, 0, n - 2);
        int choice2 = rob(nums, 1, n - 1);

        System.out.println(Math.max(choice1, choice2));
    }

    private static int rob(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }

        int n = nums.length;
        int[] dp = new int[n];

        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            dp[i + 1] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[end];
    }

}
