package ltcd.backtrackingExecise;

import java.util.HashSet;
import java.util.Set;

public class _940_不同的子序列_II {

    public static void main(String[] args) {
        System.out.println(distinctSubseqII("pcrdhwdxmqdznbenhwjsenjhvulyve"));
    }

    public static int distinctSubseqII1(String s) {
        int mod = (int) 1e9 + 7;
        int n = s.length();

        //之前新增的个数
        int[] preCount = new int[26];
        int curAns = 1;
        char[] chs = s.toCharArray();

        for (int i = 0; i < n; i++) {
            //新增的个数
            int newCount = curAns;
            //当前序列的个数 = 之前的 + 新增的 - 重复的
            curAns = ((curAns + newCount) % mod - preCount[chs[i] - 'a'] % mod + mod) % mod;
            //记录当前字符的 新增值
            preCount[chs[i] - 'a'] = newCount;
        }

        //减去空串
        return (curAns - 1 + mod) % mod;
    }

    //递归超时
    public static int distinctSubseqII(String s) {
        Set<String> set = new HashSet<>();

        char[] chars = s.toCharArray();
        char[] path = new char[chars.length];
        boolean[] used = new boolean[chars.length];
        dfs(chars, 0, set, used, path, 0);

        return set.size();
    }

    private static void dfs(char[] chars, int len, Set<String> set, boolean[] used, char[] path, int preIdx) {
        if (len == chars.length) {
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (!used[i] && i >= preIdx) {
                used[i] = true;
                path[len] = chars[i];

                if (!set.contains(new String(path))) {
                    set.add(new String(path));
                }
                dfs(chars, len + 1, set, used, path, i);
                path[len] = '\0';

                used[i] = false;
            }
        }

    }

}
