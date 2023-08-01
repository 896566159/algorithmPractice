package nowcoder.outd.Y23Q2;

import java.util.Scanner;

/**
 * 一贫如洗的樵夫阿里巴巴在去砍柴的路上，无意中发现了强盗集团的藏宝地，藏宝地有编号从0-N的箱子，每个箱子上面贴有一个数字.
 * 阿里巴巴念出一个咒语数字k(k<N)，找出连续k个宝箱数字和的最大值，并输出该最大值。
 * 输入描述：
 * 	第一行输入一个数字字串，数字之间使用逗号分隔，例如: 2,10,-3,-8,40,5。
 * 	1≤ 字串中数字的个数 ≤100000
 * 	-10000≤ 每个数字 ≤10000
 * 	第二行输入咒语数字，例如: 4，咒语数字大小小于宝箱的个数
 * 输出描述：
 * 	连续k个宝箱数字和的最大值，例如: 39
 *
 * 示例1：
 * 	输入：
 * 		2,10,-3,-8,40,5
 * 		4
 * 	输出：
 * 		39
 *
 * 示例2：
 * 	输入：
 * 		8
 * 		1
 * 	输出：
 * 		8
 */
public class _阿里巴巴找黄金宝箱V_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");
        int k = Integer.parseInt(scanner.nextLine());
        int max = 0;
        int sum = 0;
        int left = 0;
        int right = 0;
        int length = split.length;

        while (right < k && right < length) {
            sum += Integer.parseInt(split[right]);
            right++;
        }

        max = sum;
        while (right < length) {
            sum -= Integer.parseInt(split[left]);
            sum += Integer.parseInt(split[right]);
            max = Math.max(max, sum);
            left++;
            right++;
        }

        System.out.println(max);
    }

}
