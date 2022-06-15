package ltcd.preSum;

public class _304_二维区域和检索_矩阵不可变 {

    int[][] preSum = null;

    public static void main(String[] args) {
        new _304_二维区域和检索_矩阵不可变(new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}});

    }

    public _304_二维区域和检索_矩阵不可变(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        preSum = new int[rows + 1][cols + 1];

        //第一行初始化为0
        for (int i = 0; i < cols; i++) {
            preSum[0][i] = 0;
        }

        //第一列初始化为0
        for (int i = 0; i < cols; i++) {
            preSum[i][0] = 0;
        }

        //从第一行开始处理
        for (int i = 0; i < rows; i++) {

            //从第一列开始处理
            for (int j = 0; j < cols; j++) {
                preSum[i + 1][j + 1] = matrix[i][j] + preSum[i + 1][j] + preSum[i][j + 1] - preSum[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2 + 1][col2 + 1] - preSum[row2 + 1][col1 + 1] - preSum[row1 + 1][col2 + 1] + preSum[row1][col1];
    }

}
