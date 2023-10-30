package nowcoder.outd.Y22Q4;

import java.util.*;

/**
 * 快递业务范围有 N 个站点，A 站点与 B 站点可以中转快递，则认为 A-B 站可达，
 * 如果 A-B 可达，B-C 可达，则 A-C 可达。
 * 现在给 N 个站点编号 0、1、…n-1，用 s[i][j]表示 i-j 是否可达，
 * s[i][j] = 1表示 i-j可达，s[i][j] = 0表示 i-j 不可达。
 * 现用二维数组给定N个站点的可达关系，请计算至少选择从几个主站点出发，才能可达所有站点（覆盖所有站点业务）。
 * 说明：s[i][j]与s[j][i]取值相同。
 *
 * 输入描述：
 * 	第一行输入为 N，N表示站点个数。 1 < N < 10000
 * 	之后 N 行表示站点之间的可达关系，第i行第j个数值表示编号为i和j之间是否可达。
 *
 * 输出描述：
 * 	输出站点个数，表示至少需要多少个主站点。
 *
 * 示例1：
 * 	输入：
 * 		4
 * 		1 1 1 1
 * 		1 1 1 0
 * 		1 1 1 0
 * 		1 0 0 1
 * 	输出：
 * 		1
 * 说明：
 * 	选择 0 号站点作为主站点， 0 站点可达其他所有站点，
 * 	所以至少选择 1 个站点作为主站才能覆盖所有站点业务。
 *
 * 示例2：
 * 	输入：
 * 		4
 * 		1 1 0 0
 * 		1 1 0 0
 * 		0 0 1 0
 * 		0 0 0 1
 * 	输出：
 * 		3
 * 说明：
 * 	选择 0 号站点可以覆盖 0、1 站点，
 * 	选择 2 号站点可以覆盖 2 号站点，
 * 	选择 3 号站点可以覆盖 3 号站点，
 * 	所以至少选择 3 个站点作为主站才能覆盖所有站点业务。
 */
public class _快递业务站_ {

    // 并查集代表元数组
    static int[] parent;
    // 代表元数组所属的类别/集群中的节点数量
    static int[] size;
    // 又多少个相互独立的类别/集群
    static int countIslans;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] nums = new int[n][n];
        List<Integer>[] edges = new List[n];

        // 输入处理
        for (int i = 0; i < n; i++) {
            String[] split = scanner.nextLine().split(" ");
            List<Integer> list = new ArrayList<>();
            int[] tmp = new int[n];
            for (int j = 0; j < n; j++) {
                tmp[j] = Integer.parseInt(split[j]);
                if (tmp[j] == 1 && i != j) {
                    list.add(j);
                }
            }
            nums[i] = tmp;
            edges[i] = list;
        }

        // 初始化并查集，n个节点，节点编号[0, n -1]
        parent = new int[n];
        size = new int[n];
        countIslans = n;
        // 初始化并查集代表元、节点的数量
        for (int i = 0; i < countIslans; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        // 遍历所有元素
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i][j] == 1) {
                    // 合并两个集
                    union(i, j);
                }
            }
        }

        // 并查集解法
        System.out.println("并查集解法:" + countIslans);
        // 图 dfs 解法
        int cnt = 0;
        for (int i = 0; i < edges.length; i++) {
            if (!visited.contains(i)) {
                dfs(edges, i);
                cnt++;
            }
        }
        System.out.println("图 dfs 解法:" + cnt);
    }

    // 合并两个类别/集群
    private static void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);

        if (rootI == rootJ) {
            return;
        }

        // 孤岛数量 - 1,合并两个集
        countIslans--;
        if (size[rootI] < size[rootJ]) {
            parent[rootI] = rootJ;
            size[rootJ] += size[rootI];
        } else {
            parent[rootJ] = rootI;
            size[rootI] += size[rootJ];
        }
    }

    // 找出某点的所属类别/集群的代表元
    private static int find(int i) {
        return i == parent[i] ? i : (parent[i] = find(parent[i]));
    }

    // 图解法
    private static Set<Integer> visited = new HashSet<>();
    private static void dfs(List<Integer>[] nums, int n) {
        if (visited.contains(n)) {
            return;
        }

        // 改点已经遍历过，将改点加入到访问记录中
        visited.add(n);
        for (Integer neighbour : nums[n]) {
            // 访问当前节点可达的邻接节点
            dfs(nums, neighbour);
        }
    }


}
