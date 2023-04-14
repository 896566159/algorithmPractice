package nowcoder.outd.Y22Q4;

import java.util.Scanner;

public class _城市聚集度_ {

    // 记录每一个城市之间的父节点关系
    static int[] depth;
    // 记录每一个城市的下挂的城市树的深度
    static int[] citys;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        citys = new int[n + 1];
        depth = new int[n + 1];

        // 初始化
        for (int i = 0; i <= n; i++) {
            // 每座城市的父节点初始化成自己
            citys[i] = i;
            // 以该城市为根节点的树的深度为 1
            depth[i] = 1;
        }

        for (int i = 0; i < n - 1; i++) {
            int leftCity = scanner.nextInt();
            int rightCity = scanner.nextInt();

            // 让 leftCity 和 rightCity 合并
            union(leftCity, rightCity);
        }

        System.out.println(124);

    }

    /**
     * 找到leftCity 和 rightCity两棵树的根节点，并合并成一个城市树
     * @param leftCity
     * @param rightCity
     */
    private static void union(int leftCity, int rightCity) {
        int left = find(leftCity);
        int right = find(rightCity);

        // 如果这两个城市属于同一个集群，则不用合并
        if (left == right) {
            return;
        }

        // 将城市深度短的城市树作为深度长的城市树的子树合并
        if (depth[left] < depth[right]) {
            // 深度短的树的根节点的父节点 指向 深度长的根节点
            citys[left] = right;
        } else if (depth[left] > depth[right]) {
            // 深度短的树的根节点的父节点 指向 深度长的根节点
            citys[right] = left;
        } else {
            // 深度相同，则随机挑选其中一个作为根节点，且该点的深度 + 1
            citys[left] = right;
            depth[right] += 1;
        }
    }

    /**
     * 返回city所属的城市树的根节点
     * @param city
     * @return
     */
    private static int find(int city) {
        // 如果查找的城市的父节点是自己，则找到了其所属的城市树根节点
        if (city == citys[city]) {
            return city;
        }

        // 递归查找，并压缩路径，遍历过程中的所有双亲结点直接指向根结点，减少后续查找次数.
//        int root = find(citys[city]);
//        citys[city] = root;
//        return root;
        // 递归查找，并压缩路径，遍历过程中的所有双亲结点直接指向根结点，减少后续查找次数.写成一行
        return citys[city] = find(citys[city]);
    }

}
