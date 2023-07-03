package nowcoder.outd.Y22Q4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 小组中每位都有一张卡片，卡片上是 6 位内的正整数，将卡片连起来可以组成多种数字，计算组成的最大数字。
 * 输入描述：“,”号分割的多个正整数字符串，不需要考虑非数字异常情况，小组最多25个人。
 * 输出描述： 最大的数字字符串
 *
 * 示例1：
 * 	输入：
 * 		22,221
 * 	输出：
 * 		22221
 *
 * 示例2：
 * 	输入：
 * 		4589,101,41425,9999
 * 	输出：
 * 		9999458941425101
 */
public class _组成最大_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");

        Arrays.sort(split, (a, b)-> {
            int aLen = a.length();
            int bLen = b.length();

            if (a.length() == b.length()) {
                return a.compareTo(b);
            }

            int min = Math.min(aLen, bLen);
            for (int i = 0; i < min; i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    return a.charAt(i) - b.charAt(i);
                }
            }

            if (aLen == min) {
                return b.charAt(min) - a.charAt(min - 1);
            } else {
                return a.charAt(min) - b.charAt(min - 1);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            sb.append(split[i]);
        }

        System.out.println(sb.toString());
    }

}
