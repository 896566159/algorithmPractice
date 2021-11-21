package ltcd.treeExercise.difficult;

public class _563_二叉树的坡度 {

    int sum = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return sum;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int lv = dfs(node.left);
        int rv = dfs(node.right);

        sum += Math.abs(lv - rv);

        return lv + rv + node.val;
    }

}
