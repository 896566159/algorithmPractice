package ltcd.graphExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1337T秒后青蛙的位置_ {

    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<Integer>[] g = new ArrayList[n + 1];
        Arrays.setAll(g, e -> new ArrayList<>());
        g[1].add(0);// 减少额外的判断

        // 遍历边
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];

            // 建树
            g[x].add(y);
            g[y].add(x);
        }

        long prod = dfs(g, target, 1, 0, t);
        return prod != 0 ? 1.0 / prod : 0;
    }

    private long dfs(List<Integer>[] g, int target, int x, int fa, int leftT) {
        // t秒后青蛙必须在target（恰好达到 或者 在target上停留
        if (leftT == 0) {
            return x == target ? 1 : 0;
        }
        if (x == target) {
            return g[x].size() == 1 ? 1 : 0;
        }

        // 遍历 x 的儿子 y
        for (int y : g[x]) {
            // y 不能是父节点
            if (y != fa) {
                // 寻找target
                long prod = dfs(g, target, y, x, leftT - 1);
                if (prod != 0) {
                    // 乘上儿子个数，并直接返回
                    return prod * (g[x].size() - 1);
                }
            }
        }

        // 未找到target
        return 0;
    }

}
