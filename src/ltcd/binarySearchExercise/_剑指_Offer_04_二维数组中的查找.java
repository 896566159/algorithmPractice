package ltcd.binarySearchExercise;

public class _剑指_Offer_04_二维数组中的查找 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (target > matrix[matrix.length - 1][matrix[0].length - 1] || target < matrix[0][0]) {
            return false;
        }

        int i = matrix.length - 1;
        int j = 0;

        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else if (matrix[i][j] == target) {
                return true;
            }
        }

        return false;
    }

}
