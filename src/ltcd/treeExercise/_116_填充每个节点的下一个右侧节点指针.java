package ltcd.treeExercise;

import java.util.LinkedList;
import java.util.Queue;

public class _116_填充每个节点的下一个右侧节点指针 {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int levelSize = queue.size();
        Node pre = null;

        while (!queue.isEmpty()) {

            while (levelSize-- > 0) {
                Node pollNode = queue.poll();

                if (pre == null) {
                    pollNode.next = null;
                } else {
                    pre.next = pollNode;
                }

                pre = pollNode;

                if (pollNode.left != null) {
                    queue.offer(pollNode.left);
                }

                if (pollNode.right != null) {
                    queue.offer(pollNode.right);
                }
            }

            pre = null;
            levelSize = queue.size();
        }

        return root;
    }

}
