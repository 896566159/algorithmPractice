package ltcd.unionFindExercise;

public class _剑指_OfferII_118_多余的边 {

    int[] parent;
    int[] size;
    int count;
    public int[] findRedundantConnection(int[][] edges) {

        int count = edges.length;
        parent = new int[count + 1];
        size = new int[count + 1];

        for (int i = 0; i <= count; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int[] edge : edges) {
            if (!merge(edge[0], edge[1])) {
                return edge;
            }
        }

        return null;
    }

    private boolean merge(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        // 如果两个点已经处于同一个集群中，则不用合并
        if (rootA == rootB) {
            return false;
        }

        // 将子节点少的集群合并到子节点多的集群上
        if (size[rootA] < size[rootB]) {
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        } else {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }

        // 只要有集群合并，集群数 -1
        count--;
        return true;
    }

    private int find(int a) {
        if (a == parent[a]) {
            return parent[a];
        }

        // 路径压缩
        return parent[a] = find(parent[a]);
    }

}
