package ltcd.arrayExercise.matrixExercise;

public class _面试题_0107_旋转矩阵 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        //正对角线对称，对换
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        //沿着对称轴，对换
        int mid = n >> 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mid; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
    }

}
