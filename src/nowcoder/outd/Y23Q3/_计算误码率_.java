package nowcoder.outd.Y23Q3;

import java.util.Scanner;

/**
 * 误码率是最常用的数据通信传输质量指标。
 * 它可以理解为“在多少位数据中出现一位差错”。
 * 移动通信网络中的误码率主要是指比特误码率，其计算公式如下:
 * 	比特误码率 = 错误比特数 / 传输总比特数。
 * 为了简单，我们使用字符串来标识通信的信息，一个字符错误了，就认为出现了一个误码。
 * 输入一个标准的字符串，和一个传输后的字符串，计算误码率字符串会被压缩。
 * 例:“2A3B4D5X1Z”表示"AABBBDDDDXXXXXZ"
 * 用例会保证两个输入字符串解压后长度一致，解压前的长度不一定一致，每个生成后的字符串长度<100000000.
 *
 * 输入描述：
 * 	两行，分别为两种字符串的压缩形式。
 * 	每行字符串(压缩后的) 长度<100000
 * 输出描述：
 * 	一行，错误的字数量/展开后的总长度
 * 备注：
 * 	注意: 展开后的字符串不含数字
 *
 * 示例1：
 * 	输入：
 * 		3A3B
 * 		2A4B
 * 	输出：
 * 		1/6
 *
 * 示例2：
 * 	输入：
 * 		5Y5Z
 * 		5Y5Z
 * 	输出：
 * 		0/10
 *
 * 示例3：
 * 	输入：
 * 		4Y5Z
 * 		9Y
 * 	输出：
 * 		5/9
 */
public class _计算误码率_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] original = scanner.nextLine().toCharArray();
        char[] trans = scanner.nextLine().toCharArray();
        // 还原自由字母的字符串
        char[] oldChar = original2char(original);
        char[] newChar = original2char(trans);

        int index1 = 0;
        int index2 = 0;
        int count = 0;
        while (index1 < oldChar.length && index2 < newChar.length) {
            if (oldChar[index1] != newChar[index2]) {
                count++;
            }
            index1++;
            index2++;
        }
        if (index1 == oldChar.length && index2 < newChar.length) {
            count += (newChar.length - index2);
        }
        if (index2 == newChar.length && index1 < oldChar.length) {
            count += (oldChar.length - index1);
        }

        System.out.println(count + "/" + oldChar.length);
    }

    private static char[] original2char(char[] original) {
        // 恢复原始字符串
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < original.length) {
            StringBuilder tmp = new StringBuilder();
            // 数字
            while (index < original.length && original[index] >= '0' && original[index] <= '9') {
                tmp.append(original[index]);
                index++;
            }
            int count = Integer.parseInt(tmp.toString());

            // 字母
            while (count > 0) {
                sb.append(original[index]);
                count--;
            }
            // 一下个数字
            index++;
        }

        return sb.toString().toCharArray();
    }

}
