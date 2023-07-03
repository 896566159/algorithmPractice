package nowcoder.outd.Y22Q4;

import java.util.Scanner;

/**
 * 给定一个url前缀和url后缀,通过,分割 需要将其连接为一个完整的url
 * 如果前缀结尾和后缀开头都没有/，需要自动补上/连接符
 * 如果前缀结尾和后缀开头都为/，需要自动去重
 * 约束：不用考虑前后缀URL不合法情况
 *
 * 输入描述:
 * 	url前缀(一个长度小于100的字符串) url后缀(一个长度小于100的字符串)
 * 输出描述：
 * 	拼接后的url
 *
 * 示例 1：
 * 	输入：
 * 		/acm,/bb
 * 	输出：
 * 		/acm/bb
 * 示例 2：
 * 	输入：
 * 		/abc/,/bcd
 * 	输出：
 * 		/abc/bcd
 * 示例 3：
 * 	输入：
 * 		/acd,bef
 * 	输出：
 * 		/acd/bef
 *
 * 示例 4：
 * 	输入：
 * 		,
 * 	输出：
 * 		/
 */
public class _拼接URL_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int index = line.indexOf(',');
        String prefix = line.substring(0, index);
        String suffix = line.substring(index + 1, line.length());

        if (prefix.length() == 0 && suffix.length() == 0) {
            System.out.println("/");
        } else if (prefix.length() != 0 && suffix.length() == 0) {
            if (prefix.charAt(0) != '/') {
                prefix = "/" + prefix;
            }
            if (prefix.charAt(prefix.length() - 1) == '/') {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
            System.out.println(prefix);
        } else if (prefix.length() == 0 && suffix.length() != 0) {
            if (suffix.charAt(0) != '/') {
                suffix = "/" + suffix;
            }
            if (suffix.charAt(suffix.length() - 1) == '/') {
                suffix = suffix.substring(0, suffix.length() - 1);
            }
            System.out.println(suffix);
        } else {
            if (prefix.charAt(0) != '/') {
                prefix = "/" + prefix;
            }
            if (prefix.charAt(prefix.length() - 1) == '/') {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
            if (suffix.charAt(0) != '/') {
                suffix = "/" + suffix;
            }
            if (suffix.charAt(suffix.length() - 1) == '/') {
                suffix = suffix.substring(0, suffix.length() - 1);
            }
            System.out.println(prefix + suffix);
        }


    }

}
