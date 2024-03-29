package ltcd.treeExercise;

public class _1379_找出克隆二叉树中的相同节点 {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) {
            return null;
        }

        if (original == target) {
            return cloned;
        }

        TreeNode left = getTargetCopy(original.left, cloned.left, target);

        return left == null ? getTargetCopy(original.right, cloned.right, target) : left;
    }

}
