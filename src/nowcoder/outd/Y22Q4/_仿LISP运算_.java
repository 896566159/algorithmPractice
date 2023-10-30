package nowcoder.outd.Y22Q4;

import java.util.Scanner;
import java.util.Stack;

/**
 * LISPQ 语言唯一的语法就是括号要配对。形如(OP P1 P2 ...)，括号内元素由单个空格分割。其中第一个元素 OP 为操作符，后续元素均为其参数，参数个数取决于操作符类型。注意:
 * 参数 P1,P2 也有可能是另外一个嵌套的 (OP P1 P2 ...)当前 OP 类型为 add / sub / mulQ / div (全小写)，分别代表整数的加减乘除法简单起见，所有 OP 参数个数均为 2
 * 举例:
 * 输入: (mul 3 -7)
 * 输出: -21
 * 输入: (add 1 2)
 * 输出: 3
 * 输入: (sub (mul 2 4) (div 9 3)
 * 输出: 5
 * 输入: (div 1 0)
 * 输出: error
 * 题目涉及数字均为整数，可能为负:
 * 不考虑 32 位溢出翻转，计算过程中也不会发生 32 位溢出翻转除零错误时，输出“error”，
 * 除法遇除不尽，向下取整，即 3/2 = 1
 */
public class _仿LISP运算_ {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Stri ng remain = scanner.nextLine();
        String remain = "(sub (mul 2 4) (div 9 3))";


        // 递归在这里做，每次jiexikuohao都是计算表达式中嵌套最深的一层
        while (remain.contains("(")) {
            remain = jiexikuohao(remain);
            System.out.println(remain);
        }
        System.out.println(remain);

        // 使用栈来做
//        String s = stackParse(remain);
//        System.out.println(s);

        // 递归版本
//            String exp = "(sub (mul 2 4) (div 9 3))";
////        String exp = "(div 1 0)";
//
//            char[] chars = exp.toCharArray();
//            int res = parseExp(chars);
//            System.out.println(res == Integer.MAX_VALUE ? "error" : res);
    }

    /**
     * 遇见左括号和空格跳过，遇见字符串（操作符号或者参数）入栈
     * 遇见右括号，弹出栈顶三个元素进行运算，结果入栈。
     * 最后栈中只有最终的结果
     * @param remain
     * @return
     */
    private static String stackParse(String remain) {
        Stack<String> stack = new Stack<>();

        int pos = 0;
        int length = remain.length();
        while (pos < length) {

            if (remain.charAt(pos) == ')') {
                if (stack.size() == 1 && pos == length - 1) {
                    return stack.pop();
                }

                // 出栈，计算
                int p2 = Integer.parseInt(stack.pop());
                int p1 = Integer.parseInt(stack.pop());
                String op = stack.pop();

                switch (op) {
                    case "add":
                        stack.push((p1 + p2) + "");
                        break;
                    case "sub":
                        stack.push((p1 - p2) + "");
                        break;
                    case "mul":
                        stack.push((p1 * p2) + "");
                        break;
                    case "div":
                        if (p2 == 0) {
                            stack.push(Integer.MAX_VALUE + "");
                        }
                        stack.push((p1 / p2) + "");
                        break;
                    default:
                        break;
                }
                pos++;
            } else {
                // 跳过空格和左括号
                while (pos < length && (remain.charAt(pos) == ' ' || remain.charAt(pos) == '(')) {
                    pos++;
                }

                // 入栈
                int start = pos;
                while (pos < length && remain.charAt(pos) != ' ' && remain.charAt(pos) != '(' && remain.charAt(pos) != ')') {
                    pos++;
                }
                stack.push(remain.substring(start, pos));
            }
        }

        return stack.pop();
    }

    private static String jiexikuohao(String remain) {
        char[] chars = remain.toCharArray();
        int zuokuoind = 0;
        int youkuoind = 0;
        for (int i = 0; i < chars.length; i++) {
            //取最右的左括号
            if (chars[i] == '(') {
                zuokuoind = i;
            }
            //取最左的右括号
            if (chars[i] == ')') {
                youkuoind = i;
                break;
            }
        }
        //嵌套最深的括号内 先算
        String substring1 = remain.substring(zuokuoind + 1, youkuoind);
        String[] s1 = substring1.split(" ");
        String ope = s1[0];
        int zuocanshu = Integer.parseInt(s1[1]);
        int youcanshu = Integer.parseInt(s1[2]);
        String kuohaores = "";
        switch (ope) {
            case "add":
                kuohaores = (zuocanshu + youcanshu) + "";
                break;
            case "sub":
                kuohaores = (zuocanshu - youcanshu) + "";
                break;
            case "mul":
                kuohaores = (zuocanshu * youcanshu) + "";
                break;
            case "div":
                if (youcanshu == 0) {
                    kuohaores = "ERROR";
                } else {
                    kuohaores = (zuocanshu / youcanshu) + "";
                }
                break;
        }
        String newStr = remain.substring(0, zuokuoind) + kuohaores + remain.substring(youkuoind + 1, remain.length());
        return newStr;
    }


//    static int index = 0;
//    private static int parseExp(char[] exp) {
//        int length = exp.length;
//
//        // 从index开始
//        // 如果当前是左括号，则 后面开始到空格为止 一定是运算符
//        if (exp[index] == '(') {
//            // 从括号下一位开始解析运算符
//            index++;
//
//            String op = "";
//            // 到空格为止，是运算符
//            while (index < length && exp[index] != ' ') {
//                op += exp[index];
//                index++;
//            }
//
//            // 空格后，紧接着是两个操作数，但是可能这两个操作数都是嵌套的运算表达式
//            index++;
//            int p1 = 0;
//            int p2 = 0;
//            // 操作数是嵌套表达式
//            if (exp[index] == '(') {
//                p1 = parseExp(exp);
//
//                while (index < length && (exp[index] == ')' || exp[index] == ' ')) {
//                    index++;
//                }
//                p2 = parseExp(exp);
//            } else {
//                // 操作数直接是数字
//                p1 = parseExp(exp);
//                p2 = parseExp(exp);
//            }
//
//            int ans = Integer.MAX_VALUE;
//            if (op.equals("add")) {
//                ans = p1 + p2;
//            } else if (op.equals("sub")) {
//                ans = p1 - p2;
//            } else if (op.equals("mul")) {
//                ans = p1 * p2;
//            } else if (op.equals("div")) {
//                if (p2 == 0) {
//                    return Integer.MAX_VALUE;
//                }
//                ans = p1 / p2;
//            }
//            return ans;
//        } else {
//            // 当前是空格，则 后面到空格或者)为止：是数字
//            // 从括号下一位开始解析运算符
//            if (exp[index] == ' ') {
//                index++;
//            }
//
//            // 符号
//            String value = "";
//            if (exp[index] == '-') {
//                value = "-";
//                index++;
//            }
//
//            while (index < length && exp[index] != ' ' && Character.isDigit(exp[index])) {
//                value += exp[index];
//                index++;
//            }
//
//            // 返回操作数
//            return Integer.parseInt(value);
//        }
//    }

}
