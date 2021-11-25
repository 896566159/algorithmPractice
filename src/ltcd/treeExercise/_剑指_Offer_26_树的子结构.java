package ltcd.treeExercise;

public class _剑指_Offer_26_树的子结构 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (B == null || A == null) {
                return false;
            }

            return help(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

        private boolean help(TreeNode a, TreeNode b) {
            if (b == null) {
                return true;
            }

            if (a == null || a.val != b.val) {
                return false;
            }

            return help(a.left, b.left) && help(a.right, b.right);
        }

}
