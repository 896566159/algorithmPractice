package ltcd.treeExercise;

public class _1026_节点与其祖先之间的最大差值 {
    int res = 0;
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, root.val, root.val);
        return res;
    }

    private void dfs(TreeNode root, int max, int min) {
        if (root == null) {
            return;
        }

        res = Math.max(res, Math.max(Math.abs(root.val - max), Math.abs(root.val - min)));
        if (max < root.val) {
            max = root.val;
        }

        if (min > root.val) {
            min = root.val;
        }

        dfs(root.left, max, min);
        dfs(root.right, max, min);
    }

}
