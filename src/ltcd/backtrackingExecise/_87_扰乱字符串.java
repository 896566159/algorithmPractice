package ltcd.backtrackingExecise;

public class _87_扰乱字符串 {

    public static void main(String[] args) {
//        System.out.println(new _87_扰乱字符串().isScramble("great", "rgeat"));
//        System.out.println(new _87_扰乱字符串().isScramble("abca", "caba"));
//        System.out.println(new _87_扰乱字符串().isScramble("abcd", "adcb"));
        System.out.println(new _87_扰乱字符串().isScramble("abcd", "badc"));
//        System.out.println(new _87_扰乱字符串().isScramble("ab", "ba"));
//        System.out.println(new _87_扰乱字符串().isScramble("abcde", "caebd"));
    }

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        if (s1.equals(s2)) {
            return true;
        }

        return dfs("", s1, "", 0, s1.length(), s2);
    }

    private boolean dfs(String pre, String mid, String suf, int start, int end, String s2) {
        if (start > end) {
            return false;
        }

        if ((pre + mid + suf).equals(s2) || (mid + pre + suf).equals(s2)) {
            return true;
        }

        // 只能 对mid 切割 [start, end) 之间
        for (int i = start + 1; i < end; i++) {
            String left = mid.substring(start, i + 1);
            String right = mid.substring(i, end);

            if ((pre + left + right + suf).equals(s2) || (pre + right + left + suf).equals(s2)) {
                return true;
            }

            if (pre == "" || suf == "") {
                if (pre.equals("") && dfs(right, left, suf, 0, left.length(), s2)) {
                    return true;
                }

                if (suf.equals("") && dfs(pre, right, left, 0, right.length(), s2)) {
                    return true;
                }
            } else {
                if (dfs(pre, left, right + suf, 0, left.length(), s2)
                        || dfs(pre + left, right, suf, 0, right.length(), s2)) {
                    return true;
                }
            }
        }

        return false;
    }


}
