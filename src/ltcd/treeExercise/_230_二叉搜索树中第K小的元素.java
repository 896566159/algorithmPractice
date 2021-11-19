package ltcd.treeExercise;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _230_二叉搜索树中第K小的元素 {

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }

        Deque<TreeNode> deque = new LinkedList<>();

        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.offerLast(root);
                root = root.left;
            }

            root = deque.pollLast();
            if (--k == 0) {
                return root.val;
            }

            root = root.right;
        }

        return -1;
    }

    public int kthSmallest1(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        dfs(queue, root);

        return queue.get(k - 1);
    }

    private void dfs(Queue<Integer> queue, TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(queue, root.left);
        queue.offer(root.val);
        dfs(queue, root.right);
    }

}
