package ltcd.treeExercise;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _199_二叉树的右视图 {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        List<Integer> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level_count = queue.size();
        int right = 0;

        while (!queue.isEmpty()) {

            while (level_count-- > 0) {
                TreeNode pollNode = queue.poll();
                right = pollNode.val;

                if (pollNode.left != null) {
                    queue.add(pollNode.left);
                }

                if (pollNode.right != null) {
                    queue.add(pollNode.right);
                }
            }
            ans.add(right);
            level_count = queue.size();
        }

        return ans;
    }

}
