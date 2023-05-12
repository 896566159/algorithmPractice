package ltcd.stackExercise;

import java.util.*;

public class _1096_花括号展开II {

    public static void main(String[] args) {
        _1096_花括号展开II ii = new _1096_花括号展开II();
//        ii.braceExpansionII(new String("{{a,z},a{b,c},{ab,z}}"));
//        ii.braceExpansionII(new String("{a,b}{c,{d,e}d}"));
//        ii.braceExpansionII(new String("{{a,z},a{b,c},{ab,z}}"));
//        ii.braceExpansionII(new String("k{a,b,c,d,e,f,g}"));
//        ii.braceExpansionII(new String("{a,{x,ia,o},w}"));
//        ii.braceExpansionII(new String("n{g,{u,o}}{a,{x,ia,o},w}"));
        ii.braceExpansionII(new String("{a,b}c{d,e}f"));
    }

    //n{g,{u,o}}{a,{x,ia,o},w}
    public List<String> braceExpansionII(String expression) {
        List<String> res = dfs2(expression, 0, expression.length() - 1);
        Set<String> set = new TreeSet<>();
        for (String s : res) {
            set.add(s);
        }
        return new ArrayList<>(set);
    }


    /**
     * {}xx、xx{}、{}{}	做笛卡尔积
     * ,					并集
     */
    private List<String> dfs2(String expression, int start, int end) {
        List<String> res = new ArrayList<>();
        if (start >= end) {
            return res;
        }

        char startChar = expression.charAt(start);
        if (startChar == '{') {
            int level = 1;

            // 遍历区间 [start + 1, end]
            int i = start + 1;
            for (; i <= end; i++) {
                char c = expression.charAt(i);
                if (c == '{') {
                    level++;
                } else if (c == '}') {
                    level--;
                    if (level == 0) {
                        break;
                    }
                }
            }

            // 扫描完完整的{}，看他的后面是字母、还是另一个{}、还是，
            if (i == end) {
                return  dfs2(expression, start + 1, i - 1);
            }
            List<String> left = dfs2(expression, start + 1, i - 1);

            if (i + 1 < end) {
                char nextChar = expression.charAt(i + 1);

                if (nextChar == ',') {
                    // {},{} 或者 {}，zbc    两块做并集
                    List<String> right = dfs2(expression, i + 2, end);
                    return union(left, right);
                } else {
                    List<String> right = dfs2(expression, i + 1, end);
                    // {}{}、{}xxxx  这两种类型都要做乘积
                    return merge(left, right);
                }
            } else {
                return left;
            }
        } else {
            // 以字母开头的，可能的类型：    ①zbc{...} ②z,cb
            int i = start;
            StringBuilder sb = new StringBuilder();
            for (; i <= end; i++) {
                char c = expression.charAt(i);

                if (c == '{') {
                    // 这种是字母和花括号做乘积
                    int j = i + 1;
                    int level = 1;

                    for (; j <= end; j++) {
                        if (expression.charAt(j) == '}') {
                            level--;

                            if (level == 0) {
                                break;
                            }
                        } else if (expression.charAt(j) == '{') {
                            level++;
                        }
                    }

                    // 遍历完完整的 abc{}
                    List<String> mid = dfs2(expression, i + 1, j - 1);

                    // 防止出现花括号前后都有字母 zcb{}zbc
                    int k = j + 1;
                    //n{g,u,o}{a,{x,ia,o},w}
                    // if (k <= end && expression.charAt(k) != '{' && expression.charAt(k) != ',' && expression.charAt(k) != '}') {
                    if (k <= end && expression.charAt(k) == ',') {
                        i = j - 1;
                        // 只有 zbc{...},两块做乘积
                        res.addAll(merge(sb, mid));
                    } else {
                        for (; k <= end; k++) {
                            if (expression.charAt(k) == '{') {
                                level++;
                            } else if (expression.charAt(k) == '}') {
                                level--;
                            } else if (expression.charAt(k) == ',' && level == 0) {
                                break;
                            }
                        }
                        List<String> right = dfs2(expression, j + 1, k - 1);

                        i = k - 1;
                        // zbc{...}zbc  三块做乘积
                        res.addAll(merge(sb, mid, right));
                    }
                } else if (c == ',') {
                    if (!sb.toString().isEmpty()) {
                        res.add(new String(sb));
                        sb = new StringBuilder();
                    }
                } else {
                    // 字母，添加到StringBuilder中
                    sb.append(c);
                    if (i == end) {
                        res.add(new String(sb));
                    }
                }
            }
        }

        return res;
    }

    private List<String> union(List<String> left, List<String> right) {
        Set<String> set = new TreeSet<>(left);

        for (int i = 0; i < right.size(); i++) {
            set.add(right.get(i));
        }

        return new ArrayList<>(set);
    }

    private List<String> merge(List<String> left, List<String> right) {
        Set<String> set = new TreeSet<>();

        for (int i = 0; i < left.size(); i++) {
            for (int j = 0; j < right.size(); j++) {
                set.add(left.get(i) + right.get(j));
            }
        }

        return new ArrayList<>(set);
    }

    private List<String> merge(StringBuilder sb, List<String> right) {
        Set<String> set = new TreeSet<>();

        for (int j = 0; j < right.size(); j++) {
            StringBuilder tmp = new StringBuilder(sb);
            set.add(tmp.append(right.get(j)).toString());
        }

        return new ArrayList<>(set);
    }

