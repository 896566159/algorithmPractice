package nowcoder.outd.Y22Q4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * 现有一字符串仅由 ‘(‘，’)’，'{‘，’}’，'[‘，’]’六种括号组成。
 * 若字符串满足以下条件之一，则为无效字符串：
 * 	①任一类型的左右括号数量不相等；
 * 	②存在未按正确顺序（先左后右）闭合的括号。
 * 输出括号的最大嵌套深度，若字符串无效则输出0。
 * 0 ≤ 字符串长度 ≤ 100000
 *
 * 输入描述:
 * 	一个只包括 ‘(‘，’)’，'{‘，’}’，'[‘，’]’的字符串
 * 输出描述:
 * 	一个整数，最大的括号深度
 *
 * 示例1:
 * 	输入:
 * 		[]
 * 	输出:
 * 		1
 * 说明: 有效字符串，最大嵌套深度为1
 *
 * 示例2:
 * 	输入:
 * 		([]{()})
 * 	输出:
 * 		3
 * 说明: 有效字符串，最大嵌套深度为3
 *
 * 示例3:
 * 	输入:
 * 		(]
 * 	输出:
 * 		0
 * 说明: 无效字符串，有两种类型的左右括号数量不相等
 *
 * 示例4:
 * 	输入:
 * 		([)]
 * 	输出:
 * 		0
 * 说明: 无效字符串，存在未按正确顺序闭合的括号
 *
 * 示例5:
 * 	输入:
 * 		)(
 * 	输出:
 * 		0
 * 说明: 无效字符串，存在未按正确顺序闭合的括号。
 */
public class _最大括号深度_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        int max = 0;

        for (char c : chars) {
            if (c == ')') {
                // 如果栈顶不是与之匹配的 左括号，则为无效字符串
                if (stack.isEmpty() || stack.pollLast() != '(') {
                    System.out.println(0);
                    return;
                }
            } else if (c == ']') {
                // 如果栈顶不是与之匹配的 左括号，则为无效字符串
                if (stack.isEmpty() || stack.pollLast() != '[') {
                    System.out.println(0);
                    return;
                }
            } else if (c == '}') {
                // 如果栈顶不是与之匹配的 左括号，则为无效字符串
                if (stack.isEmpty() || stack.pollLast() != '{') {
                    System.out.println(0);
                    return;
                }
            } else {
                stack.offerLast(c);
                max = Math.max(max, stack.size());
            }
        }

        // 最后检查是否是有效字符串，是的话输出最深的括号数量
        System.out.println(stack.isEmpty() ? max : 0);
    }

}
