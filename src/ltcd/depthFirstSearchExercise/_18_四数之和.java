package ltcd.depthFirstSearchExercise;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _18_四数之和 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length == 0) {
            return new LinkedList<>();
        }

        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        Deque<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, target, 0, 0, path, res, used);

        return res;
    }

    private void dfs(int[] nums, int target, int begin, int sum, Deque<Integer> path, List<List<Integer>> res, boolean[] used) {
        if (path.size() == 4) {
            if (sum == target) {
                res.add(new LinkedList<>(path));
            }
            return;
        }

        if (path.size() > 4) {
            return;
        }

        for (int i = begin; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            path.offerLast(nums[i]);
            used[i] = true;
            dfs(nums, target, i + 1, sum + nums[i], path, res, used);
            used[i] = false;
            path.removeLast();
        }
    }
}
