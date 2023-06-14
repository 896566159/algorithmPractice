package nowcoder.outd.Y22Q4;

import java.util.Scanner;

/**
 * 一、题目
 * 输入一个长度为 4 的倍数的字符串，字符串中仅包含 WASD 四个字母。
 * 将这个字符串中的连续子串用同等长度的仅包含 WASD 的字符串替换，如果替换后整个字符串中 WASD 四个字母出现的频数相同，那么我们称替换后的字符串是“完美走位”。
 * 求子串的最小长度。
 * 如果输入字符串已经平衡则输出 0。
 *
 * 二、输入
 * 一行字符表示给定的字符串s
 * 数据范围：
 * 1<=n<=10^5且n是4的倍数，字符串中仅包含WASD四个字母。
 * 三、输出
 * 一个整数表示答案
 *
 * 示例1：
 * 	输入：
 * 		WASDAASD
 * 	输出：
 * 		1
 * 说明：将第二个A替换为W，即可得到完美走位
 *
 * 示例2：
 * 	输入：
 * 		AAAA
 * 	输出：
 * 		3
 *
 * 说明：将其中三个连续的A替换为WSD，即可得到完美走位
 */
public class _完美走位_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int[] count = new int['X'];
        char[] chars = line.toCharArray();

        // 统计 WASD 四个字母出现的频率
        for (char c : chars) {
            count[c]++;
        }

        // 如果本来是完美字符串
        if (count['A'] == count['S'] && count['A'] == count['D'] && count['A'] == count['W']) {
            System.out.println("0");
            return;
        }

        int n = chars.length;
        int m = n / 4;
        int left = 0;
        int min = n;

        for (int right = 0; right < n; right++) {
            --count[chars[right]];

            // 在 [left,right] 之外的字符串中的 ASDW 的数量都是小于等于 m
            // 故只需要将 [left,right] 之间的字符替换掉，就可满足要求
            while (count['A'] <= m && count['S'] <= m && count['D'] <= m && count['W'] <= m) {
                min = Math.min(min, right - left + 1);
                // 左指针向右移动，则 [left, right] 的左边的字符串要统计回去
                ++count[chars[left++]];
            }
        }

        System.out.println(min);
    }
}
