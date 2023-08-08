package nowcoder.outd.Y23Q2;

import java.util.Scanner;

/**
 * 给定两个字符串str1和str2，
 * str1进行排列组合只要有一个为str2的子串则认为str1是str2的关联子串，
 * 请返回子串在str2的起始位置，若不是关联子串则返回-1。
 *
 * 示例1:
 * 	输入:
 * 		abc efghicbaiii
 * 	输出:
 * 		5
 *
 * 示例2:
 * 	输入:
 * 		abc efghiccaiii
 * 	输出:
 * 		-1
 */
public class _关联子串_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        char[] str1 = split[0].toCharArray();
        char[] str2 = split[1].toCharArray();
        if (str2.length < str1.length) {
            System.out.println(-1);
            return;
        }

        int n2 = str2.length;
        int n1 = str1.length;
        int[] frequency = new int[128];
        for (int i = 0; i < n1; i++) {
            frequency[str1[i]]++;
        }


        int left = 0;
        int right = 0;
        int[] tmp = new int[128];
        while (right < n1 - 1) {
            tmp[str2[right++]]++;
        }

        while (right < str2.length) {
            tmp[str2[right++]]++;

            boolean isSame = true;
            for (int i = 0; i < 128; i++) {
                if (frequency[i] != tmp[i]) {
                    isSame = false;
                    break;
                }
            }

            if (isSame) {
                System.out.println(left);
                return;
            }
            tmp[str2[left++]]--;
        }

        System.out.println(-1);
    }

}
