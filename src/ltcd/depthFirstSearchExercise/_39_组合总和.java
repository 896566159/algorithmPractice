package ltcd.depthFirstSearchExercise;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _39_组合总和 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return new LinkedList<>();
        }

        Arrays.sort(candidates);
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> path = new LinkedList<>();

        dfs(candidates,0, target, path, ans);

        return ans;
    }

    private void dfs(int[] candidates, int start, int target, List<Integer> path, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new LinkedList<>(path));
            System.out.println("*****************" + path);
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);

            System.out.println("递归前" + path);
            dfs(candidates, i, target - candidates[i], path, ans);

            path.remove(path.size() - 1);
            System.out.println("递归后" + path);
        }
    }

    public static void main(String[] args) {
        new _39_组合总和().combinationSum(new int[]{2,3,6,7}, 7);
    }

}
