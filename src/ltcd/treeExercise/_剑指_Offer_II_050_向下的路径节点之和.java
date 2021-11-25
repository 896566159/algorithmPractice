package ltcd.treeExercise;

public class _剑指_Offer_II_050_向下的路径节点之和 {

    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        help(root, targetSum);
        return count;
    }

    private void help(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        dfs(root, 0, targetSum);
        help(root.left,  targetSum);
        help(root.right,  targetSum);
    }

    private void dfs(TreeNode root, int sum, int targetSum) {
        if (root == null) {
            return;
        }

        sum += root.val;
        if (sum == targetSum) {
            count++;
        }

        dfs(root.left, sum, targetSum);
        dfs(root.right, sum, targetSum);
    }

}
