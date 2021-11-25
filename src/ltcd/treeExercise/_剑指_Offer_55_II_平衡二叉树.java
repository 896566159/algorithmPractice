package ltcd.treeExercise;

public class _剑指_Offer_55_II_平衡二叉树 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
            return false;
        }

        return isBalanced(root) && isBalanced(root.left) && isBalanced(root.right);
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getHeight(root.left) + 1;
        int right = getHeight(root.right) + 1;

        return Math.max(left, right);
    }

}
