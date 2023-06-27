package nowcoder.outd.Y22Q4;

import java.util.Scanner;

/**
 * 输入一串方波信号，求取最长的完全连续交替方波信号，并将其输出，如果有相同长度的交替方波信号，输出任一即可，
 * 方波信号高位用1标识，低位用0标识，
 * 说明：
 * 1） 一个完整的信号一定以0开始然后以0结尾，即 010 是一个完整信号，但 101，1010，0101 不是
 * 2） 输入的一串方波信号是由一个或多个完整信号组成
 * 3） 两个相邻信号之间可能有 0 个或 多个低位，如 0110010，011000010
 * 4） 同一个信号中可以有连续的高位，如 01110101011110001010，前 14位 是一个具有连续高位的信号
 * 5） 完全连续交替方波是指 10 交替，如 01010 是完全连续交替方波，0110 不是
 * 输入描述：
 * 	输入信号字符串（长度 >= 3 且 <= 1024）：
 * 	0010101010110000101000010
 * 注：输入总是合法的，不用考虑异常情况
 * 输出描述：
 * 	输出最长的完全连续交替方波信号串：01010
 * 	若不存在完全连续交替方波信号串，输出 -1。
 * 示例1：
 * 	输入：
 * 		00101010101100001010010
 * 	输出：
 * 		01010
 * 备注:
 * 输入信号串中有三个信号：0 010101010110(第一个信号段) 00 01010(第二个信号段) 010(第三个信号段)
 * 第一个信号虽然有交替的方波信号段，但出现了 11 部分的连续高位，不算完全连续交替方波，
 * 在剩下的连续方波信号串中 01010 最长
 */
public class _最长连续方波信号_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char[] chars = line.toCharArray();
        int left = 0;
        int right = 1;
        int n = chars.length;
        int maxLen = 0;
        int begin = 0;
        int end = 0;

        // left 指向信号开始的那个 0
        while (right < n) {
            // 扫描字符串，看是否存在两个不连续的 0
            while (right < n && chars[right] == '0' && left == right - 1) {
                right++;
                left++;
            }

            // 已经扫描结束，没有信号段了
            if (right == n) {
                break;
            }

            // 现在 right = '1', left = '0',即信号波开始
            int start = right + 1;
            boolean isUpDown = true;
            while (start < n) {
                // 出现两个连续的 0，表明信号波结束了
                if (chars[start - 1] == chars[start] && chars[start] == '0') {
                    break;
                }

                // 出现的信号波没有交替，则不是完全交替方波
                if (isUpDown && chars[start - 1] == chars[start]) {
                    isUpDown = false;
                }
                start++;
            }

            // 是否是完全连续连续交替方波，且是不是最长的
            if (isUpDown && maxLen < start - left) {
                begin = left;
                end = start;
                maxLen = start - left;
            }

            // 更新 right 和 start
            right = start;
            left = start - 1;
        }

        if (maxLen == 0) {
            System.out.println(-1);
        } else {
            System.out.println(line.substring(begin, end));
        }
    }

}
