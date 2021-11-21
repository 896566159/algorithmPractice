package ltcd.treeExercise.difficult;

public class _124_二叉树中的最大路径和 {

    int sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        dfs(root);
        return sum;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftValue = Math.max(dfs(root.left), 0);
        int rightValue = Math.max(dfs(root.right), 0);

        sum = Math.max(sum, root.val + leftValue + rightValue);

        return root.val + Math.max(leftValue, rightValue);
    }

}
