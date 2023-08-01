package nowcoder.outd.Y23Q2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 跳房子，也叫跳飞机，是一种世界性的儿童游戏游戏。
 * 参与者需要分多个回合、按顺序跳，从第1格直到房子的最后一格，然后获得一次选房子的机会，直到所有房子被选完，房子最多的人获胜。
 * 跳房子的过程中，如果有踩线等违规行为会结束当前回合，甚至可能倒退几步，
 * 假设房子的总格数是count，小红每回合可能连续跳的步数都放在数组steps中，请问数组中是否有一种步数的组合，可以让小红三个回合跳到最后一格? 如果有，请输出索引和最小的步数组合(数据保证索引和最小的步数组合是唯一的)。
 * 注意:数组中的步数可以重复，但数组中的元素不能重复使用
 *
 * 输入描述:
 * 	第一行输入为房子总格数count，它是int整数类型
 * 	第二行输入为每回合可能连续跳的步数，它是int整数数组类型
 * 输出描述:
 * 	返回索引和最小的满足要求的步数组合 (顺序保持steps中原有顺序)
 * 补充说明:
 * 	count<=10000，3<=steps.length<=10000，-100000<=steps[i]<=100000
 *
 * 示例1:
 * 	输入:
 * 		9
 * 		[1,4,5,2,0,2]
 * 	输出:
 * 		[4,5,0]
 *
 * 示例2:
 * 	输入:
 * 		9
 * 		[1,5,2,0,2,4]
 * 	输出:
 * 		[5,2,2]
 *
 * 示例3:
 * 	输入:
 * 		12
 * 		[-1,2,4,9]
 * 	输出:
 * 		[-1,4,9]
 *
 * 示例4：
 * 	输入：
 * 		15
 * 		[1,9,4,25,10,8,7,5]
 * 	输出：
 * 		[1, 4, 10]
 * 说明：
 * 	符合条件的步数集合有
 * 	[1, 9, 5]
 * 	它的下角标之和为：0 + 1 + 7 = 8
 * 	[1, 4, 10]
 * 	它的下角标之和为：0 + 2 + 4 = 6
 * 	因为 6<8，故输出[1, 4, 10]。
 */
public class _跳房子2_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        String[] split = scanner.nextLine().replace("[", "").replace("]", "").split(",");
        int n = split.length;
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(nums);
        int min = n * 3;
        int[] res = new int[3];
        for (int i = 0; i < n; i++) {
            if (i > 1 && nums[i - 1] == nums[i]) {
                continue;
            }

            int target = count - nums[i];
            int tmp = -1;

            int left = 0;
            int right = n - 1;
            while (left < right) {
                int mid = nums[left] + nums[right];
                if (mid == target) {
                    tmp = i + left + right;
                    break;
                } else if (mid > target) {
                    right--;
                } else {
                    left++;
                }
            }

            if (tmp != -1 && min > tmp) {
                min = tmp;
                res[0] = i;
                res[1] = left;
                res[2] = right;
            }
        }

        System.out.println(res[0] + " " + res[1] + " " + res[2]);
    }

}
