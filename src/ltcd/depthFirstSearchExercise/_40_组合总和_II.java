package ltcd.depthFirstSearchExercise;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _40_组合总和_II {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) {
            return new LinkedList<>();
        }

        Arrays.sort(candidates);
        List<List<Integer>> ans = new LinkedList<>();
        int len = candidates.length;
        int begin = 0;
        List<Integer> path = new LinkedList<>();

        dfs(candidates, len, target, begin, path, ans);

        return ans;
    }

    private void dfs(int[] candidates, int len, int target, int begin, List<Integer> path, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new LinkedList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            if (target < candidates[i]) {
                break;
            }

            path.add(candidates[i]);

            dfs(candidates, len, target - candidates[i], i + 1, path, ans);

            path.remove(path.size() - 1);

        }
    }

    public static void main(String[] args) {
        new _40_组合总和_II().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
    }

}
