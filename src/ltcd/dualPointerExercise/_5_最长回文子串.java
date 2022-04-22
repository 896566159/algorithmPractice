package ltcd.dualPointerExercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _5_最长回文子串 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        if (s.length() == 1) {
            return s;
        }

        int max = 0;
        int start = 0;
        char[] chars = s.toCharArray();
        int len = chars.length;

        boolean[][] dp = new boolean[len][len];

        //初始化，将单个字母的地方都标记为true
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - 1 && j < i; j++) {
                if (chars[i] != chars[j]) {
                    continue;
                } else {
                    if (i - j < 3) {// "a" "aa" "axa"
                        dp[j][i] = true;
                    } else {
                        dp[j][i] = dp[j + 1][i - 1];
                    }
                }

                if (dp[j][i] && i - j > max) {
                    max = i - j;
                    start = j;
                }
            }
        }

        return s.substring(start ,start + max + 1);
    }
}
