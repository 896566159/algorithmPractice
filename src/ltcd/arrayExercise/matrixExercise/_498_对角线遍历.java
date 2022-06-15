package ltcd.arrayExercise.matrixExercise;

public class _498_对角线遍历 {

    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[n * m];

        int r = 0;
        int c = 0;

        for (int i = 0; i < n * m; i++) {
            ans[i] = mat[r][c];

            // r + c 即为遍历的层数，偶数向上遍历，奇数向下遍历
            if ((r + c) % 2 == 0) {
                if (c == n - 1) {
                    //往下移动一个，准备向下遍历
                    r++;
                } else if (r == 0) {
                    //往右移动一个，准备向下遍历
                    c++;
                } else {
                    //往右上移动
                    c++;
                    r--;
                }
            } else {
                if (r == m - 1) {
                    //往右移动一个准备向上遍历
                    c++;
                } else if (c == 0) {
                    //往下移动一个准备向上遍历
                    r++;
                } else {
                    //往左下移动
                    r++;
                    c--;
                }
            }
        }

        return ans;
    }

}
