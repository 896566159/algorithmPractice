package ltcd.treeExercise;

public class _938_二叉搜索树的范围和 {

    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        dfs(root, low, high);

        return sum;
    }

    private void dfs(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }

        if (root.val <= high & root.val >= low) {
            sum += root.val;
        }

        dfs(root.left, low, high);
        dfs(root.right, low, high);
    }

}
