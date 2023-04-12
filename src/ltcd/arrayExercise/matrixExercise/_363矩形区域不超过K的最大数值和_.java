package ltcd.arrayExercise.matrixExercise;

public class _363矩形区域不超过K的最大数值和_ {

    /**
     * 利用前缀和求解
     * @param matrix
     * @param limit
     * @return
     */
    public int maxSumSubmatrix(int[][] matrix, int limit) {
        int rows = matrix.length;
        int columns = rows == 0 ? 0 : matrix[0].length;
        // 前缀和，preSum[i][j] 表示以原矩阵的最左上角位置 (0, 0) 到 （i, j) 这个点为对角线的 子矩阵的矩阵和
        int[][] preSum = new int[rows + 1][columns + 1];
        int maxValue = Integer.MIN_VALUE;

        // 初始化 preSum[0][0]~preSum[0][columns] 为0
        for (int i = 0; i <= columns; i++) {
            preSum[0][i] = 0;
        }

        // 初始化 preSum[0][0]~preSum[rows][0] 为0
        for (int i = 0; i <= rows; i++) {
            preSum[i][0] = 0;
        }

        // 遍历matrix，填充preSum
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {
                preSum[i + 1][j + 1] = matrix[i][j] + preSum[i + 1][j] + preSum[i][j + 1] - preSum[i][j];
            }
        }

        // 暴力枚举子矩阵的长和宽
        // 子矩阵的长范围：[1, raws]
        for (int i = 1; i <= rows; i++) {

            // 子矩阵的宽范围：[1, columns]
            for (int j = 1; j <= columns; j++) {

                // 子矩阵的左上角所在的行，取值范围：[0, rows - i]
                for (int k = 0; k <= rows - i; k++) {

                    // 子矩阵的左上角所在的列，取值范围：[0, columns - j]
                    for (int l = 0; l <= columns - j; l++) {
                        // 利用前缀和数组来求解子矩阵的矩阵和
                        // 求 左上角(k, l)、右上角(k, l + j)、左下角(k + i, l)、右下角(k + i, l + j) 四个点围城的的子矩阵的矩阵和
                        int value = preSum[k + i][j + l] - preSum[k][j + l] - preSum[k + i][l] + preSum[k][l];

                        // 返回结果
                        if (value == limit) {
                            return limit;
                        } else if (value < limit) {
                            maxValue = Math.max(maxValue, value);
                        }
                    }
                }
            }
        }

        return maxValue;
    }

}
