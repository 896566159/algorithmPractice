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
 * 说明：m2[c] 解压缩后为 mcc，重复三次为 mccmccmcc
 */
public class _报文解压缩_ {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String originStr = sc.nextLine();
        String res = parse(originStr);
        System.out.println(res);
    }

    private static String parse(String originStr) {
        int n = originStr.length();
        StringBuilder res = new StringBuilder();

        // 如果字符串外层就是一个 []，直接返回括号中的内容
        if (originStr.charAt(0) == '[' && originStr.charAt(0) == ']') {
            return parse(originStr.substring(1, originStr.length() - 1));
        }

        for (int i = 0; i < n; i++) {
            // 遇见数字，就代表遇见了 n[str]，因为题目说的——原始报文不包含数字，所有的数字只表示重复的次数 n ，例如不会出现像 5b 或 3[8] 的输入；
            char c = originStr.charAt(i);
            if (c < '9' && c > '0') {
                // 先解析数字
                int j = i;
                while (originStr.charAt(j) > '0' && originStr.charAt(j) < '9'  && j < n) {
                    j++;
                }
                int num = Integer.parseInt(originStr.substring(i, j));
                int k = j;

                // 找到成对的 []
                while (originStr.charAt(k) != ']'  && k < n) {
                    k++;
                }
                String parseStr = parse(originStr.substring(j + 1, k + 1 == n ? k : k + 1));
                // 拼接
                while (num-- > 0) {
                    res.append(parseStr);
                }
                // 更新 i
                i = k;
            } else {
                if (c != ']') {
                    res.append(c);
                }
            }
        }

        return res.toString();
    }

}
