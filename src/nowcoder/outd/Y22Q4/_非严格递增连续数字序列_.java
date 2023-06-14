package nowcoder.outd.Y22Q4;

import java.util.Scanner;

/**
 * 题目描述：
 *  输入一个字符串仅包含大小写字母和数字，求字符串中包含的 最长的非严格递增连续数字序列的长度（比如 12234 属于非严格递增连续数字序列）。
 * 输入描述:
 *  输入一个字符串仅包含大小写字母和数字，输入的字符串最大不超过255个字符。
 * 输出描述：
 *  最长的非严格递增连续数字序列的长度
 * 示例1：
 *  输入:
 *      abc2234019A334bc
 *  输出:
 *      4
 * 说明：2234为最长的非严格递增连续数字序列，所以长度为4
 * 测试用例：
 * aaaaaa44ko543j123j7345677781
 * -->  34567778
 * aaaaa34567778a44ko543j123j71
 * -->  34567778
 *     34567778
 * 345678a44ko543j123j7134567778aa
 * -->  134567778
 */
public class _非严格递增连续数字序列_ {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] chars = s.toCharArray();

        int maxLen = 0;
        int maxLeft = 0;
        int maxRgiht = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] > '0' && chars[i] < '9') {
                // 上一个递减的位置
                int preDes = i;
                int j = i + 1;

                while (j < chars.length && chars[j] > '0' && chars[j] < '9') {
                    if (chars[j] < chars[j - 1]) {
                        preDes = j;
                    } else if (chars[j] == chars[j - 1]) {
                        // 出现非严格递增，往右找到第一个递减的下标
                        int tmp = j + 1;
                        while (tmp < chars.length && chars[tmp] > '0' && chars[tmp] < '9') {
                            if (tmp < chars.length && chars[tmp - 1] > chars[tmp]) {
                                break;
                            }
                            tmp++;
                        }

                        // 求这一段非严格递增序列的长度
                        int len = tmp - preDes + 1;
                        if (len > maxLen) {
                            maxLen = len;
                            maxLeft = preDes;
                            maxRgiht = tmp;
                        }

                        j= tmp;
                    }
                    j++;
                }

                i = j;
            }
        }

        System.out.println(s.substring(maxLeft, maxRgiht));
    }

}
