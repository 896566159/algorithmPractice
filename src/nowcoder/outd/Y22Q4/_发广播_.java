package nowcoder.outd.Y22Q4;

import java.util.*;

/**
 * 某地有 N 个广播站，站点之间有些有连接，有些没有。有连接的站点在接受到广播后会互相发送。
 * 给定一个 N * N 的二维数组 matrix,数组的元素都是字符’0’或者’1’。matrix[i][j]=‘1’,则代表i和j站点之间有连接，matrix[i][j] = ‘0’代表没连接，
 * 现在要发一条广播，问初始最少给几个广播站发送，才能保证所有的广播站都收到消息。
 *
 * 输入描述：
 * 	输入为N行，每行有N个数字，为0或1，由空格分隔，构成N*N的数组，N的范围为 1<=N<=50
 *
 * 输出描述：
 * 	输出一个数字，为需要广播的服务器数量
 *
 * 示例 1：
 * 	输入：
 * 		1 0 0
 * 		0 1 0
 * 		0 0 1
 * 	输出：
 * 		3
 * 说明：3台服务器互不连接，所以需要分别广播这3台服务器
 *
 * 示例 1：
 * 	输入：
 * 		1 1
 * 		1 1
 * 	输出：
 * 		1
 * 说明：2台服务器相互连接，所以只需要广播其中一台服务器
 */
public class _发广播_ {

    static Set<Integer> visited;
    static List<Integer>[] all;

    // 并查集的方法
    static int[] parent;
    // 孤单数量
    static int island;

    public static void main(String[] args) {
        //处理输入
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int n = split.length;
        int[][] matrix = new int[n][n];
        // 可达点
        all = new List[n];
        visited = new HashSet<>();

        // 第一行
        for (int i = 0; i < n; i++) {
            matrix[0][i] = Integer.parseInt(split[i]);
        }

        // 后面 n - 1 行
        for (int i = 1; i < n; i++) {
            split = scanner.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(split[j]);
            }
        }

        // 并查集的方法
        parent = new int[n];
        island = n;
        // 初始化每个节点的代表元是自己
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // 合并集群
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && matrix[i][j] == 1) {
                    // 合并 i 和 j 所在的集群
                    union(i, j);
                }
            }
        }
        System.out.println("并查集的方法：" + island);

        // 采用 dfs 方法
        System.out.println("dfs方法输出");
        dfsMethod(n, matrix);
    }

    private static void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);

        if (rootI == rootJ) {
            return;
        }

        // 合并两个集群，总的孤岛数量 - 1
        island--;
        parent[rootI] = rootJ;
    }

    private static int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }


    // ------------------------------dfs 的方法-------------------------------------
    private static void dfsMethod(int n, int[][] matrix) {
        for (int i = 0; i < n; i++) {
            all[i] = new ArrayList<>();
            // 对角线就行，对称的矩阵
            for (int j = 0; j < n; j++) {
                if (i != j && matrix[i][j] == 1) {
                    // i 点可直接达到 j
                    all[i].add(j);
                }
            }
        }

        // 访问
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                count++;
                dfs(i);
            }
        }

        System.out.println(count);
    }

    private static void dfs(int i) {
        // 访问过了
        if (visited.contains(i)) {
            return;
        }

        // 将改点标记为已经访问过
        visited.add(i);
        for (Integer cur : all[i]) {
            dfs(cur);
        }
    }

}
