package ltcd.treeExercise;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _113_路径总和_II {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new LinkedList<>();
        }

        List<List<Integer>> res = new LinkedList<>();
        Deque<Integer> path = new LinkedList<>();

        dfs(root, targetSum, res, path);
        return res;
    }

    private void dfs(TreeNode root, int targetSum, List<List<Integer>> res, Deque<Integer> path) {
        if (root == null) {
            return;
        }

        path.addLast(root.val);
        targetSum -= root.val;

        if (root.left == null && root.right == null &&  targetSum - root.val == 0) {
            res.add(new LinkedList<>(path));
        }

        dfs(root.left, targetSum, res, path);
        dfs(root.right, targetSum, res, path);

        path.pollLast();
    }
}
