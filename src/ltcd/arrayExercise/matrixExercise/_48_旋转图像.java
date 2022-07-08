package ltcd.arrayExercise.matrixExercise;

public class _48_旋转图像 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        //左右两边对调
        int left = 0;
        int right = n - 1;

        while (left < right) {
            for (int i = 0; i < n; i++) {
                int tmp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = tmp;
            }
            left++;
            right--;
        }

        //按照/中心轴对称交换
        int i = 0;

        while (i < n) {

            int end = n - i;
            for (int j = 0; j < end; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][n - i - 1];
                matrix[n - j - 1][n - i - 1] = tmp;
            }
            i++;
        }
    }

}
