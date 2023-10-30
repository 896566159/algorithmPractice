package nowcoder.outd.Y22Q4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 你有 n 台机器编号为 1~n，每台都需要完成完成一项工作，机器经过配置后都能完成独立完成一项工作。
 * 假设第 i 台机器你需要花 B 分钟进行设置，然后开始运行，J 分钟后完成任务。
 * 现在，你需要选择布置工作的顺序，使得用最短的时间完成所有工作。
 * 注意，不能同时对两台进行配置，但配置完成的机器们可以同时执行他们各自的工作。
 * 输入描述：
 * 第一行输入代表总共有 M 组任务数据（1<M<=10）。
 * 每组数第一行为一个整数指定机器的数量 N（0<N<=1000）。
 * 随后的 N 行每行两个整数，第一个表示 B（0<=B<=10000），第二个表示 J（0<=J<=10000）。
 * 每组数据连续输入，不会用空行分隔。各组任务单独计时。
 * 输出描述：
 * 对于每组任务，输出最短完成时间，且每组的结果独占一行。例如，两组任务就应该有两行输出。
 * <p>
 * 示例1：
 * 输入：
 * 1
 * 1
 * 2 2
 * 输出：
 * 4
 * <p>
 * 解释：
 * 第一行 1 为一组任务，第二行 1 代表只有一台机器，第三行表示该机器配置需2分钟，执行需2分钟。
 * <p>
 * 示例2：
 * 输入：
 * 2
 * 2
 * 1 1
 * 2 2
 * 3
 * 1 1
 * 2 2
 * 3 3
 * 输出：
 * 4
 * 7
 * 解释：
 * 第一行 2 代表两组任务，
 * 第二行 2 代表第一组任务有2个机器，
 * 第三行1 1代表机器 1 配置需要 1 分运行需要 1 分，
 * 第四行2 2代表机器2配置需要 2 分运行需要 2 分，
 * 第五行 3 代表第二组任务需要 3 个机器，
 * 第6-8行分别表示3个机器的配置与运行时间。
 */
public class _高效的任务规划_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            // 机器数量
            int machines = Integer.parseInt(scanner.nextLine());

            // 每台机器的设置时间和运行时间
            int[][] times = new int[machines][2];
            for (int j = 0; j < machines; j++) {
                String[] split = scanner.nextLine().split(" ");
                times[j][0] = Integer.parseInt(split[0]);
                times[j][1] = Integer.parseInt(split[1]);
            }

            // 排序：按照运行时间长倒短，相同运行时间按照
            Arrays.sort(times, (a, b)->b[1] - a[1]);

            // 第一台机器的设置和执行时间
            int minTime = times[0][0] + times[0][1];
            // 上一台机器运行的时间
            int preRun = times[0][1];
            for (int j = 1; j < machines; j++) {
                // 当前机器的 设置时间 + 运行时间
                int curTime = times[j][0] + times[j][1];

                // 如果前面一个机器的运行时间够长，能够覆盖玩当前机器的 设置时间 + 运行时间，则不需要增加总的时间
                if (preRun >= curTime) {
                    // 更新运行时间： max{当前这一台的运行时间长，(前一台的运行时间 - 当前这一台的设置时间)}
                    preRun = Math.max(times[j][1], preRun - times[j][0]);
                } else {
                    // 如果前面一个机器的运行时间不足以 够覆完当前机器的 设置时间 + 运行时间，则总时间 需要加上 curTime - preRun
                    minTime += curTime - preRun;
                    // 更新时间，前面一台机器的运行时间不能覆盖完当前这一台的时间，所以最新的运行时间 = 当前这一台的运行时间
                    preRun = times[j][1];
                }
            }

            // 输出
            System.out.println(minTime);

            // 网上做法
            System.out.print("网上做法");
            test(machines, times);
        }

    }

    public static void test(int N, int[][] machine) {

        Arrays.sort(machine, (e1, e2) -> (e2[1] - e1[1]));
        int[] dp = new int[N];
        dp[0] = machine[0][0] + machine[0][1];
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 1] - machine[i - 1][1] + machine[i][0] + machine[i][1]);
        }

        System.out.println(dp[N - 1]);

    }

}
