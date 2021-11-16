package ltcd.treeExercise;

public class _98_验证二叉搜索树 {

    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }

        if (pre >= root.val) {
            return false;
        }
        pre = root.val;

        if (!isValidBST(root.right)) {
            return false;
        }

        return true;
    }

}
