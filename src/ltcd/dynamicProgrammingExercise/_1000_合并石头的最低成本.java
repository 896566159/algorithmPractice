package ltcd.dynamicProgrammingExercise;

import java.util.Arrays;

public class _1000_合并石头的最低成本 {

    public static void main(String[] args) {
        _1000_合并石头的最低成本 v = new _1000_合并石头的最低成本();
        v.mergeStones(new int[] {6,4,4,6}, 2);
    }

    int[][][] dp;
    int[] preSum;
    int k;

    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        // 无法合成一堆
        if ((n - 1) % (k - 1) != 0) {
            return -1;
        }

        // 前缀和
        preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + stones[i];
        }

        this.k = k;
        dp = new int[n][n][k + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 负一表示还没有计算过
                Arrays.fill(dp[i][j], -1);
            }
        }

        return dfs(0, n - 1, 1);
    }

    /**
     * [i, j]区间的所有堆合并成 p 堆所需要的代价
     * @param i 左边界
     * @param j 右边界
     * @param p 合成的目标堆数量
     * @return
     */
    private int dfs(int i, int j, int p) {
        // 已经计算过
        if (dp[i][j][p] != -1) {
            return dp[i][j][p];
        }

        // 合并成一堆
        if (p == 1) {
            // [i, j]区间合并成 1堆 的代价 = 数组stones在[i, j]区间的元素和
            return dp[i][j][p] = i == j ? 0 : dfs(i, j, k) + preSum[j + 1] - preSum[i];
        }

        int res = Integer.MAX_VALUE;
        // 枚举那些石头堆合成第一堆
        for (int m = i; m < j; m += k - 1) {
            res = Math.min(res, dfs(i, m, 1) + dfs(m + 1, j, p - 1));
        }

        return dp[i][j][p] = res;
    }

    // {6,4,4,6}, k = 2 时，不是最优解
    public int mergeStones1(int[] stones, int k) {
        int length = stones.length;
        boolean[] used = new boolean[stones.length];
        int ans = 0;
        int unmerge = length;

        // 只要没有被合并的个数大于等于 k ，则循环
        while (unmerge >= k) {
            // 从 [left, length) 区间中寻找 连续k个数[left, right]之和 最小的区间
            int left = 0;
            // left 区间应该是没有被用过的
            while (used[left]) {
                left++;
            }


            int right =  left;
            // sum 用于记录 连续k个数之和
            int sum = 0;
            int minSum = Integer.MAX_VALUE;
            int count = k;

            while (right < length) {

                // 如果当前数已经被使用过了，则跳过
                if (used[right]) {
                    right++;
                    continue;
                }

                // [left, right] 区间中的个数已经满足 k
                if (count == 1) {
                    sum = sum + stones[right];
                    minSum = Math.min(sum, minSum);
                    sum -= stones[left];

                    // 求下一个 [left, right]区间的和，左边界应该从一个没有被使用过的数开始
                    if (!used[left]) {
                        left++;
                    } else {
                        // 找到第一个没有被使用过的左边界
                        while (used[left] && left < length) {
                            left++;
                        }
                    }

                } else {
                    // [left, right] 区间中的个数 < k, 累加和
                    sum += stones[right];
                    count--;
                }
                right++;
            }

            left = 0;
            // [left, right] 区间应该是没有被用过的
            while (used[left]) {
                left++;
            }
            right = left;
            sum = 0;
            count = k;

            while (right < length) {
                // 如果当前数已经被使用过了，则跳过
                if (used[right]) {
                    right++;
                    continue;
                }

                // [left, right] 区间中的个数已经满足 k
                if (count == 1) {
                    sum = sum + stones[right];

                    // [left, right] 区间中的个数已经满足 k,并且区间和是最小的
                    if (sum == minSum) {
                        // 将 [left, right]区间合并，并将值赋给 stones[right]
                        while (left < right) {
                            used[left] = true;
                            left++;
                        }
                        stones[left] = sum;

                        ans += sum;
                        unmerge -= k - 1;
                        break;
                    } else {
                        sum -= stones[left];
                        left++;
                    }
                } else {
                    // [left, right] 区间中的个数 < k,累加和
                    sum += stones[right];
                    count--;
                }
                right++;
            }
        }

        if (unmerge != 1) {
            return -1;
        }

        return ans;
    }

}
