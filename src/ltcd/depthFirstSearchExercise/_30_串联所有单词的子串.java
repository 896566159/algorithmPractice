package ltcd.depthFirstSearchExercise;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _30_串联所有单词的子串 {

    public List<Integer> findSubstring(String s, String[] words) {

        int count = 0;
        for (String str : words) {
            count += str.length();
        }
        if (count > s.length()) {
            return new LinkedList<>();
        }

        Arrays.sort(words);
        List<Integer> res = new LinkedList<>();
        StringBuffer path = new StringBuffer();
        int len = words.length;
        boolean[] used = new boolean[words.length];

        dfs(words, len, 0, path, res, s, used);

        return res;
    }

    private void dfs(String[] words, int len, int depth, StringBuffer path, List<Integer> res, String s, boolean[] used) {
        if (depth == len) {
            String s1 = path.toString().toString();

            if (s.contains(s1)) {
                int index = 0;
                int length = s1.length();
                String sub = new String(s);

                while (s1.length() <= sub.length() && sub.contains(s1)) {
                    index = index + sub.indexOf(s1);
                    res.add(index);
                    index++;
                    sub = s.substring(index);
                }
            }
            return;
        }

        for (int i = 0; i < len; i++) {
            if (i > 0 && words[i].equals(words[i - 1]) && !used[i - 1]) {
                continue;
            }

            if (!used[i]) {
                path.append(words[i]);
                used[i] = true;

                dfs(words, len, depth + 1, path, res, s, used);

                path.delete(path.length() - words[i].length(), path.length());
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new _30_串联所有单词的子串().findSubstring("foobarfoobarthefoobarman", new String[]{"foo", "bar"}));
    }
}
