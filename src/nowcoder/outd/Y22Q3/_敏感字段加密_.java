package nowcoder.outd.Y22Q3;

import java.util.Scanner;

/**
 * 给定一个由多个命令字组成的命令字符串:
 * 	1、字符串长度小于等于127字节，只包含大小写字母、数字、下划线和偶数个双引号
 * 	2、命令字之间以一个或多个下划线 _ 进行分割;
 * 	3、可以通过两个双引号”来标识包含下划线 的命令字或空命令字(仅包含两个双引号的命令字)，双引号不会在命令字内部出现
 * 请对指定索引的敏感字段进行加密，替换为****** (6个*) ，并删除命令字前后多余的下划线。
 * 如果无法找到指定索引的命令字，输出字符串ERROR。
 *
 * 输入描述：
 * 	输入为两行，第一行为命令字索引K (从0开始) ，
 * 	第二行为命令字符串S.
 * 输出描述：
 * 	输出处理后的命令字符串，如果无法找到指定索引的命令字，输出字符串ERROR
 *
 * 用例1：
 * 	输入：
 * 		1
 * 		password__a12345678_timeout_100
 * 	输出：
 * 		password_******_timeout_100
 * 说明：加密第2个命令字
 *
 * 用例2：
 * 	输入：
 * 		2
 * 		aaa_password_"a12_45678"_timeout__100_""_
 * 	输出：
 * 		aaa_password_******_timeout_100_""
 * 说明：加密第3个命令字
 */
public class _敏感字段加密_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index = Integer.parseInt(scanner.nextLine());
        char[] original = scanner.nextLine().toCharArray();
        int n = original.length;
        StringBuilder res = new StringBuilder();

        // 找到第一个非下划线的位置
        int count = 0;
        int i = 0;
        // 从第一个命令字开始遍历
        while (i < n) {
            // 忽略多于的下划线
            while (i < n && original[i] == '_') {
                i++;
            }
            // 已经遍历结束
            if (i >= n) {
                break;
            }

            // 命令字
            StringBuilder cur = new StringBuilder();
            boolean flag = false;
            if (original[i] == '"') {
                // 标记当前命令可能是带有下划线的、或者是空命令字
                flag = true;
                i++;
                while (i < n && original[i] != '"') {
                    cur.append(original[i]);
                    i++;
                }
                i++;
            } else {
                while (i < n && original[i] != '_') {
                    cur.append(original[i]);
                    i++;
                }
            }

            if (count > 0) {
                // 命令字之间以下划线相隔
                res.append("_");
            }
            if (count++ == index) {
                res.append("******");
            } else {
                if (flag) {
                    res.append('"').append(cur).append('"');
                } else {
                    res.append(cur);
                }
            }
        }

        if (count >= index) {
            System.out.println(res.toString());
        } else {
            System.out.println("ERROR");
        }
    }

}
