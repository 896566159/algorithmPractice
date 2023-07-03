package nowcoder.outd.Y22Q4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 用数组代表每个人的能力，一个比赛活动要求参赛团队的最低能力值为 N，每个团队可以由 1人或2人 组成，
 * 且1个人只能参加1个团队， 请计算出最多可以派出多少支符合要求的团队？
 *
 * 输入描述:
 * 	第一行数组代表总人数，范围[1,500000]
 * 	第二行数组代表每个人的能力，每个元素的取值范围[1, 500000]，数组的大小范围[1,500000]
 * 	第三行数值为团队要求的最低能力值，范围[1, 500000]
 * 输出描述：
 * 	最多可以派出的团队数量
 *
 * 示例1：
 * 	输入:
 * 		5
 * 		3 1 5 7 9
 * 		8
 * 	输出：
 * 		3
 * 说明：3,5组成一队，1,7组成一队，9自己一个队，故输出3
 *
 * 示例 2：
 * 	输入：
 * 		7
 * 		3 1 5 7 9 2 6
 * 		8
 * 	输出：
 * 		4
 * 说明：1、7组成一队 3、5一队 2、6一队 9自己一队 输出4
 *
 * 示例 3：
 * 	输入：
 * 		3
 * 		1 1 9
 * 		8
 * 	输出：
 * 		1
 * 说明：1、9组成一队 或者9自己一队 输出1
 */
public class _最多团队_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] scores = scanner.nextLine().split(" ");
        int target = Integer.parseInt(scanner.nextLine());
        int maxTeams = 0;
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(scores[i]);
        }

        // 排序
        Arrays.sort(nums);
        if (nums[0] >= target) {
            // 每个人的都可以作为一队
            System.out.println(n);
            return;
        }

        int right = nums.length - 1;
        // 一个人就是一队伍
        while (right >= 0 && nums[right] >= target) {
            maxTeams++;
            right--;
        }

        // 两个人组队
        int left = 0;
        while (left < right) {
            // 战力高的尽量带一个战力最低的，这样可以多组一些队伍出来
            if (nums[right] + nums[left] >= target) {
                maxTeams++;
                right--;
            }
            left++;
        }

        System.out.println(maxTeams);
    }

}
