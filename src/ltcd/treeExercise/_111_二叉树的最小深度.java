package ltcd.treeExercise;

import java.util.LinkedList;
import java.util.Queue;

public class _111_二叉树的最小深度 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ans = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level_size = queue.size();

        while (!queue.isEmpty()) {

            while (level_size-- > 0) {
                TreeNode pollNode = queue.poll();

                if (isLeaf(pollNode)) {
                    return ans;
                }

                if (pollNode.left != null) {
                    queue.add(pollNode.left);
                }

                if (pollNode.right != null) {
                    queue.add(pollNode.right);
                }
            }

            ans++;
            level_size = queue.size();
        }

        return  ans;
    }

    public boolean isLeaf(TreeNode node) {
        if (node.left == null & node.right == null) {
            return true;
        }
        return false;
    }


    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = minDepth1(root.left);
        int right = minDepth1(root.right);

        return  root.left == null || root.right == null ? left + right + 1 : left > right ? right + 1 : left + 1;
//        return  root.left == null || root.right == null ? left + right + 1 : Math.min(left, right) + 1;
    }
}
