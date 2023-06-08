package ltcd.treeExercise;

public class _1080_根到叶路径上的不足节点 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(-3);
        node.right.left = new TreeNode(4);
        node.left.left = new TreeNode(-5);

        _1080_根到叶路径上的不足节点 v = new _1080_根到叶路径上的不足节点();
        v.sufficientSubset(node, -1);
    }

    TreeNode res;

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        limit -= root.val;

        // 叶子节点
        if (root.left == null && root.right == null) {
            return limit > 0 ? null : root;
        }

        // 处理左子树
        if (root.left != null) {
            root.left = sufficientSubset(root.left, limit);
        }

        // 处理右子树
        if (root.right != null) {
            root.right = sufficientSubset(root.right, limit);
        }

        // 如果左右儿子都被删除，则root也删除
        return root.left == null && root.right == null ? null : root;
    }
}
