package ltcd.treeExercise;

import java.util.LinkedList;
import java.util.Queue;

public class _1302_层数最深叶子节点的和 {

    int sum = 0;
    int maxlevel = 0;

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int level = 0;
        dfs(root.left, level);
        dfs(root.right, level);

        return sum;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (level > maxlevel) {
            maxlevel = level;
            sum = 0;
        }

        if (level == maxlevel) {
            sum += root.val;
        }

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    public int deepestLeavesSum1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int level_sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level_size = queue.size();

        while (!queue.isEmpty()) {
            level_sum = 0;

            while (level_size-- > 0) {
                TreeNode pollNode = queue.poll();
                level_sum += pollNode.val;

                if (pollNode.left != null) {
                    queue.add(pollNode.left);
                }

                if (pollNode.right != null) {
                    queue.add(pollNode.right);
                }
            }

            level_size = queue.size();
        }

        return level_sum;
    }

}
