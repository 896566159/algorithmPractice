package nowcoder.outd.Y23Q2;

import java.util.Scanner;

/**
 * 给定一个字符串s，最多只能进行一次变换，返回变换后能得到的最小字符串（按照字典序进行比较）。
 * 变换规则：交换字符串中任意两个不同位置的字符。
 * 输入描述：
 * 	一串小写字母组成的字符串s
 * 输出描述：
 * 	按照要求进行变换得到的最小字符串
 * 备注：
 * 	s是都是小写字符组成
 * 	1<=s.length<=1000
 *
 * 示例1:
 * 输入：
 * 	abcdef
 * 输出：
 * 	abcdef
 * 说明：
 * 	abcdef已经是最小字符串，不需要交换
 *
 * 示例2:
 * 	输入：
 * 		bcdefa
 * 	输出：
 * 		acdefb
 * 说明：
 * 	a和b进行位置交换，可以得到最小字符串
 *
 * 示例3:
 * 	输入：
 * 		aaabbmncgch
 * 	输出：
 * 		aaabbcncgmh
 * 说明：
 * 	a和b进行位置交换，可以得到最小字符串
 */
public class _字符串变换最小字符串_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char[] chars = line.toCharArray();
        int[] count = new int[26];

        for (char c : chars) {
            count[c - 'a']++;
        }

        int index = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                // 前面的字母必须都是aaaa
                while (count[i] > 0 && line.charAt(index) == (char) (i + 'a')) {
                    count[i]--;
                    index++;
                }

                // 说明前面有比当前大的字母，交换
                if (count[i] > 0) {
                    int j = chars.length - 1;
                    while (j >= 0) {
                        if (chars[j] == (char) (i + 'a')) {
                            break;
                        }
                        j--;
                    }

                    char tmp = chars[j];
                    chars[j] = chars[index];
                    chars[index] = tmp;
                    System.out.println(new String(chars));
                    return;
                }
            }
        }

        if (index == chars.length) {
            System.out.println(line);
        }
    }

}
