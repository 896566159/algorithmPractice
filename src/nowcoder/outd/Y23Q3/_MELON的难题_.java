package nowcoder.outd.Y23Q3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * MELON有一堆精美的雨花石(数量为 n,重量各异),准备送给 S和W。
 * MELON希望送给俩人的雨花石 重量一致，请你设计一个程序，帮MELON确认是否能将雨花石平均分配。
 *
 * 输入描述：
 * 	第1行输入为雨花石个数：n, 0 < n < 31。
 * 	第2行输入为空格分割的各雨花石重量：m[0] m[1]..... m[n-1],0 < m[k] < 1001。不需要考虑异常输入的情况。
 * 输出描述：
 * 	如果可以均分，从当前雨花石中最少拿出几块，可以使两堆的重量相等；
 * 	如果不能均分，则输出-1。
 *
 * 用例1：
 * 	输入：
 * 		4
 * 		1 1 2 2
 * 	输出：
 * 		2
 * 说明：
 * 	输入第一行代表共4颗雨花石，
 * 	第二行代表4颗雨花石重量分别为1、1、2、2。
 * 	均分时只能分别为1,2,需要拿出重量为1和2的两块雨花石，所以输出2。
 * 用例2：
 * 	输入：
 * 		10
 * 		1 1 1 1 1 9 8 3 7 10
 * 	输出：
 * 		3
 * 说明：
 * 	输入第一行代表共10颗雨花石，
 * 	第二行代表4颗雨花石重量分别为1、1、1、1、1、9、8、3、7、10。
 * 	均分时可以1,1,1,1,1,9,7和10,8,3,也可以1,1,1,1,9,8和10,7,3,1,或者其他均分方式，但第一种只需要拿出重量
 * 	为10,8,3的3块雨花石，第二种需要拿出4块，所以输出3(块数最少)。
 */
public class _MELON的难题_ {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] split = scanner.nextLine().split(" ");
        int[] stones = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            stones[i] = Integer.parseInt(split[i]);
            sum += stones[i];
        }

        // 不可以均分为重量相等的两堆石头
        if (sum % 2 != 0) {
            System.out.println(-1);
            return;
        }

        // 排序,
        Arrays.sort(stones);
        // 均分成两堆的重量
        int target = sum / 2;
        boolean avg = false;

        // 拿出去的石头数量：[1, n/2]
        for (int i = 1; i <= n / 2; i++) {
            if (dfs(stones, 0, i, 0, target, new boolean[n])) {
                System.out.println(i);
                avg = true;
                break;
            }
        }

        if (!avg) {
            System.out.println(-1);
        }
    }

    private static boolean dfs(int[] stones, int count, int total, int sum, int target, boolean[] used) {
        // 已经使用的石头数量超出限度
        if (count > total) {
            return false;
        }

        // 凑足了目标重量
        if (sum == target) {
            return true;
        }

        for (int i = 0; i < stones.length; i++) {
            if (!used[i]) {
                used[i] = true;
                if (dfs(stones, count + 1, total, sum + stones[i], target, used)) {
                    return true;
                }
                used[i] = false;
            }
        }

        return false;
    }
}
