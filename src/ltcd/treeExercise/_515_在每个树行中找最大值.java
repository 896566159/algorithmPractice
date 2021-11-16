package ltcd.treeExercise;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _515_在每个树行中找最大值 {

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        List<Integer> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level_count = queue.size();
        int level_max = 0;

        while (!queue.isEmpty()) {
            level_max = queue.peek().val;

            while (level_count-- > 0) {
                TreeNode pollNode = queue.poll();
                level_max = level_max > pollNode.val ? level_max : pollNode.val;

                if (pollNode.left != null) {
                    queue.add(pollNode.left);
                }

                if (pollNode.right != null) {
                    queue.add(pollNode.right);
                }
            }

            level_count = queue.size();
            ans.add(level_max);
        }

        return ans;
    }

}
