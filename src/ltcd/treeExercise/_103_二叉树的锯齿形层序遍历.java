package ltcd.treeExercise;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _103_二叉树的锯齿形层序遍历 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean direction = true;

        while(!queue.isEmpty()) {
            int level_count = queue.size();
            LinkedList<Integer> list = new LinkedList<>();

            while(level_count-- > 0) {
                TreeNode pollNode = queue.poll();

                if (pollNode.left != null) {
                    queue.add(pollNode.left);
                }
                if (pollNode.right != null) {
                    queue.add(pollNode.right);
                }

                if (direction) {
                    list.add(pollNode.val);
                } else {
                    list.addFirst(pollNode.val);
                }
            }

            level_count = queue.size();
            ans.add(new LinkedList<>(list));
            direction = direction ? false : true;
            list.clear();
        }

        return ans;
    }

}
