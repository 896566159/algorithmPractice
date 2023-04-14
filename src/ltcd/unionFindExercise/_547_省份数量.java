package ltcd.unionFindExercise;

public class _547_省份数量 {

    public static void main(String[] args) {
        _547_省份数量 v = new _547_省份数量();
        System.out.println(v.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }

    public int findCircleNum(int[][] isConnected) {

        int length = isConnected.length;
        UnionFind unionFind = new UnionFind(length);

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {

                // 两个城市相连接，合并
                if (isConnected[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }

        return unionFind.sum;
    }

}

class UnionFind {
    // 指向代表元
    int[] fa;
    // 记录以当前节点为根节点的子树的节点数
    int[] size;
    // 有多少个元代表不同的集合
    int sum;

    public UnionFind(int n) {
        this.sum = n;
        fa = new int[n];
        size = new int[n];

        // 初始化
        for (int i = 0; i < n; i++) {
            fa[i] = i;
            size[i] = 1;
        }
    }

    public int find(int a) {
        if (a == fa[a]) {
            return a;
        }

        return find(fa[a]);
    }

    public void union(int a, int b) {
        int f1 = find(a);
        int f2 = find(b);

        // 两个点已经在同一个集合，不用合并
        if (f1 == f2) {
            return;
        }

        // 合并两个点，则 不同的集合数量-1
        sum--;
        if (size[f1] < size[f2]) {
            fa[f1] = f2;
            size[f2] += size[f1];
        } else {
            fa[f2] = f1;
            size[f1] = f2;
        }
    }

}