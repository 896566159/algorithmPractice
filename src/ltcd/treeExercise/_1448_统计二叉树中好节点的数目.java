package ltcd.treeExercise;

public class _1448_统计二叉树中好节点的数目 {

    int count = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return count;
    }

    private void dfs(TreeNode root, int max) {
        if (root == null) {
            return;
        }

        if (root.val >= max) {
            count++;
            max = root.val;
        }

        dfs(root.left, max);
        dfs(root.right, max);
    }

}
