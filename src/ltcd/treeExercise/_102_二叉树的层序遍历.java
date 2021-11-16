package ltcd.treeExercise;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102_二叉树的层序遍历 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level_count = queue.size();
        List<Integer> level = new LinkedList<>();

        while(!queue.isEmpty()){
            TreeNode pollNode = queue.poll();
            level.add(pollNode.val);

            if (pollNode.left != null) {
                queue.offer(pollNode.left);
            }

            if (pollNode.right != null) {
                queue.offer(pollNode.right);
            }

            if (--level_count == 0) {
                level_count = queue.size();
                ans.add(new LinkedList<Integer>(level));
                level.clear();
            }
        }

        return ans;
    }

}
