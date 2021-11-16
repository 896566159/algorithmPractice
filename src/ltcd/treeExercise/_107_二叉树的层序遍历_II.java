package ltcd.treeExercise;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _107_二叉树的层序遍历_II {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        List<List<Integer>> ans = new LinkedList<>();
        int height = getHeight(root);
        for (int i = 0; i < height; i++) {
            ans.add(new LinkedList<>());
        }
        System.out.println(ans.size());
        helper(root, 0, ans);

        return ans;
    }

    private void helper(TreeNode root, int level, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }

        if (ans.size() + 1 > level) {
            ans.get(ans.size() - level).add(root.val);
            helper(root.left, level + 1, ans);
            helper(root.right, level + 1, ans);
        }

    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }


    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level_size = queue.size();

        while (!queue.isEmpty()) {
            List<Integer> tmp = new LinkedList<>();
            while (level_size-- > 0) {
                TreeNode pollNode = queue.poll();
                tmp.add(pollNode.val);

                if (pollNode.left != null) {
                    queue.add(pollNode.left);
                }

                if (pollNode.right != null) {
                    queue.add(pollNode.right);
                }
            }
            level_size = queue.size();
            ans.add(0, tmp);
        }

        return ans;
    }

}
