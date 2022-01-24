package ltcd.depthFirstSearchExercise;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _剑指_Offer_II_084_含有重复元素集合的全排列 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return new LinkedList<>();
        }

        Arrays.sort(nums);//排序，以便于剪枝
        List<List<Integer>> ans = new LinkedList<>();
        int len = nums.length;
        boolean[] used = new boolean[len];
        List<Integer> path = new LinkedList<>();

        dfs(nums, len, 0, used, path, ans);

        return ans;
    }

    private void dfs(int[] nums, int len, int depth, boolean[] used, List<Integer> path, List<List<Integer>> ans) {
        if (depth == len) {
            ans.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }

            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            used[i] = true;

            dfs(nums, len, depth + 1, used, path, ans);

            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 3};
        _剑指_Offer_II_084_含有重复元素集合的全排列 solution = new _剑指_Offer_II_084_含有重复元素集合的全排列();
        List<List<Integer>> lists = solution.permuteUnique(nums);
        System.out.println(lists);
    }

}
