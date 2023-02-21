package ltcd.arrayExercise.matrixExercise;

public class _2319_判断矩阵是否是一个X矩阵 {

    public static void main(String[] args) {
        System.out.println(checkXMatrix(new int[][]{{2, 0, 0, 1}, {0, 3, 1, 0}, {0, 5, 2, 0}, {4, 0, 0, 2}}));
    }

    public static boolean checkXMatrix(int[][] grid) {
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == j || j == n - 1 - i) && grid[i][j] == 0) {
                    return false;
                } else if ((i != j && j != n - 1 - i) && grid[i][j] != 0){
                    return false;
                }
            }
        }

        return true;
    }

}
