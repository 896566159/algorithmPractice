package ltcd.arrayExercise.matrixExercise;

import java.util.ArrayList;
import java.util.List;

public class _面试题_0108_零矩阵 {

    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    list.add(i, j);//记录下为 0 的点
                }
            }
        }

        int size = list.size();
        for (int i = 0; i < size; i++) {
            int row = list.get(i);
            int col = list.get(i++);

            //同行清零
            for (int k = 0; k < cols; k++) {
                matrix[row][k] = 0;
            }

            //同列清零
            for (int k = 0; k < rows; k++) {
                matrix[k][col] = 0;
            }
        }

    }

}
