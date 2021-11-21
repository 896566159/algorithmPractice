package ltcd.treeExercise.difficult;

import java.util.LinkedList;
import java.util.Queue;

public class _112_路径总和 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null && targetSum - root.val == 0) {
            return true;
        }

        targetSum -= root.val;
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }

    public boolean BFShasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> nodeQue = new LinkedList<>();
        nodeQue.offer(root);
        Queue<Integer> sumQue = new LinkedList<>();
        sumQue.offer(0);
        int levelSize = nodeQue.size();

        while (!nodeQue.isEmpty()) {
            while (levelSize-- > 0) {
                TreeNode pollNode = nodeQue.poll();
                Integer pollSum = sumQue.poll();

                if (pollNode.left == null && pollNode.right == null && pollNode.val + pollSum == targetSum) {
                    return true;
                }

                if (pollNode.left != null) {
                    nodeQue.offer(pollNode.left);
                    sumQue.offer(pollSum + pollNode.val);
                }

                if (pollNode.right != null) {
                    nodeQue.offer(pollNode.right);
                    sumQue.offer(pollSum + pollNode.val);
                }
            }

            levelSize = nodeQue.size();
        }

        return false;
    }

}
