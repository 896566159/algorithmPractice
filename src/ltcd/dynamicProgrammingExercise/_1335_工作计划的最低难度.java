package ltcd.dynamicProgrammingExercise;

import java.util.Arrays;

public class _1335_工作计划的最低难度 {

    int[] a;
    int[][] memo;

    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) {
            return -1;
        }

        a = jobDifficulty;
        memo = new int[d][a.length];

        for (int i = 0; i < a.length; i++) {
            Arrays.fill(memo[i], -1);
        }

        return dfs(d - 1, a.length - 1);
    }

    private int dfs(int i, int j) {
        // 之前计算过了
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // 只有一天，必须完成所有工作
        if (i == 0) {
            int mx = 0;
            for (int k = 0; k <= j; k++) {
                mx = Math.max(mx, a[k]);
            }
            return memo[i][j] = mx;
        }

        int res = Integer.MAX_VALUE;
        int mx = 0;

        for (int k = j; k >= i; k--) {
            // 从 a[k] 到 a[j] 的最大值
            mx = Math.max(mx, a[k]);
            res = Math.min(res, dfs(i - 1, k - 1) + mx);
        }

        return memo[i][j] = res;
    }

}
