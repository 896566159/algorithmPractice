package nowcoder.outd.Y22Q3;


import java.util.Scanner;

/**
 * 输入两个字符串 S和L，都只包含英文小写字母。S长度<=100，L长度<=500,000。
 * 判定S是否是L的有效子串。
 *
 * 判定规则：
 * S 中的每个字符在 L 中都能找到（可以不连续），且S在Ｌ中字符的前后顺序与S中顺序要保持一致。
 * （例如，S=”ace”是L=”abcde”的一个子序列且有效字符是a、c、e，而”aec”不是有效子序列，且有效字符只有a、e）
 *
 * 输入描述:
 * 	输入两个字符串S和L，都只包含英文小写字母。S长度 <= 100，L长度 <= 500,000。
 * 	先输入S，再输入L，每个字符串占一行。
 * 输出描述:
 * 	S串最后一个有效字符在L中的位置。（首位从0开始计算，无有效字符返回-1）
 *
 * 示例1：
 * 	输入：
 * 		ace
 * 		abcde
 * 	输出：
 * 		4
 *
 * 示例2：
 * 	输入：
 * 		fgh
 * 		abcde
 * 	输出：
 * 		-1
 */
public class _字符串序列判定_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] s = scanner.nextLine().toCharArray();
        char[] l = scanner.nextLine().toCharArray();
        int n1 = s.length;
        int n2 = l.length;

        // 如果 l 比 s 还短，则 l 无法包含 s 中的所有字母
        if (n2 < n1) {
            System.out.println(-1);
            return;
        }

        int i = 0;
        int j = 0;
        while (i < n1 && j < n2) {
            if (s[i] == l[j]) {
                i++;
            }
            j++;
        }

        if (i < n1) {
            // l 中没有 s[i] 字母
            System.out.println(-1);
        } else {
            // l 顺序含有 s 中所有字母
            System.out.println(j - 1);
        }
    }

}
