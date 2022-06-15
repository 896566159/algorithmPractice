package ltcd.dynamicProgrammingExercise;

public class _730_统计不同回文子序列 {



    public int countPalindromicSubsequences(String s) {
        int mod = 1000000007;
        int length = s.length();
        //dp[i][j] 表示从 [i, j] 内回文串的序列
        int[][] dp = new int[length][length];
        char[] chars = s.toCharArray();

        //单个字符串是一个回文序列
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }

        //长度为 2 开始统计
        for (int len = 2; len <= length; len++) {
            //依次计算长度为 len 的子串的回文序列个数
            for (int i = 0; i + len <= length; i++) {
                int j = len + i - 1;

                //情况一： chars[i] == chars[j]
                if (chars[i] == chars[j]) {
                    //找出 dp[i-1, j-1]
                    int left = i + 1;
                    int right = j - 1;

                    //找到第一个与 s[i] 相同的字符
                    while (left <= right && chars[i] != chars[left]) {
                        left++;
                    }

                    //找到第一个与 s[j] 相同的字符
                    while (left <= right && chars[j] != chars[right]) {
                        right--;
                    }

                    if (left > right) {//情况① ：chars中[i+1, j-1]范围内，没有重复的字符串
                        dp[i][j] = 2 * dp[i + 1][j - 1] + 2;
                    } else if (left == right) {//情况② ：chars中[i+1, j-1]有一个字符和chars[i]相同： chars[j] = chars[i] = chars[left]
                        dp[i][j] = 2 * dp[i + 1][j - 1] + 1;
                    } else { //情况③：chars中[i+1, j-1]有两个字符和chars[i]相同： chars[j] = chars[i] = chars[left]
                        dp[i][j] = 2 * dp[i + 1][j - 1] - dp[left + 1][right - 1];
                    }
                } else {//情况二： chars[i] != chars[j]
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                }
                //处理超范围结果
                dp[i][j] = (dp[i][j] >= 0) ? dp[i][j] % mod : dp[i][j] + mod;
            }
        }

        return dp[0][length - 1];
    }

}
