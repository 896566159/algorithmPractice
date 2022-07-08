package ltcd.arrayExercise.matrixExercise;

import java.util.ArrayList;
import java.util.List;

public class _54_螺旋矩阵 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int n = matrix[0].length;
        int m = matrix.length;
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        int count = 0;

        while (true) {

            //left to right
            for (int j = left; j <= right && count < m * n; j++, count++) {
                ans.add(matrix[top][j]);
            }
            top++;

            //top to botoom
            for (int j = top; j <= bottom && count < m * n; j++, count++) {
                ans.add(matrix[j][right]);
            }
            right--;

            //right to left
            for (int j = right; j >= left && count < m * n; j--, count++) {
                ans.add(matrix[bottom][j]);
            }
            bottom--;

            //bottom to top
            for (int j = bottom; j >= top && count < m * n; j--, count++) {
                ans.add(matrix[j][left]);
            }
            left++;

            if (count == m * n) {
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        new _54_螺旋矩阵().spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }

}
