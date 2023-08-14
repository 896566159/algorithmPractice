package nowcoder.outd.hard;

import java.util.*;

/**
 * 给一个无向图染色，可以填红黑两种颜色，必须保证相邻两个节点不能同时为红色，输出有多少种不同的染色方案？
 * 输入描述：
 * 	第一行输入M(图中节点数) N(边数)
 * 	后续N行格式为：V1 V2表示一个V1到V2的边。
 * 	数据范围：1 <= M <= 15,0 <= N <= M * 3，不能保证所有节点都是连通的。
 * 输出描述：
 * 	输出一个数字表示染色方案的个数。
 *
 * 示例1：
 * 	输入：
 * 		4 4
 * 		1 2
 * 		2 4
 * 		3 4
 * 		1 3
 * 	输出：
 * 		7
 * 说明：4个节点，4条边，
 * 	1号节点和2号节点相连，
 * 	2号节点和4号节点相连，
 * 	3号节点和4号节点相连，
 * 	1号节点和3号节点相连，
 * 	若想必须保证相邻两个节点不能同时为红色，总共7种方案。
 */
public class _无向图染色_ {


    static int[] colored;
    static int res;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int m = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            split = scanner.nextLine().split(" ");
            int v1 = Integer.parseInt(split[0]);
            int v2 = Integer.parseInt(split[1]);

            if (!graph.containsKey(v1)) {
                graph.put(v1, new HashSet<>());
            }
            if (!graph.containsKey(v2)) {
                graph.put(v2, new HashSet<>());
            }

            // 邻接点
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        // 染色
        colored = new int[m + 1];
        // 节点编号[1, m],共 m 个
        dfs(graph, 1);
        System.out.println(res);
    }

    private static void dfs(Map<Integer, Set<Integer>> graph, int index) {
        if (index == colored.length) {
            res++;
            return;
        }

        // 未染色
        if (colored[index] == 0) {
            // 如果染黑色
            colored[index] = 1;
            dfs(graph, index + 1);

            // 如果当前点染红色,则其临边一定只能染成黑色
            colored[index] = 2;
            for (Integer neighbour : graph.get(index)) {
                colored[neighbour] = 1;
            }
            dfs(graph, index + 1);
        } else {
            // 如果已经染过则直接查找下一个点
            dfs(graph, index + 1);
        }

        // 撤销染色，重新选择另一种染色
        colored[index] = 0;
    }


}
