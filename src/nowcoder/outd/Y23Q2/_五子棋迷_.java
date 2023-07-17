package nowcoder.outd.Y23Q2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 张兵和王武是五子棋迷，工作之余经常切磋棋艺。这不，这会儿又下起来了。走了一会儿，轮张兵了，对着一条线思考起来了，这条线上的棋子分布如下
 * 用数组表示: -1 0 1 1 1 0 1 0 1 1
 * 棋子分布说明:
 * 	1. -1代表白子，0代表空位，1 代表黑子
 * 	2. 数组长度L,满足 1 < L < 40,且L为奇数
 * 	你得帮他写一个程序，算出最有利的出子位置。最有利定义
 * 	1.找到一个空位(0)，用棋子(1/-1)填充该位置，可以使得当前子的最大连续长度变大
 * 	2.如果存在多个位置，返回最靠近中间的较小的那个坐标;
 * 	3.如果不存在可行位置，直接返回-1:
 * 	4.连续长度不能超过5个(五字棋约束)
 *
 * 输入描述:
 * 	第一行: 当前出子颜色
 * 	第二行: 当前的棋局状态
 * 输出描述:
 * 	1个整数，表示出子位置的数组下标
 *
 * 示例1:
 * 	输入:
 * 		1
 * 		-1 0 1 1 1 0 1 0 1 -1 1
 * 	输出:
 * 		5
 * 说明: 当前为黑子 (1)，放置在下标为5的位置，黑子的最大连续长度，可以由3到5
 *
 * 示例2:
 * 	输入:
 * 		-1
 * 		-1 0 1 1 1 0 1 0 1 -1 1
 * 	输出:
 * 		1
 * 说明: 当前为白子，唯一可以放置的位置下标为1，白子的最大长度，由1变为2
 *
 * 示例3:
 * 	输入:
 * 		1
 * 		0 0 0 0 1 0 0 0 0 1 0
 * 	输出:
 * 		5
 * 说明: 可行的位置很多，5最接近中间的位置坐标
 */
public class _五子棋迷_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char color = scanner.nextLine().equals("-1") ? '2' : '1';
        char[] chars = scanner.nextLine().replace(" ", "").replace("-1", "2").toCharArray();
        int n = chars.length;
        int middle = (n - 1) / 2;
        int res = -1;
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (chars[i] == color) {
                int right = i + 1;

                while (right < n && chars[right] == color) {
                    right++;
                }

                int len = right - i;
                // 如果旗子放在 right 指向的位置
                if (right < n && chars[right] == '0') {
                    if (len == max && Math.abs(right - middle) < Math.abs(middle - res)) {
                        // 替换后的字符长度和之前的替换结果相等，且 right 更接近中心位置
                        res = right;
                    } else if (len > max) {
                        // 替换后的字符长度是最长的
                        max = len;
                        res = right;
                    }
                }

                // 如果旗子放在 i - 1 指向的位置
                if (i - 1 >= 0 && chars[i - 1] == '0') {
                    if (len == max && Math.abs(i - 1 - middle) <= Math.abs(middle - res)) {
                        // 替换后的字符长度和之前的替换结果相等，且 right 更接近中心位置
                        res = i - 1;
                    } else if (len > max) {
                        // 替换后的字符长度是最长的
                        max = len;
                        res = i - 1;
                    }
                }

                // 更新 i
                i = right;
            }
        }

        System.out.println(res);
    }
}
