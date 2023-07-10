package nowcoder.outd.Y22Q4;

import java.util.Scanner;

/**
 * 给定两个字符串 s1 和 s2 和正整数k，其中 s1 长度为 n1，s2 长度为 n2，
 * 在s2中选一个子串，满足:
 *     1：该子串长度为 n1+k
 *     2：该子串中包含 s1 中全部字母，
 *     3：该子串每个字母出现次数不小于s1中对应的字母，
 * 我们称s2以长度k冗余覆盖s1，
 * 给定s1，s2，k,
 * 求最左侧的 s2以长度 k 冗余覆盖s1 的子串的首个元素的下标，
 * 如果没有返回-1。
 *
 * 输入描述：
 * 	输入为三行
 * 	第一行为 s1
 * 	第二行为 s2
 * 	第三行为 k
 * 	s1和s2都只包含小写字母
 *
 * 输出描述：
 * 	最左侧的 s2 以长度 k 冗余覆盖 s1 的子串的首个元素下标，若不存在，则返回-1.
 *
 * 示例1：
 * 	输入：
 * 		ab
 * 		aabcd
 * 		1
 * 	输出：
 * 		0
 *
 * 示例2：
 * 	输入：
 * 		abc
 * 		dfs
 * 		10
 * 	输出：
 * 		-1
 */
public class _最左侧冗余覆盖子串_ {

    public static void main(String[] args) {
        //处理输入
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int k = Integer.parseInt(scanner.nextLine());
        int lenS1 = s1.length();
        int lenS2 = s2.length();

        //长度限制，不可能存在覆盖子串
        if (lenS2 < lenS1 + k) {
            System.out.println(-1);
            return;
        }

        // 数组的下标就是字母的ASCII码
        int[] countS1 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            countS1[s1.charAt(i) - 'a']++;
        }

        // 判断 s2 的 [0, s1.length() + k] 是否就满足答案
        for (int j = 0; j < s1.length() + k; j++) {
            if (countS1[s2.charAt(j) - 'a']-- > 0) {
                lenS1--;
            }

            // 满足了条件，直接输出 0
            if (lenS1 == 0) {
                System.out.println(0);
                return;
            }
        }

        // 寻找 s2 左侧下标从 [1, lenS2 - s1.length() - k) 是否满足答案
        for (int i = 1; i <= lenS2 - s1.length() - k; i++) {
            // 左边滑出去的字母，导致窗口内字母数量变化
            if (countS1[s2.charAt(i - 1) - 'a']++ >= 0) {
                lenS1++;
            }

            // 右边滑进来的字母
            if (countS1[s2.charAt(i - 1 + s1.length() + k) - 'a']-- > 0) {
                lenS1--;
            }

            // 满足条件，输出窗口左边界
            if (lenS1 == 0) {
                System.out.println(i);
                return;
            }
        }
    }

}
