package ltcd.stackExercise;

import java.util.*;

public class _1096_花括号展开II2 {

    public static void main(String[] args) {
        _1096_花括号展开II2 ii = new _1096_花括号展开II2();
//        ii.braceExpansionII(new String("{{a,z},a{b,c},{ab,z}}"));
//        ii.braceExpansionII(new String("{a,b}{c,{d,e}d}"));
//        ii.braceExpansionII(new String("{{a,z},a{b,c},{ab,z}}"));
//        ii.braceExpansionII(new String("k{a,b,c,d,e,f,g}"));
//        ii.braceExpansionII(new String("{a,{x,ia,o},w}"));
//        ii.braceExpansionII(new String("n{g,{u,o}}{a,{x,ia,o},w}"));
//        ii.braceExpansionII(new String("{a,b}c{d,e}f"));
        ii.braceExpansionII(new String("c{d,e}f"));
    }

    public List<String> braceExpansionII(String expression) {
        List<String> res = dfs(expression, 0, expression.length() - 1);
        return new ArrayList<>(res);
    }

    private List<String> dfs(String expression, int start, int end) {
        if (start >= end) {
            return new ArrayList<>();
        }
        List<List<String>> res = new ArrayList<>();

        /**
         * {}xx、xx{}、{}{}	做笛卡尔积
         * ,					并集
         * 一定是字母或者左括号{开头
         * {{a,z},a{b,c},{ab,z}}{g,t}{h,{u,xx}wer}
         * n{g,{u,o}}{a,{x,ia,o},w}
         */
        char startChar = expression.charAt(start);
        if (startChar == '{') {
            // TODO { 开头
            int rightBrace = getRightBrace(expression, start + 1, end);

            if (rightBrace == end) {
                return dfs(expression, start + 1, end - 1);
            }
            List<String> curBrace = dfs(expression, start + 1, rightBrace - 1);

            if (rightBrace + 1 == end) {
                return curBrace;
            } else {

            }

        } else {
            // TODO 字母开头，遇见的第一个非字母一定是:  ①{括号  ②是逗号
            StringBuilder sb = new StringBuilder();

            // 遍历[start, end]
            for (int i = start; i <= end; i++) {
                char cur = expression.charAt(i);

                if (cur == '{') {
                    // 该左括号对应的右括号
                    int rightBrace = getRightBrace(expression, i + 1, end);
                    // 解析该括号中的内容
                    List<String> inner = dfs(expression, i + 1, rightBrace - 1);

                    // 更新下标
                    i = rightBrace;
                } else if (cur == ','){
                    if (!sb.toString().equals("")) {

                    }
                } else {
                    // 遇见字母
                    sb.append(cur);
                    if (i == end) {
                        if (!sb.toString().equals("")) {

                        }
                    }
                }
            }
        }
        
        return null;
    }


    private int getRightBrace(String expression, int start, int end) {
        int level = 1;
        while (start <= end) {
            char c = expression.charAt(start);
            if (c == '{') {
                level++;
            } else if (c == '}') {
                level--;

                if (level == 0) {
                    return start;
                }
            }
            start++;
        }

        return -1;
    }
}