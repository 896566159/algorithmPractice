package nowcoder.outd.Y23Q2;

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
        String[] split = scanner.nextLine().split(",");
        StringBuilder sb = new StringBuilder();
        sb.append("/");

        for (int i = 0; i < split.length; i++) {
            String s = split[i];

            if (s.charAt(0) == '/') {
                sb.append(s.substring(1, s.length()));
            } else {
                sb.append(s);
            }

            if (i != split.length - 1 && sb.charAt(sb.length() - 1) != '/') {
                sb.append("/");
            }
        }

        if (sb.charAt(sb.length() - 1) == '/') {
            sb.delete(sb.length() - 1, sb.length());
        }
        System.out.println(sb);
    }

}
