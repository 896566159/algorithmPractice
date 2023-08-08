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

    static int res = 0;
    static List<Vertex> vertexSet;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int m = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);

        vertexSet = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            split = scanner.nextLine().split(" ");
            int v1 = Integer.parseInt(split[0]);
            int v2 = Integer.parseInt(split[0]);

            Vertex vertex = new Vertex();
            vertex.corlor = 0;
            vertex.to = v1;
            vertex.from = v2;
            vertexSet.add(vertex);
        }

        for (int i = 0; i < vertexSet.size(); i++) {
            dfs(0, i);
        }

        System.out.println(res);
    }

    private static void dfs(int count, int index) {
        if (count >= vertexSet.size()) {
            res++;
            return;
        }

        if (index >= vertexSet.size()) {
            return;
        }

        // 没有染色
        if (vertexSet.get(index).corlor == 0) {
            // 染黑色
            vertexSet.get(index).corlor = 1;
            // 染一下一个点
            dfs(count + 1, index + 1);

            // 染红色
            boolean neighbourIsNotRed = true;
            for (int i = 0; i < vertexSet.size(); i++) {
                if (vertexSet.get(i).to == vertexSet.get(index).from && vertexSet.get(i).corlor == 1) {
                    neighbourIsNotRed = false;
                }
            }

            // 染成红色
            vertexSet.get(index).corlor = 2;
            if (neighbourIsNotRed) {
                dfs(count + 1, index + 1);
            } else {
                return;
            }
        } else {
            // 已经染过色
            dfs(count + 1, index + 1);
        }

        vertexSet.get(index).corlor = 0;
    }

    static class Vertex {
        int corlor;
        int from;
        int to;
    }
}
