package ltcd.depthFirstSearchExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _剑指_Offer_38_字符串的排列 {

    public String[] permutation(String s) {


        char[] chars = s.toCharArray();
        List<String> list = new ArrayList<>();
        StringBuffer path = new StringBuffer();
        boolean[] used = new  boolean[s.length()];

        Arrays.sort(chars);
        bfs(0, chars, used, path, list);

        return list.toArray(new String[list.size()]);
    }

    private void bfs(int depth, char[] chars, boolean[] used, StringBuffer path, List<String> list) {
        if (depth == chars.length) {
            list.add(path.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) {
                continue;
            }

            if (!used[i]) {
                used[i] = true;
                path.append(chars[i]);

                bfs(depth + 1, chars, used, path, list);

                used[i] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        new _剑指_Offer_38_字符串的排列().permutation("abc");
    }

}
