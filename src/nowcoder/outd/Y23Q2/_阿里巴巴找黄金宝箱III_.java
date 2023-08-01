package nowcoder.outd.Y23Q2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 贫如洗的樵夫阿里巴巴在去砍柴的路上，无意中发现了强盗集团的藏宝地，藏宝地有编号从0~N的箱子，每个箱子上面贴有一个数字。
 * 阿里巴巴念出一个咒语数字，查看宝箱是否存在两个不同箱子，这两个箱子上贴的数字相同，同时这两个箱子的编号之差的绝对值小于等于咒语数字，
 * 如果存在这样的一对宝箱，请返回最先找到的那对宝箱左边箱子的编号，如果不存在则返回-1。
 *
 * 输入描述:
 * 	第一行输入一个数字字串，数字之间使用逗号分隔，例如: 1,2,3,1字串中数字个数>=1，<=100000; 每个数字值>=-100000，<=100000:
 * 	第二行输入咒语数字，例如: 3，咒语数字>=1，<=100000
 * 输出描述:
 * 	存在这样的一对宝箱，请返回最先找到的那对宝箱左边箱子的编号，如果不存在则返回-1
 *
 * 示例1:
 * 	输入:
 * 		6,3,1,6
 * 		3
 * 	输出:
 * 		0
 *
 * 示例2：
 * 	输入:
 * 		5,6,7,5,6,7
 * 		2
 * 	输出:
 * 		-1
 */
public class _阿里巴巴找黄金宝箱III_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");
        int target = Integer.parseInt(scanner.nextLine());
        int n = split.length;
        int[] nums = new int[100000];

        Arrays.fill(nums, -1);

        for (int i = 0; i < n; i++) {
            int parseInt = Integer.parseInt(split[i]);
            if (nums[parseInt] != -1) {
                if (i - nums[parseInt] <= target) {
                    System.out.println(nums[parseInt]);
                    return;
                }
            }
            nums[parseInt] = i;
        }

        System.out.println(-1);
    }

}
