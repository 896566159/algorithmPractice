package ltcd.unionFindExercise;

public class _684_冗余连接_ {

    public static void main(String[] args) {
        _684_冗余连接_ v = new _684_冗余连接_();
        System.out.println(v.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}})[1]);
    }

    // 记录元素指向的代表元
    int[] fa;

    public int[] findRedundantConnection(int[][] edges) {
        int length = edges.length;
        fa = new int[length + 1];

        for (int i = 0; i <= length; i++) {
            fa[i] = i;
        }

        for (int i = 0; i < length; i++) {
            int[] edge = edges[i];

            int a = edge[0];
            int b = edge[1];

            if (!union(a, b)) {
                return edge;
            }
        }

        return new int[2];
    }

    private boolean union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x == y) {
            return false;
        }

        fa[a] = b;

        return true;
    }

    private int find(int a) {
        if (fa[a] == a) {
            return fa[a];
        }

        return fa[a] = find(fa[a]);
    }

}
