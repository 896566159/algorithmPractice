package ltcd.depthFirstSearchExercise;

import java.util.LinkedList;
import java.util.List;

public class _78_子集 {

    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            return new LinkedList<>();
        }

        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> path = new LinkedList<>();

        dfs(nums, 0, nums.length, 0, path, ans);

        ans.add(new LinkedList<>());
        return ans;
    }

    private void dfs(int[] nums, int begin, int len, int depth, List<Integer> path, List<List<Integer>> ans) {
        if (depth == len) {
            return;
        }

        for (int i = begin; i < len; i++) {
            List<Integer> list = new LinkedList<>();
            list.add(nums[i]);

            path.add(nums[i]);
            ans.add(new LinkedList<>(path));

            dfs(nums, i + 1, nums.length, depth + 1, path, ans);

            path.remove(path.size() - 1);
        }
    }

}
