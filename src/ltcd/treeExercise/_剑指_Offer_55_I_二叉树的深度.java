package ltcd.treeExercise;

import java.util.LinkedList;
import java.util.Queue;

public class _剑指_Offer_55_I_二叉树的深度 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;

        return left > right ? left : right;
    }


    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int height = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level_count = queue.size();//record the number of the level's nodes

        while (!queue.isEmpty()) {
            TreeNode pollNode = queue.poll();
            level_count--;

            if (pollNode.left != null) {
                queue.add(pollNode.left);
            }
            if (pollNode.right != null) {
                queue.add(pollNode.right);
            }

            if (level_count == 0) {
                height++;
                level_count = queue.size();
            }
        }

        return height;
    }

}
