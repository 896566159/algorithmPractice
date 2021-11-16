package ltcd.treeExercise;

public class _783_二叉搜索树节点最小距离 {

    int pre = Integer.MAX_VALUE;
    int res = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return 0;
        }

        minDiffInBST(root.left);
        res = Math.abs(root.val - pre) > res ? res : Math.abs(root.val - pre);
        pre = root.val;
        minDiffInBST(root.right);

        return res;
    }

}
