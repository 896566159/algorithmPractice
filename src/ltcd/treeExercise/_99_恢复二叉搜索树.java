package ltcd.treeExercise;

public class _99_恢复二叉搜索树 {

    TreeNode pre1 = null;
    TreeNode pre2 = null;
    TreeNode pre = null;

    public void recoverTree(TreeNode root) {

        help(root);
        if (pre1 != null && pre2 != null) {
            int tmp = pre1.val;
            pre1.val = pre2.val;
            pre2.val = tmp;
        }
    }

    public void help(TreeNode node) {
        if (node == null) {
            return;
        }

        help(node.left);

        if (pre != null && pre.val > node.val) {
            pre1 = node;
            if (pre2 == null) {
                pre2 = pre;
            }
        }
        pre = node;

        help(node.right);
    }

}
