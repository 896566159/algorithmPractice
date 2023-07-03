package nowcoder.outd.Y22Q4;

import java.util.*;

/**
 * 题目描述：
 * 	给定一个元素类型为小写字符串的数组，请计算两个没有相同字符的元素长度乘积的最大值。
 * 	如果没有符合条件的两个元素返回 0。
 * 输入描述：
 * 	输入为一个半角逗号分割的小写字符串数组
 * 	2<= 数组长度 <=100
 * 	0< 字符串长度 <=50
 * 输出描述
 * 	两个没有相同字符的元素长度乘积的最大值
 *
 * 示例 1：
 * 	输入：
 * 		iwdvpbn,hk,iuop,iikd,kadgpf
 * 	输出：
 * 		14
 * 说明：
 * 	数组中有 5 个元素。
 * 	iwdvpbn 与 hk 无相同的字符，满足条件，iwdvpbn 的长度为 7，hk的长度为 2，乘积为 14（7*2）。
 * 	iwdvpbn 与 iuop、iikd、kadgpf 均有相同的字符，不满足条件。
 * 	iuop 与 iikd、kadgpf 均有相同的字符，不满足条件。
 */
public class _无重复字符的元素长度乘积的最大值_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.next().split(",");

        // 暴力
        m1(split);
    }

    private static void m1(String[] split) {
        int max = 0;
        int n = split.length;
        Arrays.sort(split);
        for (int i = 0; i < n; i++) {
            // 如果两个单词一样，跳过
            if (i > 1 && split[i].equals(split[i - 1])) {
                continue;
            }

            Set<Character> set = new HashSet<>();
            for (char c : split[i].toCharArray()) {
                set.add(c);
            }

            for (int j = i + 1; j < n; j++) {
                // 两个单词是否有相同字符
                boolean hasSame = false;
                for (char c : split[j].toCharArray()) {
                    if (set.contains(c)) {
                        hasSame = true;
                        break;
                    }
                }

                // 更新最长
                if (!hasSame) {
                    max = Math.max(max, split[i].length() * split[j].length());
                }
            }
        }

        System.out.println(max);
    }

}
