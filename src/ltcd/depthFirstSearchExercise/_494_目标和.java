package ltcd.depthFirstSearchExercise;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _494_目标和 {

    int res = 0;

    public int findTargetSumWays(int[] nums, int target) {

        dfs(nums, nums.length, 0, 0, target);

        return res;
    }

    private void dfs(int[] nums, int len, int depath, int sum, int target) {
        if (depath == len) {
            if (sum == target) {
                res++;
            }
            return;
        }

        dfs(nums, len, depath + 1, sum + nums[depath], target);

        dfs(nums, len, depath + 1, sum - nums[depath], target);
    }

    public static void main(String[] args) {
        System.out.println(new _494_目标和().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
