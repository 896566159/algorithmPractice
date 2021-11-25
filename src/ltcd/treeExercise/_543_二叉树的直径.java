package ltcd.treeExercise;

public class _543_二叉树的直径 {

    int sum = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {

        dfs(root);
        return sum;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftValue = root.left == null ? 0 : dfs(root.left) + 1;
        int rightValue = root.right == null ? 0 : dfs(root.right) + 1;

        sum = Math.max(sum, leftValue + rightValue);

        return Math.max(leftValue, rightValue);
    }
}
