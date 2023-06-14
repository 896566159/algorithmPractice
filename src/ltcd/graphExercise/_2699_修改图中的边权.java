package ltcd.graphExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2699_修改图中的边权 {

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        List<int[]> g[] = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];

            // 建图，额外记录边的编号
            g[x].add(new int[]{y, i});
            g[y].add(new int[]{x, i});
        }

        int[][] dis = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i != source) {
                dis[i][0] = dis[i][1] = Integer.MAX_VALUE;
            }
        }

        dijkstra(g, edges, destination, dis, 0, 0);
        int delta = target - dis[destination][0];
        // -1 全改为 1 时，最短路比 target 还大
        if (delta < 0) {
            return new int[][]{};
        }

        dijkstra(g, edges, destination, dis, delta, 1);
        // 最短路无法在变大，无法到达 target
        if (dis[destination][1] < target) {
            return new int[][]{};
        }

        for (int i = 0; i < edges.length; i++) {
            // 剩余还没有修改的边全部改成 1
            if (edges[i][2] == -1) {
                edges[i][2] = 1;
            }
        }

        return edges;
    }

    private void dijkstra(List<int[]>[] g, int[][] edges, int destination, int[][] dis, int delta, int k) {
        int n = g.length;
        boolean[] vis = new boolean[n];

        for (; ; ) {
            // 根据当前最短路，去更新它的邻居的最短路
            // 根据数学归纳法，dis[x][k] 一定是最短路长度
            int x = -1;
            for (int i = 0; i < n; i++) {
                if (!vis[i] && (x < 0 || dis[i][k] < dis[x][k])) {
                    x = i;
                }
            }

            // 起点 source 到终点 destination 的最短路已确定
            if (x == destination) {
                return;
            }

            // 标记，在后续的循环中无需反复更新 x 到其余点的最短路长度
            vis[x] = true;
            for (int[] e : g[x]) {
                int y = e[0];
                int eid = e[1];
                int wt = edges[eid][2];

                if (wt == -1) {
                    // -1 改成 1
                    wt = 1;
                }

                if (k == 1 && edges[eid][2] == -1) {
                    // 第二次 Dijkstra， 改成 w
                    int w = delta + dis[y][0] - dis[x][1];
                    if (w > wt) {
                        // 直接在 edges 上修改
                        edges[eid][2] = wt = w;
                    }
                }

                // 更新最短路
                dis[y][k] = Math.min(dis[y][k], dis[x][k] + wt);
            }
        }
    }

}
