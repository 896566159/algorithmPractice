package nowcoder.outd.Y23Q2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 相对开音节构成的结构为 辅音 + 元音(aeiou) + 辅音(r除外) + e
 * 常见的单词有bike cake
 * 给定一个字符串，以空格为分隔符
 * 反转每个单词的字母
 * 若单词中包含如数字等其他非字母时不进行反转
 * 反转后计算其中含有相对开音节结构的子串个数
 * (连续子串中部分字符可以重复)
 *
 * 输入描述:
 * 	字符串 以空格分割的多个单词
 * 	长度<10000
 * 	字母只考虑小写
 * 输出描述:
 * 	含有相对开音节结构的子串个数
 *
 * 示例1：
 * 	输入:
 * 		ekam a ekac
 * 	输出:
 * 		2
 * 说明：
 * 	反转后为  make a cake 其中make和cake为相对开音节子串，返回2
 *
 * 示例2：
 * 	输入:
 * 		!ekam a ekekac
 * 	输出:
 * 		2
 * 说明:
 * 	反转后为 !ekam a cakeke
 * 	因为!ekam含有非英文字母，所以未反转
 * 	其中 cake 和 keke 为相对开音节子串
 * 	返回 2
 */
public class _相对开音节_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int res = 0;

        for (String s : split) {
            StringBuilder sb = new StringBuilder(s);
            // 需不需要翻转取决于——是否有非字母，
            Pattern pattern = Pattern.compile("\\W");
            Matcher matcher = pattern.matcher(sb);

            // 含有非字母
            if (!matcher.find()) {
                sb.reverse();
            }

            char[] chars = sb.toString().toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (i >= 1
                        && i + 2 < chars.length
                        && (chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u')) {
                    boolean flag = true;
                    if (chars[i - 1] == 'a' || chars[i - 1] == 'e' || chars[i - 1] == 'i' || chars[i - 1] == 'o' || chars[i - 1] == 'u') {
                        flag = false;
                    }

                    if (flag && (chars[i + 1] == 'a' || chars[i + 1] == 'e' || chars[i + 1] == 'i' || chars[i + 1] == 'o' || chars[i + 1] == 'u' || chars[i + 1] == 'r')) {
                        flag = false;
                    }

                    if (flag && chars[i + 2] == 'e') {
                        res++;
                    }
                }
            }
        }

        System.out.println(res);
    }

}
