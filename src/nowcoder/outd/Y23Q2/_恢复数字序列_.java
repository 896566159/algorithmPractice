package nowcoder.outd.Y23Q2;

import java.util.Scanner;

/**
 * 对于一个连续正整数组成的序列，可以将其拼接成一个字符串，再将字符串里的部分字符打乱顺序。
 * 如序列8 9 10 11 12，拼接成的字符串为89101112，打乱一部分字符后得到90811211，原来的正整数10就被拆成了0和1。
 * 现给定一个按如上规则得到的打乱字符的字符串，请将其还原成连续正整数序列，并输出序列中最小的数字.
 *
 * 输入描述：
 * 	输入一行，为打乱字符的字符串和正整数序列的长度，两者间用空格分隔，字符审长度不超过200，正整数不超过1000，保证输入可以还原成唯一序列。
 * 输出描述：
 * 	输出一个数字，为序列中最小的数字
 * 示例1：
 * 	输入：
 * 		19801211 5
 * 	输出：
 * 		8
 * 说明：正常的数字序列为8 9 10 11 12 这5个数字，最小数字为8
 */
public class _恢复数字序列_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int n = Integer.parseInt(split[1]);
        int len = split[0].length();
        int mod = len % n;
        // 最多的数字有几位
        int digit = mod == 0 ? len / n : len / n + 1;
        int[] count = new int[10];

        for (char c : split[0].toCharArray()) {
            count[c - '0']++;
        }

        int first = 0;
        int frequency = 0;
        for (int i = 1; i < 10; i++) {
            // 找出频率最高的那个
            if (frequency < count[i]) {
                frequency = count[i];
                first = i;
            }
        }

        // 如果是个位数
        if (digit == 1) {
            for (int i = 0; i < 10; i++) {
                if (count[i] == 1) {
                    System.out.println(i);
                    return;
                }
            }
        } else if (digit == 2) {
            // 两位数，以 first 数字开头左右两边搜索范围 +-n
            int start = first * 10 - n < 0 ? 0 : first * 10 - n;
            int end = (first + 1) * 10 + n < 10 ? 10 + n : (first + 1) * 10 + n;

            for (int i = start; i < end; i++) {
                int[] tmp = new int[10];
                for (int j = i; j < i + n; j++) {
                    if (j >= 10) {
                        tmp[j / 10]++;// 十位
                        tmp[j % 10]++;// 个位
                    } else {
                        tmp[j % 10]++;// 个位
                    }
                }

                // 如果字母相同，则就是答案
                if (checkIsSame(tmp, count)) {
                    System.out.println(i);
                    return;
                }
            }
        } else if (digit == 3) {
            // 两位数，以 first 数字开头左右两边搜索范围 +-n
            int start = first * 100 - n;
            int end = first == 9 ? 1001 : (first + 1) * 100 + n;

            for (int i = start; i < end; i++) {
                int[] tmp = new int[10];
                if (i == 199) {
                    System.out.println();
                }
                for (int j = i; j < i + n; j++) {
                    if (j < 10) {
                        tmp[j % 10]++;// 个位
                    } else if (j >= 10 && j < 100) {
                        tmp[j / 100]++;// 十位
                        tmp[j % 10]++;// 个位
                    } else if (j >= 100 && j < 1000){
                        tmp[j / 100]++;// 百位
                        tmp[j / 10 % 10]++;// 十位
                        tmp[j % 10]++;// 个位
                    } else if (j == 1000) {
                        tmp[0] += 3;
                        tmp[1]++;
                    }
                }

                // 如果字母相同，则就是答案
                if (checkIsSame(tmp, count)) {
                    System.out.println(i);
                    return;
                }
            }
        }
    }

    private static boolean checkIsSame(int[] tmp, int[] count) {
        for (int i = 0; i < 10; i++) {
            if (count[i] != tmp[i]) {
                return false;
            }
        }
        return true;
    }

}
