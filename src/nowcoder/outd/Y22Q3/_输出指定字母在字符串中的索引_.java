package nowcoder.outd.Y22Q3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 给定一个字符串，把字符串按照大写在前小写在后排序，输出排好后的第 K 个字母在原来字符串的索引。
 * 相同字母输出第一个出现的位置。
 *
 * 示例1：
 * 	输入：
 * 		hAkDAjByBq 4
 * 	输出：
 * 		6
 * 说明：
 * 	排好序后 AABBDhjkqy，第 4 个是 B，第一个出现的在原字符串 6 这个位置。（注：索引是从 0 开始）
 */
public class _输出指定字母在字符串中的索引_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int k = Integer.parseInt(split[1]);
        char[] original = split[0].toCharArray();

        char target = '#';
        int n = original.length;
        char[] sort = new char[n];
        int tail = n - 1;
        int head = 0;
        for (char c : original) {
            if ('A' <= c && 'Z' >= c) {
                sort[head++] = c;
                // 第 k 个字母已经锁定
                if (head > k) {
                    target = sort[k];
                    break;
                }
            } else {
                sort[tail--] = c;
            }
        }

        // 再次确认，第 k 个字母还没有锁定
        target = target == '#' ? sort[k] : target;

        // 找到 target 在原始字符串中的位置并输出
        for (int i = 0; i < n; i++) {
            if (target == original[i]) {
                System.out.println(i);
                break;
            }
        }
    }

}
