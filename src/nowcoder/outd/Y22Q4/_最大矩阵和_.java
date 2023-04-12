package nowcoder.outd.Y22Q4;

public class _最大矩阵和_ {

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{{-3, 5, -1, 5}, {2, 4, -2, 4}, {-1, 3, -1, 3}};
        int[][] matrix = new int[][]{{2, 2, -1}};
//        int[][] matrix = new int[][]{{0, -2, -7, 0}, {9, 2, -6, 2}, {-4, 1, -4, 1}, {-1, 8, 0, -2}};
        System.out.println(maxSumOfMatrix1(matrix));
    }

    private static String maxSumOfMatrix1(int[][] matrix) {
        int rows = matrix.length;
        int columns = rows == 0 ? 0 : matrix[0].length;
        // 前缀和，preSum[i][j] 表示 第j列 从0到j 的前缀和
        int[][] preSum = new int[rows + 1][columns];
        int maxValue = Integer.MIN_VALUE;

        // 初始化前缀和
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                preSum[i + 1][j] = matrix[i][j] + preSum[i][j];
            }
        }

        // 暴力枚举所有子矩阵
        // 子矩阵的行数，取值范围是：[1, rows]
        for (int i = 1; i <= rows; i++) {

            // 子矩阵的第一行，取值范围是第 [0, rows - i] 行
            for (int j = 0; j <= rows - i; j++) {

                // 最后一行： j + i
                int[] arr = new int[columns];
                for (int k = 0; k < columns; k++) {
                    arr[k] = preSum[j + i][k] - preSum[j][k];
                }

                int value = maxSumOfArray(arr);
                maxValue = Math.max(maxValue, value);
            }
        }

        return maxValue + "";
    }

    private static String maxSumOfMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxSum = 0;
        // 二维数组前缀和：记录 从左上角的定点到该点围成的矩阵的和
        int[][] preSum = new int[m + 1][n + 1];

        // 初始化前缀和的第一列都为0
        for (int i = 0; i < m; i++) {
            preSum[i][0] = 0;
        }

        // 初始化前缀和的第一行都为0
        for (int i = 0; i < n; i++) {
            preSum[0][i] = 0;
        }

        // 遍历原矩阵，填充前缀和
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                preSum[i + 1][j + 1] = matrix[i][j] + preSum[i + 1][j] + preSum[i][j + 1] - preSum[i][j];
            }
        }

        // 暴力枚举
        // i 表示枚举的矩阵行数——矩阵的行数取值范围是[1, m]
        for (int i = 1; i <= m; i++) {

            // j 表示枚举的矩形列数——矩阵的列数取值范围是[1, n]
            for (int j = 1; j <= n; j++) {

                // 固定了矩阵的长和宽后，开始在合法的范围列枚举矩阵
                // 长度为 i 的子矩阵的行可取值范围：[0, m-1]
                for (int k = 0; k <= m - i; k++) {

                    // 宽度为 j 的子矩阵的列数取值范围：[0, n - 1]
                    for (int l = 0; l <= n - j; l++) {

                        // 利用前缀和求解 左上角(k, l)、右上角(k, l + j)、左下角(k + i, j)、右下角(k + i, l + j) 形成的矩阵和
                        int value = preSum[k + i][l + j] - preSum[k + i][l] - preSum[k][l + j] + preSum[k][l];
                        maxSum = Math.max(maxSum, value);
                    }
                }
            }
        }

        return maxSum + "";
    }

    // 暴力枚举
    private static String maxSumOfMatrix2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxSum = 0;

        // 暴力枚举
        // i 表示枚举的矩阵行数——矩阵的行数取值范围是[1, m]
        for (int i = 1; i <= m; i++) {
            // j 表示枚举的矩阵列数——矩阵的列数取值范围是[1, n]
            for (int j = 1; j <= n; j++) {

                // 合法的 i 的取值范围
                for (int k = 0; k <= m - i; k++) {

                    // 合法的 j 的取值范围
                    for (int l = 0; l <= n - j; l++) {

                        // 求矩阵 i * j 规模的和
                        int sum = 0;

                        // 行从 k 开始，到 k + i 结束
                        for (int o = k; o < k + i; o++) {
                            // 列从 l 开始，到 j + l 结束
                            for (int p = l; p < l + j; p++) {
                                int value = matrix[o][p];
                                sum += value;
                            }
                        }

                        // 到此，求解出一个规模为 i*j的矩阵。检查当前矩阵是否是最优解
                        maxSum = Math.max(maxSum, sum);
                    }
                }
            }
        }

        return maxSum + "";
    }

    private static int maxSumOfArray(int[] result) {
        int max = result[0];

        for (int i = 1; i < result.length; i++) {
            result[i] = Math.max(result[i - 1] + result[i], result[i]);
            max = Math.max(max, result[i]);
        }

        return max;
    }

    /**
     * 求数组 arr 的和最大的连续子数组
     *
     * @param arr
     * @return
     */
    private static int maxSubArray(int[] arr) {
        int length = arr.length;
        int max = arr[0];

        for (int i = 1; i < length; i++) {
            max = Math.max(max, arr[i] + max);
        }

        return max;
    }

}
