package ltcd.treeExercise;

import java.util.LinkedList;
import java.util.Queue;

public class _剑指_Offer_II_045_二叉树最底层最左边的值 {


    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelSize = queue.size();

        while (!queue.isEmpty()) {
            res = queue.peek().val;
            levelSize = queue.size();

            while (levelSize-- > 0) {
                TreeNode pollNode = queue.poll();

                if (pollNode.left != null) {
                    queue.offer(pollNode.left);
                }

                if (pollNode.right != null) {
                    queue.offer(pollNode.right);
                }
            }
        }

        return res;
    }

}
