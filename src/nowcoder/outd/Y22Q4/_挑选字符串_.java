package nowcoder.outd.Y22Q4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 给定a-z，26个英文字母小写字符串组成的字符串A和B，
 * 其中A可能存在重复字母，B不会存在重复字母，现从字符串A中按规则挑选一些字母可以组成字符串B
 * 挑选规则如下：
 *         1：同一个位置的字母只能挑选一次，
 *         2：被挑选字母的相对先后顺序不能被改变，
 * 求最多可以同时从A中挑选多少组能组成B的字符串
 * 输入描述：
 * 	输入为2行，
 * 	第一行输入字符串a,第二行输入字符串b，行首行尾没有多余空格
 * 输出描述：
 * 	输出一行
 * 	包含一个数字表示最多可以同时从a中挑选多少组能组成b的字符串，行末没有多余空格
 *
 * 示例一：
 * 	输入：
 * 		badc
 * 		bac
 * 	输出：
 * 		1
 *
 * 示例二：
 * 	输入：
 * 		badc
 * 		abc
 * 	输出：
 * 	0
 *
 * 示例三：
 * 	输入：
 * 		bbadcac
 * 		bac
 * 	输出：
 * 		2
 */
public class _挑选字符串_ {

    public static void main(String[] args) {
        //处理输入
        Scanner scanner = new Scanner(System.in);
        char[] charsA = scanner.nextLine().toCharArray();
        char[] charsB = scanner.nextLine().toCharArray();
        int[] countB = new int[26];
        int[] countA = new int[26];

        // 分别统计 A B 中字母的次数
        int lenA = charsA.length;
        int lenB = charsB.length;


        // 看 A 中能够组成几组 B
        int count = 0;
        while (true) {

            int index = 0;
            for (int i = 0; i < lenA; i++) {
                if (charsA[i] == charsB[index]) {
                    // 将已经被使用的字母替换掉
                    charsA[i] = '#';
                    index++;

                    // 如果 B 中的字母都被扫描一遍，说明匹配到了，数量 + 1
                    if (index == lenB) {
                        count++;
                        break;
                    }
                }
            }

            // 如果 B 中的字母没有被扫描完
            if (index < lenB) {
                break;
            }
        }

        System.out.println(count);
    }

}
