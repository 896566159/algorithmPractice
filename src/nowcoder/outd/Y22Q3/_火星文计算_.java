package nowcoder.outd.Y22Q3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * 已知火星人使用的运算符为#、$，其与地球人的等价公式如下：
 * x#y = 2*x+3*y+4
 * x$y = 3*x+y+2
 * 1、其中x、y是无符号整数
 * 2、地球人公式按C语言规则计算
 * 3、火星人公式中，$的优先级高于#，相同的运算符，按从左到右的顺序计算
 * 现有一段火星人的字符串报文，请你来翻译并计算结果。
 *
 * 输入描述：
 * 	火星人字符串表达式（结尾不带回车换行）
 * 	输入的字符串说明：字符串为仅由无符号整数和操作符（#、$）组成的计算表达式。
 * 	例如：123#4$5#67$78。
 * 	用例保证字符串中，操作数与操作符之间没有任何分隔符。
 * 	用例保证操作数取值范围为32位无符号整数。
 * 	保证输入以及计算结果不会出现整型溢出。
 * 	保证输入的字符串为合法的求值报文，例如：123#4$5#67$78
 * 	保证不会出现非法的求值报文，例如类似这样字符串：
 * 	#4$5 //缺少操作数
 * 	4$5# //缺少操作数
 * 	4#$5 //缺少操作数
 * 	4 $5 //有空格
 * 	3+4-5*6/7 //有其它操作符
 * 	12345678987654321$54321 //32位整数计算溢出
 *
 * 输出描述：
 *
 * 根据输入的火星人字符串输出计算结果（结尾不带回车换行）。
 *
 * 示例1：
 * 	输入：
 * 		7#6$5#12
 * 	输出：
 * 		226
 * 说明：
 * 	7#6$5#12
 * 	=7#(3*6+5+2)#12
 * 	=7#25#12
 * 	=(2*7+3*25+4)#12
 * 	=93#12
 * 	=2*93+3*12+4
 * 	=226
 */
public class _火星文计算_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        Deque<Integer> deque = new ArrayDeque<>();
        int n = chars.length;

        // 先处理 $，遇见 $，就计算出结果。其余转换成数字入队，操作符号默认都是 #，所以没有必要保存 #
        for (int i = 0; i < n; i++) {
            char c = chars[i];
            if (c == '$') {
                // 取出运算符号的右操作数
                int y = chars[++i] - '0';
                while (i + 1 < n && chars[i + 1] != '$' && chars[i + 1] != '#') {
                    y = y * 10 + (chars[i + 1] - '0');
                    i++;
                }

                int x = deque.pollLast();
                // x$y = 3*x+y+2
                deque.offerLast(3 * x + y + 2);
            } else if(c != '#') {
                // 取出运算符号的操作数(左右操作数都入栈)
                int tmp = c - '0';
                while (i + 1 < n && chars[i + 1] != '$' && chars[i + 1] != '#') {
                    tmp = tmp * 10 + (chars[i + 1] - '0');
                    i++;
                }
                deque.offerLast(tmp);
            }
        }

        int x = 0;
        // 在处理 #
        if (!deque.isEmpty()) {
            // 第一个数是左操作数
            x = deque.pollFirst();
            while (!deque.isEmpty()) {
                // 取出右操作数，并计算：x#y = 2*x+3*y+4
                Integer y = deque.pollFirst();
                x = 2 * x + 3 * y + 4;
            }
        }
        System.out.println(x);
    }

}
