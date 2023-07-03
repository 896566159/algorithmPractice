package nowcoder.outd.Y22Q4;

import java.util.Scanner;

/**
 * 给一块 n*m 的地块，相当于 n*m 的二维数组，每个元素的值表示这个小地块的发电量；求在这块地上建立边长为 c 的正方形的发电站，发电量满足目标电量 k 的地块数量。
 * 输入描述：
 * 	第一行为四个按空格分隔的正整数，分别表示n, m , c k
 * 	后面n行整数，表示每个地块的发电量
 * 输出描述：
 * 	输出满足条件的地块数量
 * 示例：
 * 	输入：
 * 		2 5 2 6   // n m c k，下面每行是n*m地块每格的发电量
 * 		1 3 4 5 8
 * 		2 3 6 7 1
 * 	输出：
 * 		4
 * 说明：
 * 	满足条件的地块有以下几种
 * 	第一种：
 * 	1 3
 * 	2 3
 * 	第二种：
 * 	3 4
 * 	3 6
 * 	第三种：
 * 	4 5
 * 	6 7
 * 	第四种：
 * 	5 8
 * 	7 1
 */
public class _探索地块建立_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int c = Integer.parseInt(split[2]);
        int k = Integer.parseInt(split[3]);
        int[][] nums = new int[n][m];
        int ans = 0;

        // 初始化矩阵
        for (int i = 0; i < n; i++) {
            split = scanner.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                nums[i][j] = Integer.parseInt(split[j]);
            }
        }

        // 不能围城边长为 c 的正方形
        if (c > n || c > m) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i <= n - c; i++) {
            int block = 0;
            for (int x = 0; x < i + c; x++) {
                for (int y = 0; y < c; y++) {
                    block += nums[x][y];
                }
            }

            ans += block >= k ? 1 : 0;
            for (int j = 0; j <= m - c; j++) {
                if (j == 0) {
                    continue;
                }

                // 减去第一列，加上新的一列
                for (int l = 0; l < c; l++) {
                    block -= nums[l][j - 1];
                    block += nums[l][j + c - 1];
                }

                ans += block >= k ? 1 : 0;
            }
        }

        System.out.println(ans);
    }

}
