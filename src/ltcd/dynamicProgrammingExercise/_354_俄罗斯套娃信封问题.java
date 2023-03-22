package ltcd.dynamicProgrammingExercise;

import java.util.Arrays;

public class _354_俄罗斯套娃信封问题 {

    public static void main(String[] args) {
        _354_俄罗斯套娃信封问题 v = new _354_俄罗斯套娃信封问题();
        System.out.println(v.maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
    }

    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, (a, b) -> {
            return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
        });

        int[] dp = new int[envelopes.length];
        dp[0] = 1;
        int max = 0;

        for (int i = 1; i < envelopes.length; i++) {
            // 如果已经遍历过和当前信封长度相同的信封，则到 envelopes[i] 和 到envelopes[i - 1]能够套娃的信封数量是相同的
            if (envelopes[i][0] == envelopes[i - 1][0]) {
                dp[i] = dp[i - 1];
                continue;
            }


            int pre = 0;

            for (int j = 0; j < i; j++) {
                // 首先，已经按照信封的长度进行了排序，故一定存在： envelopes[j][0] < envelopes[i][0]
                if (envelopes[j][1] < envelopes[i][1]) {
                    pre = Math.max(pre, dp[j]);
                }
            }

            // 填写 dp[i]，并且更新返回值
            dp[i] = pre + 1;
            max = Math.max(max, dp[i]);
        }

        return max;
    }

}
