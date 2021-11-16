package ltcd.treeExercise;

public class _剑指_Offer_28_对称的二叉树 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode root1, TreeNode root2) {
        if (root1 == null & root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return true;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return helper(root1.left, root2.right) & helper(root1.right, root2.left);
    }


}
