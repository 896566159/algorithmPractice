package ltcd.backtrackingExecise;

import java.util.HashSet;
import java.util.Set;

public class _1079_活字印刷_ {

    public static void main(String[] args) {
        new _1079_活字印刷_().numTilePossibilities("AAB");
    }

    Set<String> set = new HashSet<>();
    public int numTilePossibilities(String tiles) {

        boolean[] used = new boolean[tiles.length()];
        char[] chars = tiles.toCharArray();
        StringBuilder sb = new StringBuilder();

        dfs(used, chars, 0, sb);

        return set.size();
    }

    private void dfs(boolean[] used, char[] chars, int i, StringBuilder sb) {
        if (i == chars.length) {
            return;
        }

        for (int j = 0; j < chars.length; j++) {
            if (!used[j]) {
                used[j] = true;
                sb.append(chars[j]);
                set.add(sb.toString());

                dfs(used, chars, i + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
                used[j] = false;
            }
        }
    }

}
