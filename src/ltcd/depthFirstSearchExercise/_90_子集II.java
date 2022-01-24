package ltcd.depthFirstSearchExercise;

import java.util.*;

public class _90_子集II {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) {
            return new LinkedList<>();
        }

        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        Deque<Integer> path = new LinkedList<>();
        int len = nums.length;
        boolean[] used = new boolean[len];
        dfs(nums, 0, len, used, path, ans);

        ans.add(new LinkedList<>());
        return ans;
    }

    private void dfs(int[] nums, int begin, int len, boolean[] used, Deque<Integer> path, List<List<Integer>> ans) {
        if (begin == len) {
            return;
        }

        for (int i = begin; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            path.add(nums[i]);
            ans.add(new LinkedList<>(path));
            System.out.println("*******"+path);

            dfs(nums, i + 1, len, used, path, ans);

            used[i] = false;
            path.pollLast();
        }
    }

    public static void main(String[] args) {
        new _90_子集II().subsetsWithDup(new int[]{2,2});
    }

}
