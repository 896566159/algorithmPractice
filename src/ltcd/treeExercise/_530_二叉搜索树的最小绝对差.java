package ltcd.treeExercise;

public class _530_二叉搜索树的最小绝对差 {

    int min = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return min;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);

        if (pre != null) {
            min = min < Math.abs(root.val - pre.val) ? min : Math.abs(root.val - pre.val);
        }
        pre = root;

        dfs(root.right);
    }

}