    private List<String> merge(StringBuilder sb, List<String> mid, List<String> right) {
        Set<String> set = new TreeSet<>();
        if (mid.isEmpty()) {
            for (int i = 0; i < right.size(); i++) {
                StringBuilder tmp = new StringBuilder(sb);
                set.add(tmp.append(right.get(i)).toString());
            }
            return new ArrayList<>(set);
        }

        if (right.isEmpty()) {
            for (int i = 0; i < mid.size(); i++) {
                StringBuilder tmp = new StringBuilder(sb);
                set.add(tmp.append(mid.get(i)).toString());
            }
            return new ArrayList<>(set);
        }

        for (int i = 0; i < mid.size(); i++) {
            for (int j = 0; j < right.size(); j++) {
                StringBuilder tmp = new StringBuilder(sb);
                set.add(tmp.append(mid.get(i)).append(right.get(j)).toString());
            }
        }

        return new ArrayList<>(set);
    }


    /***************************************************下面的版本未成功*******************************************************/

//    public List<String> braceExpansionII1(String expression) {
//        List<String> res = new ArrayList<>();
//
//        Set<String> parse = dfs(expression, 0);
//        Iterator<String> iterator = parse.iterator();
//        while (iterator.hasNext()) {
//            String s = iterator.next();
//            System.out.println(s);
//            res.add(s);
//        }
//
//        return res;
//    }
//
//    private Set<String> dfs(String expression, int index) {
//        if (index >= expression.length()) {
//            return new TreeSet<>();
//        }
//
//        Set<String> res = new TreeSet<>();
//        for (int i = index; i < expression.length(); i++) {
//            char c = expression.charAt(i);
//
//            if (c == '{') {
//                if ((i - 1 > 0 && expression.charAt(i - 1) == '}')) {
//                    // 发生了嵌套
//                    Set<String> inner = dfs(expression, i + 1);
//                    while (i < expression.length() && expression.charAt(i) != '}') {
//                        i++;
//                    }
//                    res = union(res, inner);
//                } else {
//                    // 往右遍历找到第一个 }
//                    int idx = i + 1;
//                    while (expression.charAt(idx) != '{' && expression.charAt(idx) != '}') {
//                        idx++;
//                    }
//
//                    if (expression.charAt(idx) == '{') {
//                        // 发生了嵌套
//                        Set<String> inner = dfs(expression, idx + 1);
//                        while (i < expression.length() && expression.charAt(i) != '}') {
//                            i++;
//                        }
//                        res = union(res, inner);
//                    } else {
//                        // 成功匹配到一对 {}
//                        String substring = expression.substring(i + 1, idx);
//                        String[] split = substring.split(",");
//                        if (idx + 1 < expression.length() && expression.charAt(idx + 1) != '{' && expression.charAt(idx + 1) != ',' && expression.charAt(idx + 1) != '}') {
//                            // 括号后面有字母 {....}xxx
//                            int tmpIdx = idx + 1;
//                            while (tmpIdx < expression.length() && expression.charAt(tmpIdx) != '{' && expression.charAt(tmpIdx) != '}' && expression.charAt(tmpIdx) != ',') {
//                                tmpIdx++;
//                            }
//
//                            // {} 括号中的内容与括号外的字母组合
//                            String rightStr = expression.substring(idx + 1, tmpIdx);
//                            for (String s : split) {
//                                res.add(s + rightStr);
//                            }
//                            i = tmpIdx;
//                        } else {
//                            for (String s : split) {
//                                res.add(s);
//                            }
//                            i = idx;
//                        }
//                    }
//                }
//            } else if (c == ',') {
//                continue;
//            } else if (c == '}') {
//                char pre = expression.charAt(i - 1);
//
//                if (pre == '{') {
//                    // 匹配到一对空的花括号 {}
//                    return new TreeSet<>();
//                } else if (pre == '}') {
//                    // 匹配到连续的 }}
//                    return res;
//                } else {
//                    // 只可能匹配到一个或者多个字母，不可能匹配到 ,}
//                    return res;
//                }
//            } else {
//                int idx = i;
//                if (idx >= 0 && expression.charAt(idx) != '}') {
//                    while (idx < expression.length() && expression.charAt(idx) != '{' && expression.charAt(idx) != '}' && expression.charAt(idx) != ',') {
//                        idx++;
//                    }
//                    i = idx;
//                    continue;
//                }
//
//                while (idx < expression.length() && expression.charAt(idx) != '{' && expression.charAt(idx) != '}' && expression.charAt(idx) != ',') {
//                    idx++;
//                }
//                if (expression.charAt(idx) == '{') {
//                    // 发生嵌套
//                    Set<String> tmp = new TreeSet<>();
//                    tmp.add(expression.substring(i, idx));
//
//                    Set<String> inner = dfs(expression, idx + 1);
//                    while (idx < expression.length() && expression.charAt(idx) != '}') {
//                        idx++;
//                    }
//                    idx++;
//                    tmp = union(tmp, inner);
//                    res.addAll(tmp);
//                } else if (expression.charAt(idx) == '}') {
//                    res.add(expression.substring(i, idx));
//                    return res;
//                } else {
//                    // 逗号
//                    res.add(expression.substring(i, idx));
//                }
//                i = idx - 1;
//
//            }
//        }
//
//        return res;
//    }
//
//    private Set<String> union(Set<String> res, Set<String> inner) {
//        if (res.isEmpty()) {
//            return inner;
//        }
//
//        if (inner.isEmpty()) {
//            return res;
//        }
//
//        Set<String> tmp = new TreeSet<>(res);
//
//        res = new TreeSet<>();
//        Iterator<String> outerIterator = tmp.iterator();
//        while (outerIterator.hasNext()) {
//            String inn = outerIterator.next();
//            Iterator<String> innerIterator = inner.iterator();
//            while (innerIterator.hasNext()) {
//                String out = innerIterator.next();
//                res.add(inn + out);
//            }
//        }
//        return res;
//    }
}
