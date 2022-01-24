package ltcd.depthFirstSearchExercise;

import java.util.LinkedList;
import java.util.List;

public class _77_组合 {

    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        
        dfs(1, n, 0, k, path, ans);
        
        return ans;
    }

    private void dfs(int begin, int end, int depth, int k, List<Integer> path, List<List<Integer>> ans) {
        if (depth == k) {
            ans.add(new LinkedList<>(path));
            return;
        }

        for (int i = begin; i <= end; i++) {
            path.add(i);

            dfs(i + 1, end, depth + 1, k, path, ans);

            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        new _77_组合().combine(4, 2);
    }

}
