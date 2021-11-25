package ltcd.treeExercise;

import java.util.LinkedList;
import java.util.List;

public class _剑指_Offer_34_二叉树中和为某一值的路径 {


    List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {

        List<Integer> path = new LinkedList<>();
        dfs(root, path, target);

        return ans;
    }

    private void dfs(TreeNode root, List<Integer> path, int target) {
        if (root == null) {
            return;
        }

        target -= root.val;
        path.add(root.val);

        if (target == 0 && root.left == null && root.right == null) {
            ans.add(new LinkedList<>(path));
        }

        dfs(root.left, path, target);
        dfs(root.right, path, target);

        path.remove(path.size() - 1);
    }

}
