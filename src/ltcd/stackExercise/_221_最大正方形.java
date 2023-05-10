package ltcd.stackExercise;

import java.util.ArrayDeque;
import java.util.Deque;

public class _221_最大正方形 {

    public static void main(String[] args) {
        _221_最大正方形 v = new _221_最大正方形();
        System.out.println(v.maximalSquare(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        // 从上到下的前缀和
        int[][] preSum = new int[m + 1][n + 2];
        int ans = 0;

        // 求解前缀和
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    preSum[i + 1][j + 1] = preSum[i][j + 1] + 1;
                }
            }
        }

        // 利用前缀和求解最大的正方形
        for (int i = 1; i <= m; i++) {
            // 单调递增栈
            Deque<Integer> stack = new ArrayDeque<>();

            for (int j = 0; j <= n + 1; j++) {
                while (!stack.isEmpty() && preSum[i][j] < preSum[i][stack.peek()]) {
                    // 形成矩形的高
                    int height = preSum[i][stack.pop()];
                    // 形成矩形的宽
                    int wide = j - stack.peek() - 1;
                    // 宽和高取最小的，得到正方形
                    int edge = Math.min(height, wide);
                    ans = Math.max(ans, edge * edge);
                }

                // 入栈
                stack.push(j);
            }
        }

        return ans;
    }

}
