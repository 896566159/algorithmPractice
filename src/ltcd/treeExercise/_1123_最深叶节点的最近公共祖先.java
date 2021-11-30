package ltcd.treeExercise;

public class _1123_最深叶节点的最近公共祖先 {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return null;
        }

//        int leftHeight = getHeight(root.left);
//        int rightHeight = getHeight(root.right);
//
//        if (leftHeight < rightHeight && root.right.left == null && root.right.right == null) {
//            return root.right;
//        }
//
//        if (leftHeight > rightHeight && root.left.left == null && root.left.right == null) {
//            return root.right;
//        }
//
//        if (leftHeight == 1 &&  rightHeight == 1) {
//            return root;
//        }
//
//        if (leftHeight == rightHeight) {
//            return root;
//        }
//
//        return leftHeight > rightHeight ? lcaDeepestLeaves(root.left) : lcaDeepestLeaves(root.right);

        if (getHeight(root.left) > getHeight(root.right)) {
            return lcaDeepestLeaves(root.left);
        } else if (getHeight(root.left) < getHeight(root.right)) {
            return lcaDeepestLeaves(root.right);
        } else {
            return root;
        }
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

}
