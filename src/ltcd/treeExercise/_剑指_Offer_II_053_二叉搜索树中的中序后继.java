package ltcd.treeExercise;

public class _剑指_Offer_II_053_二叉搜索树中的中序后继 {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }

        TreeNode cur = root;
        TreeNode ans = null;

        while (cur != null) {
            if (cur.val > p.val) {
                ans = cur;
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        return ans;
    }

}
