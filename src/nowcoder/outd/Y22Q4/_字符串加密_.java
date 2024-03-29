package nowcoder.outd.Y22Q4;

import java.util.Scanner;

/**
 * 给你一串未加密的字符串 str，通过对字符串的每一个字母进行改变来实现加密，加密方式是在每一个字母 str[i] 偏移特定数组元素 a[i] 的量，数组a前三位已经赋值：a[0] = 1,a[1] = 2,a[2] = 4
 * 当 i >= 3 时，数组元素 a[i] = a[i-1] + a[i-2] + a[i-3]。
 * 例如：原文 abcde 加密后 bdgkr，其中偏移量分别是 1,2,4,7,13。
 * 输入描述:
 * 	第一行为一个整数n（1 <= n <= 1000），表示有n组测试数据，每组数据包含一行，原文 str（只含有小写字母，0 < 长度 <= 50）。
 * 输出描述:
 * 	每组测试数据输出一行，表示字符串的密文。
 *
 * 示例1:
 * 	输入:
 * 		1
 * 		xy
 * 	输出:
 * 		ya
 * 说明:第一个字符x偏移量是1，即为y，第二个字符y偏移量是2，即为a。
 */
public class _字符串加密_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] originStr = new String[n];
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            originStr[i] = scanner.nextLine();
            maxLen = Math.max(maxLen, originStr.length);
        }

        int[] a = new int[maxLen > 3 ? maxLen : 3];
        String[] encrypted = new String[n];
        a[0] = 1;
        a[1] = 2;
        a[2] = 4;

        // 求解斐波那契数列
        for (int i = 3; i < maxLen; i++) {
            a[i] = a[i - 1] + a[i - 2] + a[i - 3];
        }

        // 加密
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            char[] chars = originStr[i].toCharArray();

            for (int j = 0; j < chars.length; j++) {
                sb.append((char) ((chars[j] - 'a'  + a[j]) % 26 + 'a'));
            }

            encrypted[i] = sb.toString();
        }

        for (String encry : encrypted) {
            System.out.println(encry);
        }

    }

}
