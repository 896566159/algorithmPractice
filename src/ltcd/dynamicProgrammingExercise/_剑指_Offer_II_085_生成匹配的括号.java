package ltcd.dynamicProgrammingExercise;

import java.util.LinkedList;
import java.util.List;

public class _剑指_Offer_II_085_生成匹配的括号 {

    public List<String> generateParenthesis(int n) {

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
            }

            dp[i] = str;
        }

        return dp[n];
    }

}
