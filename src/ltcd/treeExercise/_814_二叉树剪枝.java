package ltcd.treeExercise;

public class _814_二叉树剪枝 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }

        return root;
    }

    public TreeNode pruneTree1(TreeNode root) {
        if (root == null) {
            return null;
        }

        dfs(root, null);
        return root;
    }

    private TreeNode dfs(TreeNode root, TreeNode pre) {
        if (root == null) {
            return null;
        }

        dfs(root.left, root);
        dfs(root.right, root);

        if (root.left == null && root.right == null && root.val == 0) {
            if (pre != null && pre.left == root) {
                pre.left = null;
            }

            if (pre != null && pre.right == root) {
                pre.right = null;
            }
        }

        return root;
    }

}
