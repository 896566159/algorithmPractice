package ltcd.unionFindExercise;

public class _剑指_OfferII_116_省份数量 {

    public static void main(String[] args) {
        _剑指_OfferII_116_省份数量 v = new _剑指_OfferII_116_省份数量();
        System.out.println(v.findCircleNum(new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}}));
    }

    int[] parent;
    int[] size;
    int count;

    public int findCircleNum(int[][] isConnected) {
        count = isConnected.length;
        parent = new int[count];
        size = new int[count];

        for (int i = 0; i < count; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1) {
                    merge(i, j);
                }
            }
        }

        return count;
    }

    private void merge(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return;
        }

        if (size[rootA] > size[rootB]) {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        } else {
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        }

        // 两个集群合并，总集群数量减一
        count--;
    }

    private int find(int a) {
        if (a == parent[a]) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }

}
