package ltcd.arrayExercise.matrixExercise;

public class _59_螺旋矩阵II {

    public int[][] generateMatrix(int n) {

        int[][] ans = new int[n][n];
        int num = 1;
        int left = 0;
        int right = n;
        int top = 0;
        int bottom = n;

        while (num <= n * n) {

            //left to right
            for (int i = left; i < right && num <= n * n; i++) {
                ans[top][i] = num++;
            }
            top++;

            //top to bottom
            for (int i = top; i < bottom && num <= n * n; i++) {
                ans[i][right - 1] = num++;
            }
            right--;

            //right to left
            for (int i = right - 1; i >= left && num <= n * n; i--) {
                ans[bottom - 1][i] = num++;
            }
            bottom--;

            //bottom to top
            for (int i = bottom - 1; i >= top && num <= n * n; i--) {
                ans[i][left] = num++;
            }
            left++;
        }

        return ans;
    }


    public static void main(String[] args) {
        new _59_螺旋矩阵II().generateMatrix(3);
    }
}
