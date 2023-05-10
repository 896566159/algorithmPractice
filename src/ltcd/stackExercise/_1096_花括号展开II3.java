package ltcd.stackExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class _1096_花括号展开II3 {

    public static void main(String[] args) {
        _1096_花括号展开II3 ii = new _1096_花括号展开II3();
//        ii.braceExpansionII(new String("{{a,z},a{b,c},{ab,z}}"));
//        ii.braceExpansionII(new String("{a,b}{c,{d,e}d}"));
//        ii.braceExpansionII(new String("{{a,z},a{b,c},{ab,z}}"));
//        ii.braceExpansionII(new String("k{a,b,c,d,e,f,g}"));
//        ii.braceExpansionII(new String("{a,{x,ia,o},w}"));
        ii.braceExpansionII(new String("{{{c,g},{h,j},l}{a,{x,ia,o},w}{x,ia,o},{x,ia,o},a}"));
//        ii.braceExpansionII(new String("n{g,{u,o}}{a,{x,ia,o},w}"));
//        ii.braceExpansionII(new String("{a,b}c{d,e}f"));
//        ii.braceExpansionII(new String("c{d,e}f"));
    }

    String expression;
    public List<String> braceExpansionII(String expression) {
        this.expression = expression;
        List<String> res = dfs(0, expression.length() - 1);
        // 因为解析的结果是逗号前后结果合并，所以没有去重、没有排序，利用Treeset去重排序后返回结果
        Set<String> tmp = new TreeSet<>(res);
        return new ArrayList<>(tmp);
    }

    // 解析[start, end]区间的字符。不管有没有括号，最后的结果一定是 相加。  逗号出现，则需要将 (逗号之前解析出来的结果) 和 (逗号之后未解析的结果) 相加
    private List<String> dfs(int start, int end) {
        if (start > end) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();
        // 遍历区间 [start, end]： 寻找逗号，解析逗号之前的结果。
        int begin = start;
        while (begin <= end) {

            // 初始化当前的层级为0，出现{则层级++，出现}层级--
            int level = 0;
            int leftBrace = -1;
            int rightBrace = -1;
            int i = begin;
            while (i <= end) {
                char c = expression.charAt(i);

                if (c == ',' && level == 0) {
                    // 找到第一个逗号，跳出循环
                    break;
                } else if (c == '{') {
                    level++;
                    if (level == 1 && leftBrace == -1) {
                        leftBrace = i;
                    }
                } else if (c == '}') {
                    level--;
                    if (level == 0 && rightBrace == -1) {
                        rightBrace = i;
                    }
                }
                i++;
            }

            // 解析区间[begin, i]中的内容，分两类：该区间中是否有{}
            if (leftBrace == -1 && rightBrace == -1) {
                // TODO [begin, i]区间中没有括号，说明[begin, i]之间都是字母，直接截取之后添加到结果集中
                res.add(expression.substring(begin, i));
            } else {
                // TODO [begin, i]区间中有括号，需要解析括号中的内容，且解析玩括内的内容后将其和括号外的字符串相乘: ①abc{x,y,z}   ②abc{x,y,z}def
                // TODO 即将[begin, i]区间拆分成三部分，花括号左边 [being, leftBrace - 1] 、花括号中[leftBrace + 1, rightBrace - 1], 花括号右边：[rightBrace + 1, i]
                // 花括号左边的字符串
                List<String> left = dfs(begin, leftBrace - 1);
                // 花括号中解析出的内容
                List<String> mid = dfs(leftBrace + 1, rightBrace - 1);
                // 花括号右边的字符串——注意这里的 end 参数，需要判断边界，不能超过边界 end
                List<String> right = dfs(rightBrace + 1, i - 1 > end ? end : i - 1);

                // 有顺序要求：先将 (左边的字符串)和(括号内的) 相乘，在将得到乘积结果和 (右边的字符串) 相乘
                List<String> leftMulMid = merge(left, mid);
                res.addAll(merge(leftMulMid, right));
            }

            // 更新循环变量，跳过逗号，寻找下一个逗号
            begin = i + 1;
        }

        return res;
    }

    // 合并(相乘)两个集合
    private List<String> merge(List<String> left, List<String> right) {
        // 如果结果中有一个是空的，返回另外一个
        if (left.isEmpty() || right.isEmpty()) {
            return left.isEmpty() ? right : left;
        }

        Set<String> set = new TreeSet<>();

        for (int i = 0; i < left.size(); i++) {
            for (int j = 0; j < right.size(); j++) {
                set.add(left.get(i) + right.get(j));
            }
        }

        return new ArrayList<>(set);
    }
}