package ltcd.arrayExercise.matrixExercise;

public class _240_搜索二维矩阵_II {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix[0][0] > target) {
            return false;
        }
        
        return help(matrix, 0, 0, target);
    }

    private static boolean help(int[][] matrix, int abscissa, int ordinate, int target) {
        if (abscissa >= matrix.length || ordinate >= matrix[0].length) {
            return false;
        }

        if (matrix[abscissa][ordinate] == target) {
            return true;
        }

        if (abscissa + 1 < matrix.length && ordinate + 1 < matrix[0].length && matrix[abscissa + 1][ordinate + 1] <= target) {
            return help(matrix, abscissa+1, ordinate+1, target);
        }

        return help(matrix, abscissa+1, ordinate, target) || help(matrix, abscissa, ordinate+1, target);
    }

    public static boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix[0][0] > target) {
            return false;
        }
        System.out.println();
        int x = 0, y = 0;
        while (x < matrix.length) {
            while (y < matrix[0].length) {
                if (target == matrix[x][y]) {
                    return true;
                }
                if (matrix[x][y] > target) {
                    break;
                }
                y++;
            }
            x++;
            y=0;
        }
        
        return false;
    }


    public static void main(String[] args) {
        searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 30);
    }
}
