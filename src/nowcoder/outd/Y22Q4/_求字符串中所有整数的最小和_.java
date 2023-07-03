package nowcoder.outd.Y22Q4;

import java.util.Scanner;

/**
 * 输入字符串 s，输出 s 中包含所有整数的最小和。
 * 说明：
 * 字符串s，只包含 a-z A-Z ± ；
 * 合法的整数包括：
 * 	1）正整数 一个或者多个 0-9 组成，如 0 2 3 002 102
 * 	2）负整数 负号 – 开头，数字部分由一个或者多个 0-9 组成，如 -0 -012 -23 -00023
 *
 * 输入描述：
 * 	包含数字的字符串
 * 输出描述
 * 	所有整数的最小和
 *
 * 示例1：
 * 	输入：
 * 		bb1234aa
 * 	输出：
 * 		10
 *
 * 示例2：
 * 输入：
 * 	bb12-34aa
 * 输出：
 * 	-31
 * 说明：
 * 	1+2+（-34） = -31
 */
public class _求字符串中所有整数的最小和_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char[] chars = line.toCharArray();
        int n = chars.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (chars[i] > '0' && chars[i] <= '9') {
                // 正数，取个位数
                sum += chars[i] - '0';
            } else if (chars[i] == '-') {
                // 负数，取连着的一串数
                int j = i + 1;
                while (j < n && chars[j] >= '0' && chars[j] <= '9') {
                    j++;
                }
                sum += Integer.parseInt(line.substring(i, j));
                // 此时 j 所指可能是符号，所以不能跳过
                i = j - 1;
            }
        }

        System.out.println(sum);
    }

}
