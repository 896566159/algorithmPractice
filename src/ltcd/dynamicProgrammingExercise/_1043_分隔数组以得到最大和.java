package ltcd.dynamicProgrammingExercise;

import java.util.Arrays;

public class _1043_分隔数组以得到最大和 {

    public int maxSumAfterPartitioning1(int[] arr, int k) {
        int n = arr.length;
        int[] f = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int mx = 0;
            for (int j = i; j >= 0 && i - k < j; j--) {
                mx = Math.max(arr[j], mx);
                f[i + 1] = Math.max(f[i + 1], f[j] + (i - j + 1) * mx);
            }
        }

        return f[n];
    }


    // 超时
    private int[] arr, memo;
    private int k;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        this.arr = arr;
        this.k = k;

        memo = new int[arr.length];
        Arrays.fill(memo, -1);
        return dfs(arr.length - 1);
    }

    private int dfs(int i) {
        if (i < 0) {
            return 0;
        }

        // 之前计算过了
        if (memo[i] != -1) {
            return memo[i];
        }

        int res = 0;
        int mx = 0;

        for (int j = i; j >= 0 && i - j > k; j--) {
            mx = Math.max(mx, arr[i]);
            res = Math.max(res, dfs(j - 1) + (i - j + 1) * mx);
        }

        return res;
    }

}
