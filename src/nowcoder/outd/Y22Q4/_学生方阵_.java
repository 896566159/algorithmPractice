package nowcoder.outd.Y22Q4;

import java.util.Scanner;

/**
 * 学校组织活动，将学生排成一个矩形方阵。
 * 请在矩形方阵中找到最大的位置相连的男生数量这个相连位置在一个直线上，方向可以是水平的，垂直的，成对角线的或者呈反对角线的。注: 学生个数不会超过10000
 * 输入描述
 * 输入的第一行为矩阵的行数和列数，接下来的n行为矩阵元素，元素间用””分隔输出描述
 * 输出一个整数，表示矩阵中最长的位置相连的男生个数
 * 示例1 输入输出示例仅供调试，后台判题数据一般不包含示例输入
 * 3,4
 * FM_MF
 * FM_MF
 * FFEM
 * 输出
 * 3
 * 示例2 输入输出示例仅供调试，后台判题数据一般不包含示例
 * 输入
 * 1,2
 * MM
 * 输出
 * 2
 * 示例3 输入输出示例仅供调试，后台判题数据一般不包含示例
 * 输入
 * 2.1
 * M
 * 输出
 */
public class _学生方阵_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        char[][] students = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                String next = scanner.next();
                students[i][j] = next.charAt(0);
            }
        }

//        char[][] students = new char[][]{{'F', 'M', 'M', 'F'}, {'F', 'M', 'M', 'F'}, {'F', 'F', 'F', 'M'}};
        System.out.println(maxLength(students));
    }

    private static String maxLength(char[][] students) {
        int m = students.length;
        int n = students[0].length;
        int ans = 0;

        // 横
        int[][] dp1 = new int[m][n + 1];
        // 竖
        int[][] dp2 = new int[m + 1][n];
        // 对角
        int[][] dp3 = new int[m + 1][n + 1];
        // 反对角
        int[][] dp4 = new int[m + 1][n + 1];

        // 横
        // 每一行
        for (int i = 0; i < m; i++) {

            // 每一列
            for (int j = 1; j <= n; j++) {
                if (students[i][j - 1] == 'M') {
                    dp1[i][j] = Math.max(dp1[i][j - 1] + 1, 1);
                    ans = Math.max(dp1[i][j], ans);
                }
            }
        }

        // 竖
        // 每一行
        for (int i = 1; i <= m; i++) {

            // 每一列
            for (int j = 0; j < n; j++) {
                if (students[i - 1][j] == 'M') {
                    dp2[i][j] = Math.max(dp2[i - 1][j] + 1, 1);
                    ans = Math.max(dp2[i][j], ans);
                }
            }
        }

        // 对角
        // 每一行
        for (int i = 1; i <= m; i++) {

            // 每一列
            for (int j = 1; j <= n; j++) {
                if (students[i - 1][j - 1] == 'M') {
                    dp3[i][j] = Math.max(dp3[i - 1][j - 1] + 1, 1);
                    ans = Math.max(dp3[i][j], ans);
                }
            }
        }

        // 反对角
        // 每一行
        for (int i = 1; i <= m; i++) {

            for (int j = n - 1; j >= 1; j--) {
                if (students[i - 1][j - 1] == 'M') {
                    dp4[i][j] = Math.max(dp4[i - 1][j + 1] + 1, 1);
                    ans = Math.max(dp4[i][j], ans);
                }
            }
        }

        return ans + "";
    }

}
