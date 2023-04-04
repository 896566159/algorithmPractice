package ltcd.dynamicProgrammingExercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1092_最短公共超序列 {

    String s;
    String t;
    String[][] dp = null;
    int[][] memo = null;

    /**
     * 在 shortestCommonSupersequence3 的基础上，将 dfs1() 递归修改成循环
     * @param str1
     * @param str2
     * @return
     */
    public String shortestCommonSupersequence(String str1, String str2) {
        // f[i + 1][j + 1]表示 (str1的前i个字母) 和 (str2的前j个字母) 的最短公共子序列的长度
        int n = str1.length();
        int m = str2.length();
        int[][] f = new int[n + 1][m + 1];
        char[] s = str1.toCharArray();
        char[] t = str2.toCharArray();

        // 初始化 f 数组——相当于递归的边界
        for (int i = 1; i <= n; i++) {
            f[i][0] = i;
        }

        // 初始化 f 数组——相当于递归的边界
        for (int i = 0; i <= m; i++) {
            f[0][i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 最短公共字符串一定包含 s[i]
                if (s[i] == t[j]) {
                    f[i + 1][j + 1] = f[i][j] + 1;
                } else {
                    // 取更短的
                    f[i + 1][j + 1] = Math.min(f[i][j + 1], f[i + 1][j]) + 1;
                }
            }
        }

        // str1 和 str2 的最短公共字符串的长度为 f[n][m]
        int len = f[n][m];
        char[] ans = new char[len];

        // 构造最短公共子序列
        for (int i = n - 1, j = m - 1, k = len - 1; ; ) {
            // s 为空，剩余的 t 就是最短公共字符串
            if (i < 0) {
                System.arraycopy(t, 0, ans, 0, j + 1);
                // 相当于递归边界
                break;
            }

            // t 是空串，剩余的 s 就是最短公共字符串
            if (j < 0) {
                System.arraycopy(s, 0, ans, 0, i + 1);
                // 相当于递归边界
                break;
            }

            // 公共字符串一定包含 s[i]
            if (s[i] == t[j]) {
                // 从后往前填充 ans
                ans[k--] = s[i--];
                // 相当于继续递归 makeAns(i - 1, j - 1)
                j--;
            } else if (f[i + 1][j + 1] == f[i][j + 1] + 1) {
                // 相当于继续递归 makeAns(i - 1, j)
                ans[k--] += s[i--];
            } else {
                // 相当于继续递归 makeAns(i, j - 1)
                ans[k--] += t[j--];
            }
        }

        return new String(ans);
    }


    /**
     * shortestCommonSupersequence2在shortestCommonSupersequence1的基础上添加了记忆化搜索，但是还是会超时
     * 超时原因是递归时会把 dfs(i-1,j) 和 dfs(i,j-1) 都走一遍
     *
     * shortestCommonSupersequence3优化：
     * 这里优化，走了 dfs(i-1,j) 就不会走 dfs(i,j-1)
     * @param str1
     * @param str2
     * @return
     */
    public String shortestCommonSupersequence3(String str1, String str2) {
        s = str1;
        t = str2;
        memo = new int[s.length()][t.length()];

        return makeAns(s.length() - 1, t.length() - 1);
    }

    private int dfs1(int i, int j) {
        // s 是空串，返回剩余的 t 的长度
        if (i < 0) {
            return j + 1;
        }

        // t 是空串，返回剩余的 s 的长度
        if (j < 0) {
            return i + 1;
        }

        // 避免重复计算 dfs 的结果
        if (memo[i][j] > 0) {
            return memo[i][j];
        }

        return memo[i][j] = Math.min(dfs1(i - 1, j), dfs1(i, j - 1)) + 1;
    }

    // makeAns(i, j) 返回 (s 的前 i 个字母) 和 (t 的前 j 个字母) 的最短公共字符串
    // 看上去和 dfs 没有区别，但是末尾的递归是 if-else
    // makeAns(i - 1, j) 和 makeAns(i, j - 1) 不会都被调用
    // 所以 makeAns 的递归树仅仅是一条链
    private String makeAns(int i, int j) {
        // s 是空的，返回 t
        if (i < 0) {
            return t.substring(0, j + 1);
        }

        // t 是空的，返回 s
        if (j < 0) {
            return s.substring(0, i + 1);
        }

        // 最短公共字符串一定包含 s[i]
        if (s.charAt(i) == t.charAt(j)) {
            return makeAns(i - j, j - 1) + s.charAt(i);
        }

        // 如果下面的 if 成立，说明上面 dfs 中的 min 取的是 dfs(i - 1, j)
        // 说明 dfs(i - 1, j) 对应的公共超序列更短
        // 那么就在 makeAns(i - 1, j) 的结果后面加上 s[i]
        // 否则说明 dfs(i, j - 1) 对应的公共超序列更短
        // 那么就在 makeAns(i, j - 1) 的结果后面加上 t[j]
        if (dfs1(i, j) == dfs1(i - 1, j) + 1) {
            return makeAns(i - 1, j) + s.charAt(i);
        }

        return makeAns(i, j - 1) + t.charAt(j);
    }


    /**
     * 原理和下面的shortestCommonSupersequence1(String str1, String str2)一样，但是增加了记忆化搜索
     * @param str1
     * @param str2
     * @return
     */
    public String shortestCommonSupersequence2(String str1, String str2) {
        s = str1;
        t = str2;
        dp = new String[s.length()][t.length()];

        dfs(s.length() - 1, t.length() - 1);

        return dp[s.length() - 1][t.length() - 1];
    }

    // dfs(i, j) 的返回结果是： (s 的前 i 个字母) 和 (t 的前 j 个字母) 组成的最短公共子序列
    private String dfs(int i, int j) {
        // s 是空串，返回剩余的 t
        if (i < 0) {
            return t.substring(0, j + 1);
        }

        // t 是空串，返回剩余的 s
        if (j < 0) {
            return s.substring(0, i + 1);
        }

        // 如果 dp[i][j] 已经被计算/搜索过，则直接返回
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        // 如果 s 和 t 的最后一个字母相同
        if (s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = dfs(i - 1, j - 1) + s.charAt(i);
        }

        // 到这里说明 s 和 t 的最后一个字母不相同
        String ans1 = dfs(i - 1, j);
        String ans2 = dfs(i, j - 1);

        // 取 ans1 和 ans2 中更短的组成答案
        dp[i][j] = ans1.length() > ans2.length() ? ans2 + t.charAt(j) : ans1 + s.charAt(i);

        return dp[i][j];
    }


    /**
     * 递归超时
     * 考虑从后往前开始构造最短的公共字符串。str1 的最后一个字母是 x， str2 的最后一个字母是 y
     * 如果 x = y，则最短的公共字符串就是寻找出 (str1 去掉 x) 和 (str2 去掉 y) 的最短公共字符串——递归 shortestCommonSupersequence1(String str1 - x, String str2 - y)
     * 如果 x != y, 则最断的公共字符串则是：
     *      ① (str1 去掉 x) 和 (str2) 的最短公共字符串——递归 shortestCommonSupersequence1(String str1 - x, String str2)
     *      ② (str1) 和 (str2 去掉 y) 的最短公共字符串——递归 shortestCommonSupersequence1(String str1, String str2 - y)
     *      ① 和 ② 中的最短的那个字符串
     * @param str1
     * @param str2
     * @return
     */
    public String shortestCommonSupersequence1(String str1, String str2) {
        // str1 是空字符串，返回剩余的 str2
        if (str1.isEmpty()) {
            return str2;
        }

        // str2 是空字符串，返回剩余的 str1
        if (str2.isEmpty()) {
            return str1;
        }

        String s1 = str1.substring(0, str1.length() - 1);
        String s2 = str2.substring(0, str2.length() - 1);

        char x = str1.charAt(str1.length() - 1);
        char y = str2.charAt(str2.length() - 1);

        // 最短公共序列一定包含 x
        if (x == y) {
            return shortestCommonSupersequence1(s1, s2) + x;
        }

        String ans1 = shortestCommonSupersequence1(s1, str2);
        String ans2 = shortestCommonSupersequence1(str1, s2);

        if (ans1.length() < ans2.length()) {
            return ans1 + x;
        }

        return ans2 + y;
    }


}
