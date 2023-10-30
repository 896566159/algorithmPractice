package nowcoder.outd.Y22Q4;

import java.util.Scanner;

/**
 * 为了提升数据传输的效率，会对传输的报文进行压缩处理。
 * 输入一个压缩后的报文，请返回它解压后的原始报文。
 * 压缩规则：n[str]，表示方括号内部的 str 正好重复 n 次。
 * 注意 n 为正整数（0 < n <= 100），str 只包含小写英文字母，不考虑异常情况。
 * 输入描述:
 * 	输入压缩后的报文：
 * 		1）不考虑无效的输入，报文没有额外的空格，方括号总是符合格式要求的；
 * 		2）原始报文不包含数字，所有的数字只表示重复的次数 n ，例如不会出现像 5b 或 3[8] 的输入；
 * 输出描述:
 * 	解压后的原始报文
 * 注：原始报文长度不会超过1000，不考虑异常的情况
 *
 * 示例1：
 * 	输入:
 * 		3[k]2[mn]
 * 	输出：
 * 		kkkmnmn
 * 说明：k 重复3次，mn 重复2次，最终得到 kkkmnmn
 *
 * 示例2：
 * 	输入：
 * 		3[m2[c]]
 * 	输出:
 * 		mccmccmcc
 * 说明：m2[c] 解压缩后为 mcc，重复三次为 mccmccmcc  3[g[v][ab]]zx
 */
public class _报文解压缩_ {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String originStr = sc.nextLine();
        while (originStr.contains("[")) {
            originStr = parse(originStr);
        }
        System.out.println(originStr);
    }

    // 还原原始报文：每次都找到最深的括号解析出括号中的内容
    // 最深的括号特点：
    // 其左括号是最右边那个
    // 其右括号的最左边那个
    private static String parse(String originStr) {
        StringBuilder res = new StringBuilder();
        char[] chars = originStr.toCharArray();
        int n = chars.length;
        // 找到最右边的左括号
        int left = n - 1;
        while (left >= 0 && chars[left] != '[') {
            left--;
        }

        // 找到最左边的右括号
        int right = left + 1;
        while (right < n && chars[right] != ']') {
            right++;
        }

        // 括号[]的左右边界已经明确，判断是否是被压缩的字符串：n[str]
        if (left - 1 >= 0 && chars[left - 1] >= '0' && chars[left - 1] <= '9') {
            int tmp = left - 1;
            while (tmp >= 0 && chars[tmp] >= '0' && chars[tmp] <= '9') {
                tmp--;
            }
            int num = Integer.parseInt(originStr.substring(tmp + 1, left));

            // 拼接括号之前的字符串
            res.append(originStr.substring(0, tmp + 1));
            // 拼接括号中的解压字符串
            while (num-- > 0) {
                res.append(originStr.substring(left + 1, right));
            }
            // 拼接括号之前的字符串
            res.append(originStr.substring(right + 1, originStr.length()));
        } else {
            // 括号外没有数字，只是单纯的 [str]，直接去掉括号
            res.append(originStr.substring(0, left));
            res.append(originStr.substring(left + 1, right));
            res.append(originStr.substring(right + 1, originStr.length()));
        }

        return res.toString();
    }


}
