package nowcoder.outd.Y22Q3;

import java.util.Scanner;

/**
 * 请在一个字符串中找出 连续最长的数字串，并返回这个数字串。
 * 如果存在长度相同的连续数字串，返回最后一个。
 * 如果没有符合条件的字符串，返回空字符串””。
 *
 * 注意：
 * 	数字串可以由数字”0-9″、小数点”.”、正负号”±”组成，长度包括组成数字串的所有符号。
 * 	“.”、“±”仅能出现一次，”.”的两边必须是数字，”±”仅能出现在开头且其后必须要有数字。
 * 	长度不定，可能含有空格。
 *
 * 示例1：
 * 	输入：
 * 		1234567890abcd9.+12345.678.9ed
 * 	输出：
 * 		+12345.678
 * 示例2：
 * 	输入：
 * 		1.123.123
 * 	输出：
 * 		123.123
 */
public class _字符串中找到连续最长数字串_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        int n = chars.length;
        int maxLen = 0;
        int index = 0;
        String res = "";

        while (index < n) {
            char c = chars[index];

            if (c == '+' || c == '-') {
                char next = chars[index + 1];
                int count = 1;
                StringBuilder sb = new StringBuilder();

                if (next >= '0' && next <= '9') {
                    sb.append(c);
                    int i = index + 1;

                    while (i < n) {
                        c = chars[i];
                        // 小数点只能出现一次，且小数点后面必须是数字
                        if (c == '.' && (count-- < 1 || i + 1 >= n || !(chars[i + 1] >= '0' && chars[i + 1] <= '9'))) {
                            break;
                        }
                        if (c != '.' && !(c >= '0' && c <= '9')) {
                            break;
                        }
                        sb.append(c);
                        i++;
                    }

                    // 更新答案
                    if (maxLen <= sb.length()) {
                        maxLen = sb.length();
                        res = sb.toString();
                    }
                }
            } else if (c >= '0' && c <= '9') {
                int count = 1;
                StringBuilder sb = new StringBuilder();
                int i = index;

                while (i < n) {
                    c = chars[i];
                    // 小数点只能出现一次，且小数点后面必须是数字
                    if (c == '.' && (count-- < 1 || i + 1 >= n || !(chars[i + 1] >= '0' && chars[i + 1] <= '9'))) {
                        break;
                    }
                    if (c != '.' && !(c >= '0' && c <= '9')) {
                        break;
                    }
                    sb.append(c);
                    i++;
                }

                // 更新答案
                if (maxLen <= sb.length()) {
                    maxLen = sb.length();
                    res = sb.toString();
                }
            }
            index++;
        }

        System.out.println(res);
    }

}
