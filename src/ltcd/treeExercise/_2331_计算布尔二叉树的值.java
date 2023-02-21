package ltcd.treeExercise;

public class _2331_计算布尔二叉树的值 {

    public boolean evaluateTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }

        boolean evaluateLeft = evaluateTree(root.left);
        boolean evaluateRight = evaluateTree(root.right);

        return root.val == 2 ? evaluateLeft || evaluateRight : evaluateLeft && evaluateRight;
//        if (root.val == 2) {
//            return evaluateLeft || evaluateRight;
//        } else {
//            return evaluateLeft && evaluateRight;
//        }
    }

}
