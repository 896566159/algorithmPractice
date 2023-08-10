package nowcoder.outd.hard;

import java.util.Arrays;
import java.util.Scanner;

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
        int m = Integer.parseInt(split[1]);
        int[][] edges = new int[m][3];
        final int INF = Integer.MAX_VALUE / 2;

        for (int i = 0; i < m; i++) {
            split = scanner.nextLine().split(" ");
            edges[i][0] = Integer.parseInt(split[0]);
            edges[i][1] = Integer.parseInt(split[1]);
            edges[i][2] = Integer.parseInt(split[2]);
        }
        // 起点和终点
        split = scanner.nextLine().split(" ");
        int start = Integer.parseInt(split[0]);
        int target = Integer.parseInt(split[1]);


        // g[i][j] 表示顶点 i 到 j 之间的边的距离：如果i、j之间有边，则g[i][j] = 权值；如果没有边，则为g[i][j] = INF
        int[][] g = new int[n][n];
        // 初始化
        for (int i = 0; i < n; i++) {
            Arrays.fill(g[i], INF);
        }
        // 便利edges信息，填充邻接表 g
        for (int k = 0; k < m; k++) {
            int i = edges[k][0];
            int j = edges[k][1];
            g[i - 1][j - 1] = edges[k][2];
        }

        // 记录从起点到其他每个顶点的最短距离
        int[] distance = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = INF;
        }
        // 修改起点到起点的距离为 0
        distance[start - 1] = 0;

        // 标记起点到某点的最短路径是否已经被确定
        boolean[] decided = new boolean[n];

        // 开始更新起点到每个顶点的距离
        for (int i = 0; i < n; i++) {
            // 找到一个没有确定最短距离，且是当前距离起点距离最近的点作为基点
            int begin = -1;
            for (int j = 0; j < n; j++) {
                if (!decided[j] && (begin == -1 || distance[j] < distance[begin])) {
                    begin = j;
                }
            }

            // 标记起点到该顶点的距离已经被确定
            decided[begin] = true;
            // 更新基点可达的点的最短距离
            for (int j = 0; j < n; j++) {
                // 如果基点可达 j 点，且从基点再到 j 点的距离要要比其他点达 j 点距离更短，则从起点到 j 的最短距离
                if (g[begin][j] + distance[begin] < distance[j]) {
                    distance[j] = g[begin][j] + distance[begin];
                }
            }
        }

        // 找出点起点是否可达终点
        System.out.println(distance[target - 1] == INF ? -1 : distance[target - 1]);
    }

}
