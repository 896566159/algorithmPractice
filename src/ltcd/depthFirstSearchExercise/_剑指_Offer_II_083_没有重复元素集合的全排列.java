package ltcd.depthFirstSearchExercise;

import java.util.LinkedList;
import java.util.List;

public class _剑指_Offer_II_083_没有重复元素集合的全排列 {

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return new LinkedList<>();
        }

        List<List<Integer>> ans = new LinkedList<>();
        int len = nums.length;
        boolean[] used = new boolean[len];
        List<Integer> path = new LinkedList<>();

        dfs(nums, len, 0, path, used, ans);

        return ans;
    }

    private void dfs(int[] nums, int len, int depth, List<Integer> path, boolean[] used, List<List<Integer>> ans) {
        if (depth == len) {//递归达到了叶子结点，应该终止当前的递归
            ans.add(new LinkedList<>(path));
            return;
        }

        //在非叶子节点处，产生不同的分支：在还未选择的书中一次选择一个元素作为下一个位置的元素（循环）
        for (int i = 0; i < len; i++) {
            if (!used[i]) {//如果当前下标对应的数据还没有没选择过
                path.add(nums[i]);
                used[i] = true;//标记当前下标数已经使用过了

                //递归直到path的长度和nums的长度相等（所有数据都被使用了一遍）
                dfs(nums, len, depth + 1, path, used, ans);

                //上一次的递归已经达到：path的长度和nums的长度相等，需要回溯，将状态值重置
                used[i] = false;//当前被使用的数，将其状态重置为未使用的状态
                path.remove(path.size() - 1);//当前被使用的数，将重置为为被选择的状态

            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        _剑指_Offer_II_083_没有重复元素集合的全排列 solution = new _剑指_Offer_II_083_没有重复元素集合的全排列();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }

}
