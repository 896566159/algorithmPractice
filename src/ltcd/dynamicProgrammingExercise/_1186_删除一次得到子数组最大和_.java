package ltcd.dynamicProgrammingExercise;

import java.util.Arrays;

public class _1186_删除一次得到子数组最大和_ {

    public int maximumSum1(int[] arr) {
        int ans = Integer.MIN_VALUE;
        int n = arr.length;
        int[][] f = new int[n + 1][2];

        // 除以 2 防止溢出
        Arrays.fill(f[0], Integer.MIN_VALUE / 2);

        for (int i = 0; i < n; i++) {
            f[i + 1][0] = Math.max(f[i][0], 0) + arr[i];
            f[i + 1][1] = Math.max(f[i][1] + arr[i], f[i][0]);
            ans = Math.max(ans, Math.max(f[i + 1][0], f[i + 1][1]));
        }

        return ans;
    }




    // ------------------------超时-----------------------
    int[] arr;
    int[][] memo;
    public int maximumSum(int[] arr) {
        this.arr = arr;
        int ans = Integer.MIN_VALUE;
        int n = arr.length;
        memo = new int[n][2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, Math.max(dfs(i, 0), dfs(i, 1)));
        }

        return ans;
    }

    /**
     * 子数组的右端点是 arr[i]，j 表示要不要删除子数组中的某个数
     * @param i 右端点的范围
     * @param j 是否必须删除一个数
     * @return
     */
    private int dfs(int i, int j) {
        if (i < 0) {
            // 除以 2 防止负数相加溢出
            return Integer.MIN_VALUE / 2;
        }

        if (memo[i][j] != Integer.MIN_VALUE) {
            // 之前计算过
            return memo[i][j];
        }

        if (j == 0) {
            // 不删除
            return Math.max(dfs(i - 1, 0), 0) + arr[i];
        } else {
            // 删除一个
            return Math.max(dfs(i - 1, 1) + arr[i], dfs(i - 1, 0));
        }
    }

}
