package ltcd.unionFindExercise;

public class _2382_删除操作后的最大子段和_ {

    public static void main(String[] args) {
        _2382_删除操作后的最大子段和_ v = new _2382_删除操作后的最大子段和_();
        v.maximumSegmentSum(new int[]{1,2,5,6,1}, new int[]{0,3,2,4,1});
    }

    // 存储每个数指向的代表元
    int[] fa;
    // 每个子段的元素和
    long[] sum;

    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        int n = nums.length;
        long[] res = new long[n];

        fa = new int[n + 1];
        sum = new long[n + 1];
        // 初始化并查集的每个元素的代表元
        for (int i = 0; i <= n; i++) {
            fa[i] = i;
        }

        // 逆序遍历 removeQueries
        for (int i = n - 1; i > 0; i--) {
            int remove = removeQueries[i];
            // 查找
            int to = find(remove + 1);
            // 合并 remove 和 remove + 1
            fa[remove] = to;
            sum[to] = sum[to] + sum[remove] + nums[remove];

            res[i -1] = Math.max(res[i], sum[to]);
        }
        return res;
    }

    // 合并两个
    private void union(int a, int b) {

    }

    // 查找 a 的代表元，并在查找的同时压缩路径：将 a->代表元 中间路径上的节点都直接指向 代表元
    private int find(int a) {
        if (a == fa[a]) {
            return a;
        }

        // 压缩路径
        return fa[a] = find(fa[a]);
    }

}
