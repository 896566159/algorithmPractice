package nowcoder.outd.Y22Q4;

public class _最大矩阵和_ {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{-3, 5, -1, 5}, {2, 4, -2, 4}, {-1, 3, -1, 3}};
        System.out.println(maxSumOfMatrix(matrix));
    }

    private static String maxSumOfMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

            }
        }

        return ans + "";
    }

}
