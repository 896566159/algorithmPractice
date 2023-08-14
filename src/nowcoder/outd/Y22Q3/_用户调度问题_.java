package nowcoder.outd.Y22Q3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 在通信系统中，一个常见的问题是对用户进行不同策略的调度，会得到不同的系统消耗和性能。
 * 假设当前有n个待串行调度用户，每个用户可以使用A/B/C三种不同的调度策略，不同的策略会消耗不同的系统资源。
 * 请你根据如下规则进行用户调度，并返回总的消耗资源数。
 * 规则：
 * 1.相邻的用户不能使用相同的调度策略，例如，第1个用户使用了A策略，则第2个用户只能使用B或者C策略。
 * 2.对单个用户而言，不同的调度策略对系统资源的消耗可以归一化后抽象为数值。例如，某用户分别使用A/B/C策略的系统消耗分别为15/8/17。
 * 3.每个用户依次选择当前所能选择的对系统资源消耗最少的策略（局部最优），如果有多个满足要求的策略，选最后一个。
 * 备注: 所有策略对系统的资源消耗均为正整数，n < 1000
 *
 * 输入描述:
 * 	第一行表示用户个数n
 * 	接下来每一行表示一个用户分别使用三个策略的系统消耗resA resB resC
 * 输出描述:
 * 	最优策略组合下的总的系统资源消耗数
 *
 * 示例1:
 * 	输入:
 * 		3
 * 		15 8 17
 * 		12 20 9
 * 		11 7 5
 * 	输出:
 * 		24
 * 说明:
 * 	1号用户使用B策略，2号用户使用C策略，3号用户使用B策略。系统资源消耗: 8 + 9 + 7 = 24。
 */
public class _用户调度问题_ {

    static int min = Integer.MAX_VALUE;
    static int[][] plans;
    static boolean[][] used;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        plans = new int[n][3];
        used = new boolean[n][3];

        for (int i = 0; i < n; i++) {
            plans[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dfs(0, 0, -1);
        System.out.println(min);
    }

    // 要对第 i 个用户进行选择
    private static void dfs(int i, int sum, int preSelected) {
        if (i == plans.length) {
            min = Math.min(min, sum);
            return;
        }

        for (int j = 0; j < 3; j++) {
            if (!used[i][j] && j != preSelected) {
                used[i][j] = true;
                dfs(i + 1, sum + plans[i][j], j);
                used[i][j] = false;
            }
        }
    }

}
