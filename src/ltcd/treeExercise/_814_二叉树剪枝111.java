package ltcd.treeExercise;

public class _814_二叉树剪枝111 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        dfs(root.left, root);
        dfs(root.right, root);

        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }

        return root;
    }

    private void dfs(TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            dfs(node.left, node);
        }

        if (node.right != null) {
            dfs(node.right, node);
        }

        if (node.val == 0 && node.left == null && node.right == null) {
            if (parent.right == node) {
                parent.right = null;
            } else {
                parent.left = null;
            }
        }
    }

}
