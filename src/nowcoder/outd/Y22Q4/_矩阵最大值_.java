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
            char[] chars = line.toCharArray();
            String doubleLine = line + line;
            int len = chars.length;

            // 统计出该行连续最长的 1 有多少个
            int start = 0;
            int index = -1;
            int maxLen = 0;
            while (start < len) {
                // 找到 1
                while (start < len && chars[start] == '0') {
                    start++;
                }

                // 若这一行中有 1，需要计算到 sum 中
                if (start < len) {
                    // 标记下这段连续 1 的起始位置
                    int left = start;
                    int tmp = len;
                    // 统计有多少个连续的 1
                    while (tmp > 0 && chars[start % len] == '1') {
                        tmp--;
                        start++;
                    }

                    if (maxLen < start - left) {
                        maxLen = start - left;
                        index = left;
                    } else if (maxLen != 0 && maxLen == start - left) {
                        // 存在多段长度相等的连续 1，那么比较连续 1 后面这一段的字典序谁更大
                        int p1 = index + maxLen;
                        int p2 = start;
                        while (chars[p1 % len] == chars[p2 % len]) {
                            p1++;
                            p2++;
                        }

                        // 说明 p1、p2 指向的字符不一样：一个是 0，一个是 1
                        if (chars[p2 % len] == '1') {
                            index = left;
                        }
                    }
                }
            }

            // 若 index 还是等于 -1，说明该行中没有 1，怎么旋转都是 0，直接跳过不统计
            if (index != -1) {
                String substring = doubleLine.substring(index, index + len);
                sum += Integer.parseInt(substring, 2);
                System.out.println(substring);
            }
        }
        System.out.println("__________________");
        System.out.println(sum);

//        sum = 0;
//        for (int i = 0; i < n; i++) {
//
//            String line = scanner.nextLine().replace(",", "");
//            int value = Integer.parseInt(line, 2);
//            int length = line.length();
//            // 暴力旋转字符串，计算最大值
//            for (int j = 1; j < length; j++) {
//                String reverse = line.substring(j, length) + line.substring(0, j);
//                value = Math.max(Integer.parseInt(reverse, 2), value);
//            }
//            sum += value;
//        }
//
//        System.out.println(sum);
    }

}
