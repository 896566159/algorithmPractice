package nowcoder.outd.Y23Q2;

import java.util.Scanner;

/**
 * 给你一个字符串数组（每个字符串均由小写字母组成）和一个字符规律（由小写字母和.和*组成），识别数组中哪些字符串可以匹配到字符规律上。
 * '.' 匹配任意单个字符，'*' 匹配零个或多个前面的那一个元素，所谓匹配，是要涵盖整个字符串的，而不是部分字符串。
 *
 * 输入描述：
 * 	第一行为空格分割的多个字符串，1 <  单个字符串长度 < 100， 1 < 字符串个数 < 100
 * 	第二行为字符规律，1 < 字符串个数 < 100  第二行为字符规律，1><= 字符规律长度 <= 50
 * 	不需要考虑异常场景
 * 输出描述：
 * 	匹配的字符串在数组中的下标（从0开始），多个匹配时下标升序并用,分割，若均不匹配输出-1
 *
 * 示例1：
 * 输入：
 * 	ab aab
 * 	.*
 * 输出：
 * 	0,1
 */
public class _字符匹配_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] lines = scanner.nextLine().split(" ");
        char[] reg = scanner.nextLine().toCharArray();

        // .*
        int n = lines.length;
        for (int i = 0; i < n; i++) {
            int index = 0;
            int j = 0;
            boolean flag = true;
            char[] word = lines[i].toCharArray();
            char pre = '9';

            while (index < reg.length && j < word.length) {
                if (reg[i] == '*') {
                    while (j < word.length) {
                        if (j > 0 && word[j] != word[j - 1]) {
                            break;
                        }
                        j++;
                    }
                } else {
                    pre = word[j++];
                }
                index++;
            }

            if (flag) {
                System.out.print(i + " ");
            }
        }
    }

}
