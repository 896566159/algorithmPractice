package nowcoder.outd.Y23Q3;

import java.util.*;

/**
 * 某通信网络中有N个网络结点，用1到N进行标识。
 * 网络通过一个有向无环图表示，其中图的边的值表示结点之间的消息传递时延。
 * 现给定相连节点之间的时延列表times[i]={u，v，w}，其中u表示源结点，v表示目的结点，w表示u和v之间的消息传递时延。
 * 请计算给定源结点到目的结点的最小传输时延，如果目的结点不可达，返回-1。
 * 注：
 * 	N的取值范围为[1，100];
 * 	时延列表times的长度不超过6000，且 1 <= u,v <= N，0 <= w <= 100;
 * 输入描述：
 * 	输入的第一行为两个正整数，分别表示网络结点的个数N，以及时延列表的长度M，用空格分隔；
 * 	接下来的M行为两个结点间的时延列表[u v w];
 * 	输入的最后一行为两个正整数，分别表示源结点和目的结点。
 * 输出描述：
 * 	起点到终点得最小时延，不可达则返回-1
 *
 * 示例：
 * 	输入：
 * 		3 3
 * 		1 2 11
 * 		2 3 13
 * 		1 3 50
 * 		1 3
 * 	输出：
 * 		24
 */
public class _最小传输时延I_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[0]);
        int[][] times = new int[m][3];
        for (int i = 0; i < m; i++) {
            times[i][0] = scanner.nextInt();
            times[i][1] = scanner.nextInt();
            times[i][2] = scanner.nextInt();
        }
        int start = scanner.nextInt();
        int end = scanner.nextInt();

        // Dijkstra算法，邻接表
        // 记录从start出发到其他顶点的最短距离
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        // 起点start到start的距离为0
        dist[start] = 0;
        // 用于记录start到其他点的距离，且方便实时找出最小的距离
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)->a[1] - b[1]);
        queue.add(new int[] {start, 0});

        while (!queue.isEmpty()) {
            // 找出当前距离起点start最近的点
            int[] poll = queue.poll();
            int cur = poll[0];
            // 用该点去更新其他可达顶点的距离
            for (int i = 0; i < times.length; i++) {
                if (times[i][0] == cur) {
                    int next = times[i][1];
                    if (dist[next] > dist[cur] + times[i][2]) {
                        dist[next] = dist[cur] + times[i][2];
                        // 改点也放入到队列中
                        queue.add(new int[] {next, dist[next]});
                    }
                }
            }
        }

        System.out.println(dist[end] == Integer.MAX_VALUE ? -1 : dist[end]);
    }

}
