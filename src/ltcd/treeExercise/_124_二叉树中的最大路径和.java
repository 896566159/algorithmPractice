package ltcd.treeExercise;

public class _124_二叉树中的最大路径和 {

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int mid = root.val;
        int left = maxPathSum(root.left);
        int right = maxPathSum(root.right);



        return ;
    }

}
