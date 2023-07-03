package nowcoder.outd.Y22Q4;

import java.util.Scanner;

/**
 * 给定一个仅包含 0和1 的 N*N 二维矩阵，请计算二维矩阵的最大值，计算规则如下：
 * 	1、每行元素按下标顺序组成一个二进制数（下标越大越排在低位），二进制数的值就是该行的值。矩阵各行值之和为矩阵的值。
 * 	2、允许通过向左或向右整体循环移动每行元素来改变各元素在行中的位置。
 *
 * 比如：
 * 	[1,0,1,1,1]向右整体循环移动 2 位变为[1,1,1,0,1]，二进制数为11101，值为29。
 * 	[1,0,1,1,1]向左整体循环移动 2 位变为[1,1,1,1,0]，二进制数为11110，值为30。
 *
 * 输入描述:
 * 	1、输入的第一行为正整数，记录了N的大小，0 < N <= 20。
 * 	2、输入的第2到N+1行为二维矩阵信息，行内元素边角逗号分隔。
 *
 * 输出描述:
 * 	矩阵的最大值。
 *
 * 示例1:
 * 	输入:
 * 		5
 * 		1,0,0,0,1
 * 		0,0,0,1,1
 * 		0,1,0,1,0
 * 		1,0,0,1,1
 * 		1,0,1,0,1
 * 	输出:
 * 		122
 *
 * 说明:
 * 	第一行向右整体循环移动1位，得到本行的最大值[1,1,0,0,0]，二进制值为11000，十进制值为24。
 * 	第二行向右整体循环移动2位，得到本行的最大值[1,1,0,0,0]，二进制值为11000，十进制值为24。
 * 	第三行向左整体循环移动1位，得到本行的最大值[1,0,1,0,0]，二进制值为10100，十进制值为20。
 * 	第四行向右整体循环移动2位，得到本行的最大值[1,1,1,0,0]，二进制值为11100，十进制值为28。
 * 	第五行向右整体循环移动1位，得到本行的最大值[1,1,0,1,0]，二进制值为11010，十进制值为26。
 * 	因此，矩阵的最大值为122。
 */
public class _矩阵最大值_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = 0; i < n; i++) {

            String line = scanner.nextLine().replace(",", "");
            int value = Integer.parseInt(line, 2);
            int length = line.length();
            // 暴力旋转字符串，计算最大值
            for (int j = 1; j < length; j++) {
                String reverse = line.substring(j, length) + line.substring(0, j);
                value = Math.max(Integer.parseInt(reverse, 2), value);
            }
            sum += value;
        }

        System.out.println(sum);
    }

}
