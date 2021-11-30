package ltcd.treeExercise;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class _662_二叉树最大宽度 {

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        root.val = 0;
        queue.offer(root);
        int levelSize = queue.size();
        int maxWidth = 1;

        while (!queue.isEmpty()) {
            levelSize = queue.size();
            maxWidth = Math.max((queue.peekLast().val - queue.peekFirst().val), maxWidth);

            while (levelSize-- > 0) {
                TreeNode pollNode = queue.poll();

                if (pollNode.left != null) {
                    pollNode.left.val = 2 * pollNode.val + 1;
                    queue.offer(pollNode.left);
                }

                if (pollNode.right != null) {
                    pollNode.right.val = 2 * pollNode.val + 2;
                    queue.offer(pollNode.right);
                }
            }
        }

        return maxWidth;
    }

}
