package ltcd.treeExercise;

public class _面试题_0406_后继者 {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || (root.left == null && root.right == null)) {
            return null;
        }

        TreeNode target = root;
        TreeNode parent = null;

        //找到节点
        while (p.val != target.val) {

            if (p.val > target.val) {
                target = target.right;
            } else if (p.val < target.val) {
                parent = target;
                target = target.left;
            }
        }

        //如果右子树——右子树中的最左
        if (target.right != null) {
            target = target.right;
            while (target.left != null) {
                target = target.left;
            }

            return target;
        }

        return parent;
    }

}
