package nowcoder.outd.Y22Q4;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 公司创新实验室正在研究如何最小化资源成本，最大化资源利用率，
 * 请你设计算法帮他们解决一个任务混部问题：
 * 	有taskNum项任务，每个任务有开始时间（startTime），结束时间（endTime）,并行度（parallelism）三个属性，
 * 	并行度是指这个任务运行时将会占用的服务器数量，
 * 	一个服务器在每个时刻可以被任意任务使用，但最多被一个任务占用，任务运行完成立即释放（结束时刻不占用）。
 * 任务混部问题是指给定一批任务，让这批任务由同一批服务器承载运行，
 * 请你计算完成这批任务混部最少需要多少服务器，从而最大最大化控制资源成本。
 *
 * 输入描述：
 * 	第一行输入为taskNum，表示有taskNum项任务
 * 	接下来taskNum行，每行三个整数，表示每个任务的开始时间（startTime ），结束时间（endTime ），并行度（parallelism）
 * 备注：
 * 	1<=taskNum<=100000
 * 	0<=startTime<endTime<=50000
 * 	1<=parallelism<=100
 * 输出描述：
 * 	一个整数，表示最少需要的服务器数量
 *
 * 示例1：
 * 	输入：
 * 		3
 * 		2 3 1
 * 		6 9 2
 * 		0 5 1
 * 	输出：
 * 		2
 * 	说明：
 * 		一共有三个任务，第一个任务在时间区间【2，3】运行，占用1个服务
 * 		器，第二个任务在时间区间【6，9】运行，占用2个服务器，第三个任
 * 		务在时间区间【0，5】运行，占用1个服务器，需要最多服务器的时间
 * 		区间为【2，3】和【6，9】，需要2个服务器。
 *
 * 示例2：
 * 	输入：
 * 		2
 * 		3 9 2
 * 		4 7 3
 * 	输出：
 * 		5
 * 	说明：
 * 		一共两个任务，第一个任务在时间区间【3，9】运行，占用2个服务
 * 		器，第二个任务在时间区间【4，7】运行，占用3个服务器，需要最多
 * 		服务器的时间区间为【4，7】，需要5个服务器。
 */
public class _最大化控制资源成本_ {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[][] tasks = new int[n][3];
        for (int i = 0; i < n; i++) {
            tasks[i][0] = in.nextInt();
            tasks[i][1] = in.nextInt();
            tasks[i][2] = in.nextInt();
        }

        System.out.println(minServers(tasks));
        System.out.println(minServers1(tasks));
        System.out.println(minServers(tasks) == minServers1(tasks));
    }


    private static int minServers1(int[][] tasks) {
        int ans = 0;
        int n = tasks.length;
        int[][] begin = new int[n][2];
        int[][] end = new int[n][2];

        // 添加到数组中
        for (int i = 0; i < n; i++) {
            begin[i] = new int[]{tasks[i][0], tasks[i][2]};
            end[i] = new int[]{tasks[i][1], -tasks[i][2]};
        }

        // 排序
        Arrays.sort(begin, (a, b)->Integer.compare(a[0], b[0]));
        Arrays.sort(end, (a, b)->Integer.compare(a[0], b[0]));

        int i = 0;
        int j = 0;
        int count = 0;
        while (i < n && j < n) {
            // 先扫描到某个任务的起始时间
            if (begin[i][0] < end[j][0]) {
                // 累加需要的服务器数量
                count += begin[i][1];
                i++;
            } else {
                // 累加需要的服务器数量
                count += end[j][1];
                j++;
            }

            // 更新需要的服务器数量的最大值
            ans = Math.max(ans, count);
        }

        return ans;
    }

    private static int minServers(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> {
            return a[0] - b[0];
        });

        PriorityQueue<Integer[]> priorityQueue = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });
        int res = 0;
        int tmp = 0;

        for (int i = 0; i < tasks.length; i++) {
            // 先下车
            while (!priorityQueue.isEmpty()) {
                Integer[] peek = priorityQueue.peek();

                // 下车
                if (peek[0] <= tasks[i][0]) {
                    Integer[] poll = priorityQueue.poll();
                    tmp -= poll[1];
                } else {
                    break;
                }
            }

            // 上车
            priorityQueue.offer(new Integer[] {tasks[i][1], tasks[i][2]});
            tmp += tasks[i][2];

            res = Math.max(res, tmp);
        }

        return res;
    }

}
