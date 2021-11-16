package ltcd.treeExercise;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _637_二叉树的层平均值 {

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        List<Double> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level_count = queue.size();
        double sum = 0;

        while (!queue.isEmpty()) {
            int level_size = level_count;

            while (level_count-- > 0) {
                TreeNode pollNode = queue.poll();
                sum += pollNode.val;

                if (pollNode.left != null) {
                    queue.add(pollNode.left);
                }

                if (pollNode.right != null) {
                    queue.add(pollNode.right);
                }
            }

            ans.add(sum/level_size);
            level_count = queue.size();
        }

        return ans;
    }

}
