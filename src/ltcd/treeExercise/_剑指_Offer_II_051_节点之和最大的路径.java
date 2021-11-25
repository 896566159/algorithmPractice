package ltcd.treeExercise;

public class _剑指_Offer_II_051_节点之和最大的路径 {

    int res = 0;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root ==null){
            return 0;
        }

        int left = Math.max(maxPathSum(root.left), 0);
        int right = Math.max(maxPathSum(root.right), 0);

        res = Math.max(res, root.val + left + right);

        return root.val + Math.max(left, right);
    }

}
