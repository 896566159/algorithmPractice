package ltcd.treeExercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class _919_完全二叉树插入器 {

    TreeNode root;
    Deque<TreeNode> deque;

    public _919_完全二叉树插入器(TreeNode root) {
        this.root = root;
        deque = new ArrayDeque<>();
        //采用层序遍历 找到没有叶子结点的结点存放到队列中
        //只有这些结点才可以添加结点
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();

            if (poll.left == null || poll.right == null) {
                deque.offer(poll);
            }

            if (poll.left != null) {
                queue.offer(poll.left);
            }

            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
    }

    public int insert(int v) {
        TreeNode node = deque.peekFirst();
        TreeNode child = new TreeNode(v);

        if (node.left == null) {
            node.left = child;
        }

        if (node.right == null) {
            node.right = child;
            deque.pop();
        }

        return node.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
