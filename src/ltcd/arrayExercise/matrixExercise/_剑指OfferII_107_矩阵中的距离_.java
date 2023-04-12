package ltcd.arrayExercise.matrixExercise;

public class _剑指OfferII_107_矩阵中的距离_ {

    public static void main(String[] args) {
        _剑指OfferII_107_矩阵中的距离_ v = new _剑指OfferII_107_矩阵中的距离_();
        v.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}});
    }

    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int columns = rows == 0 ? 0 : mat[0].length;

        int[][] ans = new int[rows][columns];
        int[][] dp1 = new int[rows + 1][columns + 1];
        int[][] dp2 = new int[rows + 1][columns + 1];

        // 从上往下填写dp
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                if (mat[i][j] == 0) {
                    dp1[i + 1][j + 1] = 0;
                } else {
                    // 从上或者左边的最小
                    if (i > 1) {
                        dp1[i + 1][j + 1] = Math.min(dp1[i + 1][j], dp1[i][j + 1]) + 1;
                    } else {
                        dp1[i + 1][j + 1] = dp1[i][j] + 1;
                    }
                }
            }
        }

        // 从下往上填写dp
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = columns - 1; j >= 0; j--) {
                if (mat[i][j] == 0) {
                    dp2[i][j] = 0;
                } else {
                    // 从下或者右边的最小
                    dp2[i][j] = Math.min(dp2[i + 1][j + 1], dp2[i][j + 1]) + 1;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == 0) {
                    ans[i][j] = dp2[i][j];
                } else if (i == rows - 1) {
                    ans[i][j] = dp1[i + 1][j + 1];
                } else {
                    ans[i][j] = Math.min(dp1[i + 1][j + 1], dp2[i][j]);
                }
            }
        }

        return ans;
    }

}
