package nowcoder.outd.Y22Q4;

import java.util.Scanner;
import java.util.*;

/**
 * 张地图上有n个城市，城市和城市之间有且只有一条道路相连:要么直接相连，要么通过其它城市中转相连(可中转一次或多次)。城市与城市之间的道路都不会成环。
 * 当切断通往某个城市i的所有道路后，地图上将分为多个连通的城市群，设该城市的聚集度为DPiQ (Degree ofPolymerization)，
 *  DPi= max (城市群1的城市个数，城市群2的城市个数，.城市群m 的城市个数)。
 *  请找出地图上DP值Q最小的城市 (即找到城市，使得DPi = min(DP1.DP2....DPn)
 *  提示:如果有多个城市都满足条件，这些城市都要找出来 (可能存在多个解)提示:DPi的计算，可以理解为已知一棵树，删除某人节点后;生成的多个子树，求解多人子数节点数的问题.
 * 输入描述:每个样例: 第一行有一个整数N，表示有N个节点。1 <= N <= 1000。接下来的N-1行每行有两个整数x，y，表示城市x与城市y连接。1<= x,y<= N
 * 输出描述:
 * 输出城市的编号。如果有多个，按照编号升序输出。
 * 示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
 * 输入
 * 5
 * 1 2
 * 2 3
 * 3 4
 * 4 5
 * 输出
 * 3
 */
public class _城市聚集度_ {
    static class UF {  // 路径压缩的加权quick-union算法模板
        int[] parent;
        int[] size;
        // 标记最大的一个集群的所包含节点数量
        int maxUFCount;

        private UF (int n) {
            parent = new int[n + 1];
            size = new int[n + 1];
            maxUFCount = 1;

            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int getMaxUFCount() {
            return maxUFCount;
        }

        public void union (int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if (rootA != rootB) {
                if (size[rootA] < size[rootB]) {
                    parent[rootA] = rootB;
                    size[rootB] += size[rootA];
                    maxUFCount = Math.max(maxUFCount, size[rootB]);
                } else {
                    parent[rootB] = rootA;
                    size[rootA] += size[rootB];
                    maxUFCount = Math.max(maxUFCount, size[rootA]);
                }
            }
        }

        private int find (int p) {
            if (parent[p] == p) {
                return p;
            }

            return parent[p] = find(parent[p]);
        }
    }

    public static void main(String[] args) {
        // 读取数据
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][2];
        int[] memo = new int[n + 1];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }

        // 1~n这些点
        for (int i = 1; i <= n; i++) {
            // 遍历输入的所有边，并剔除掉包含当前点的边——即隔断改点与其他点的连接
            UF uf = new UF(n);
            for (int j = 0; j < n; j++) {
                if (arr[j][0] != i && arr[j][1] != i) {
                    uf.union(arr[j][0], arr[j][1]);
                }
            }

            // 剔除掉点 i 之后形成的孤立的城市群中，最大的城市集包含节点数为
            memo[i] = uf.getMaxUFCount();
            min = Math.min(min, memo[i]);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (memo[i] == min) {
                stringBuilder.append(i + " ");
            }
        }

        System.out.println("最小：" + min);
        System.out.println(stringBuilder.toString());
    }
}
