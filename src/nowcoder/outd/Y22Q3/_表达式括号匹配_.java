package nowcoder.outd.Y22Q3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * (1+(2+3)*(3+(8+0))+1-2)这是一个简单的数学表达式，今天不是计算它的值，而是比较它的括号匹配是否正确。
 * 前面这个式子可以简化为(()((()))这样的括号我们认为它是匹配正确的，
 *
 * 而((()这样的我们就说他是错误的。
 * 注意括号里面的表达式可能是错的，也可能有多个空格，对于这些我们是不用去管的，我们只关心括号是否使用正确。
 *
 * 输入描述：
 * 	给出一行表达式(长度不超过100)。
 * 输出描述：
 * 	如果匹配正确输出括号的对数，否则输出-1。
 *
 * 用例：
 * 	输入：
 * 		(1+(2+3)*(3+(8+0))+1-2)
 * 	输出：
 * 		4
 * 	说明：
 * 		无
 */
public class _表达式括号匹配_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        Deque<Character> stack = new ArrayDeque<>();

        int count = 0;
        for (char c : chars) {
            if (c == '(') {
                stack.offer(c);
            } else if (c == ')'){
                // 如果没有左括号与之匹配
                if (stack.isEmpty()) {
                    System.out.println(-1);
                    return;
                }
                count++;
                Character character = stack.pollLast();
                // 如果连续出现两个右括号
                if (character == ')') {
                    System.out.println(-1);
                    return;
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }

}
