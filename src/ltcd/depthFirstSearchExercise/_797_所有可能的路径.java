package ltcd.depthFirstSearchExercise;

import java.util.LinkedList;
import java.util.List;

public class _797_所有可能的路径 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return new LinkedList<>();
        }

        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> path = new LinkedList<>();

        dfs(graph, 0, graph.length - 1, path, ans);

        return ans;
    }

    private void dfs(int[][] graph, int  num, int len, List<Integer> path, List<List<Integer>> ans) {
        if (num == len) {
            ans.add(new LinkedList<>(path));
            return;
        }

        for (int next : graph[num]) {
            path.add(next);

            dfs(graph, next, len, path, ans);

            path.remove(next);
        }
    }

}
