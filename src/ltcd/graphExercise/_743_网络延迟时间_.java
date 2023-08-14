package ltcd.graphExercise;

import java.util.Arrays;

public class _743_网络延迟时间_ {

    public int networkDelayTime(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE / 2;
        // graph[i][j] = 顶点 i 到 j 的边长，如果顶点 i 无法到达 j, graph[i][j] = INF
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int i = 0; i < times.length; i++) {
            graph[times[i][0] - 1][times[i][1] - 1] = times[i][2];
        }

        // 标记从顶点 k 出发到其他顶点的距离
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[k - 1] = 0;
        // 标记顶点是否已经是最短路径
        boolean[] used = new boolean[n];

        for (int i = 0; i < n; i++) {
            int min = -1;
            for (int j = 0; j < n; j++) {
                if (!used[j] && (min == -1 || dist[min] > dist[j])) {
                    min = j;
                }
            }

            // 标记改点是最短路径了
            used[min] = true;
            // 从改点出发，更新其可达的顶点的最短距离
            for (int j = 0; j < n; j++) {
                if (dist[j] > dist[min] + graph[min][j]) {
                    dist[j] = dist[min] + graph[min][j];
                }
            }
        }

        // 找出最长的时延
        int max = Arrays.stream(dist).max().getAsInt();
        return max == INF ? -1 : max;
    }

}
