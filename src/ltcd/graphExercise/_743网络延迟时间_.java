package ltcd.graphExercise;

import java.util.Arrays;
import java.util.Scanner;

public class _743网络延迟时间_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        _743网络延迟时间_ v = new _743网络延迟时间_();
        System.out.println(v.networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE / 2;
        // 邻接矩阵存储边信息,g[i][j] 表示从 i 到 j 这条边的权值；如果顶点 i 到 j 之间没有边，则g[i][j] = INF
        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(g[i], INF);
        }

        // 填写边信息
        for (int[] edge : times) {
            // 边序号从 0 开始
            int i = edge[0] - 1;
            int j = edge[1] - 1;
            g[i][j] = edge[2];
        }

        // 从源点到其他顶点的距离
        int[] dist = new int[n];
        // 初始化：源点到其他顶点距离为无穷大
        Arrays.fill(dist, INF);
        // 从点 k 开始，故点 k 到点 k 的距离修改为 0
        dist[k - 1] = 0;

        // 标记节点是否已经确定是最短距离了
        boolean[] used = new boolean[n];

        for (int i = 0; i < n; i++) {
            // 在未确定最短路径的顶点中，找出距离源点最近的点
            int x = -1;
            for (int j = 0; j < n; j++) {
                if (!used[j] && (x == -1 || dist[j] < dist[x])) {
                    x = j;
                }
            }

            // 标记该顶点已经确定了距离源点最短距离
            used[x] = true;
            // 用该顶点去更新所有其他的距离
            for (int j = 0; j < n; j++) {
                if (g[x][j] + dist[x] < dist[j]) {
                    dist[j] = g[x][j] + dist[x];
                }
            }
        }

        // 找到距离最远的点
        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == INF ? -1 : ans;
    }

}
