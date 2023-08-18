package nowcoder.outd.Y22Q3;

import java.util.Scanner;

/**
 * 对数字，字符，数字串，字符串，以及数字与字符串组合进行倒序排列。
 * 字符范围：
 * 	由 a 到 z， A 到 Z，数字范围：由 0 到 9
 * 	符号的定义
 * 	1、"-"作为连接符使用时作为字符串的一部分，例如“20-years”作为一个整体字符串呈现;
 * 	2、连续出现 2 个"-"及以上时,视为字符串间隔符，如“out--standing”中的"--"视为间隔符，是 2 个独立整体字符串”out”和”standing”
 * 	除了 1，2 里面定义的字符以外其他的所有字符，都是非法字符，作为字符串的间隔符处理，倒序后间隔符作为空格处理；
 * 	要求倒排后的单词间隔符以一个空格表示；
 * 	如果有多个间隔符时，倒排转换后也只允许出现一个字格间隔符
 *
 * 输入示例：
 * 	I am an 20-years out--standing @ * -stu- dent
 * 输出示例：
 * 	dent stu standing out 20-years an am I
 */
public class _数字字符串组合倒序_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        

        // 筛选出：数字、英文大小写字母、-符号
        StringBuilder res = new StringBuilder();
        int n = chars.length;

        for (int i = 0; i < n; i++) {
            char c = chars[i];

            // 数字、英文大小写字母
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
                res.append(c);
            } else {
                if (c == '-') {
                    if (i + 1 < n) {
                        char next = chars[i + 1];
                        if (next == '-') {
                            // 连续两个及以上 -- ，作为单词分隔符
                            while (i < n && chars[i] == '-') {
                                i++;
                            }
                            i--;
                            res.append(" ");
                        } else if ((next >= 'a' && next <= 'z') || (next >= 'A' && next <= 'Z') || (next >= '0' && next <= '9')) {
                            // 两个单词的连接符：out--standing
                            res.append("-");
                        }
                    }
                } else {
                    // 其他非法符号，合并成一个空格
                    while (i < n && !((chars[i] >= 'a' && chars[i] <= 'z') || (chars[i] >= 'A' && chars[i] <= 'Z') || (chars[i] >= '0' && chars[i] <= '9'))) {
                        i++;
                    }
                    i--;
                    res.append(" ");
                }
            }
        }

        String[] split = res.toString().split(" ");
        for (int i = split.length - 1; i >= 0; i--) {
            if (i < split.length - 1) {
                System.out.print(" ");
            }
            System.out.print(split[i]);
        }
        System.out.println();
    }

}
