package nowcoder.outd.Y23Q2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 定义当一个字符串只有元音字母(a,e,i,o,u,A,E,I,O,U)组成,
 * 称为元音字符串，现给定一个字符串，请找出其中最长的元音字符串，
 * 并返回其长度，如果找不到请返回0，
 * 字符串中任意一个连续字符组成的子序列称为该字符串的子串
 *
 * 输入描述：
 * 	一个字符串其长度 0 < length ,字符串仅由字符a-z或A-Z组成
 * 输出描述：
 * 	一个整数，表示最长的元音字符子串的长度
 * 示例1：
 * 	输入：
 * 		asdbuiodevauufgh
 * 	输出：
 * 		3
 * 说明：
 *     最长的元音字符子串为uio和auu长度都为3，因此输出3
 */
public class _最长的元音子串长度_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toLowerCase().toCharArray();
        int n = chars.length;
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u') {
                int j = i;
                while (j < n && chars[j] == 'a' || chars[j] == 'e' || chars[j] == 'j' || chars[j] == 'o' || chars[j] == 'u') {
                    j++;
                }
                max = Math.max(max, j - i);
                i = j;
            }
        }

        System.out.println(max);
    }
}
