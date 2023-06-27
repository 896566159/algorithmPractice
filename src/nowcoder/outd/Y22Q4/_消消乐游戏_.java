package nowcoder.outd.Y22Q4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

/**
 * 游戏规则：输入一个只包含英文字母的字符串，字符串中的两个字母如果相邻且相同，就可以消除。
 * 在字符串上反复执行消除的动作，直到无法继续消除为止，此时游戏结束。
 * 输出最终得到的字符串长度。
 * 输入描述:
 * 	输入原始字符串 str ，只能包含大小写英文字母，字母的大小写敏感， str 长度不超过100。
 * 输出描述:
 * 	输出游戏结束后，最终得到的字符串长度。
 *
 * 示例1：
 * 	输入：
 * 		gg
 * 	输出：
 * 		0
 * 说明：
 * 	gg 可以直接消除，得到空串，长度为0。
 *
 * 示例2：
 * 	输入：
 * 		mMbccbc
 * 	输出：
 * 		3
 *
 * 说明：
 * 	在 mMbccbc 中，可以先消除 cc ；
 * 	此时字符串变成 mMbbc ，可以再消除 bb ；
 * 	此时字符串变成 mMc ，此时没有相邻且相同的字符，无法继续消除。
 * 	最终得到的字符串为 mMc ，长度为3
 * 备注:
 * 	输入中包含 非大小写英文字母时，均为异常输入，直接返回 0。
 */
public class _消消乐游戏_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char[] chars = line.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();

        int n = chars.length;
        for (int i = 0; i < n; i++) {
            // 检查是否出现非大小写的英文字母
            if (!(chars[i] > 'A' && chars[i] < 'Z') && !(chars[i] > 'a' && chars[i] < 'z')) {
                System.out.println(0);
                return;
            }

            // 栈顶字母与当前字母相同
            if (!stack.isEmpty() && stack.peekLast() == chars[i]) {
                stack.pollLast();
            } else {
                // 入栈
                stack.offerLast(chars[i]);
            }
        }

        System.out.println(stack.size());
    }

}
