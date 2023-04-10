package nowcoder.outd.Y22Q4;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

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
//        Arrays.sort(tasks, (a, b)-> a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

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
