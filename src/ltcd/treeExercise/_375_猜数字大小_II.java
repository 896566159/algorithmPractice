package ltcd.treeExercise;

public class _375_猜数字大小_II {

    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];  //区间[l, r]的最优目标值
        for (int len = 2; len <= n; len++) {  //枚举区间长度
            for (int l = 1; l + (len - 1) <= n; l++) {  //枚举区间左端点
                int r = l + (len - 1);
                int ans = 0xfffff;
                for (int mid = l; mid < r; mid++) {  //枚举区间分割点
                    ans = Math.min(ans, mid + Math.max(dp[l][mid - 1], dp[mid + 1][r]));
                }
                dp[l][r] = ans;
            }
        }
        return dp[1][n];
    }

}
