package ltcd.dynamicProgrammingExercise;

import java.util.LinkedList;
import java.util.List;

public class _22_括号生成 {

    public List<String> generateParenthesis1(int n) {
        List<String>[] dp = new List[n + 1];
        List<String> dp0 = new LinkedList<>();
        dp0.add("");
        dp[0] = dp0;

        for (int i = 1; i <= n; i++) {
            List<String> str = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                int k = i - 1 - j;
                List<String> str1 = dp[j];
                List<String> str2 = dp[k];

                for (String s1: str1) {
                    for (String s2: str2) {
                        str.add("(" + s1 + ")" + s2);
                    }
                }

                dp[i] = str;
            }
        }

        return dp[n];
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        recur(ans, n, n, "");
        return ans;
    }

    private void recur(List<String> ans, int left, int right, String str) {
        if (left == 0 && right == 0) {//if left parenthesis and right parenthesis have been used finish
            ans.add(str);
            return;
        }

        if (right < left) {//it's impossible that right parenthesis's number greater than the left
            return;
        }

        if (left < 0) {//if left parenthesis have been used finish, right not, it's impossible
            return;
        }

        recur(ans, left - 1, right, str + "(");
        recur(ans, left, right - 1, str + ")");
    }

}
