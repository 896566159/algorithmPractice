package ltcd.backtrackingExecise;

public class _87_扰乱字符串 {

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        if (s1.equals(s2)) {
            return true;
        }

        return dfs(s1, 0, s1.length() - 1, s2);
    }

    private boolean dfs(String s1, int start, int end, String s2) {
        if (start >= end) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }

        for (int i = start + 1; i <= end; i++) {
            String left = s1.substring(start, i);
            String right = s1.substring(i, end + 1);

            if (s2.equals(right + left) || dfs(s1, start, i, s2) || dfs(right + left, start, i, s2)) {
                return true;
            }

        }

        return false;
    }

}
