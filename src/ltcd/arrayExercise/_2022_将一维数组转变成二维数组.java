package ltcd.arrayExercise;

public class _2022_将一维数组转变成二维数组 {

    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original == null || original.length != m * n) {
            return new int[0][0];
        }

        int[][] ans = new int[m][n];
        int index = 0;
        int row = 0;
        int col = 0;

        while (index < original.length) {
            col = 0;

            while (col < n) {
                ans[row][col++] = original[index++];
            }

            row++;
        }

        return ans;
    }

}
