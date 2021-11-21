package ltcd.treeExercise;

import java.util.LinkedList;
import java.util.Queue;

public class _面试题_04_03_特定深度节点链表 {

    public ListNode[] listOfDepth(TreeNode tree) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        int levelSize = queue.size();
        int height = getHeight(tree);
        ListNode[] listNodes = new ListNode[height];
        height = 0;

        while (!queue.isEmpty()) {
            levelSize = queue.size();
            ListNode node = new ListNode();
            ListNode head = node;

            while (levelSize-- > 0) {
                TreeNode pollNode = queue.poll();

                node.next = new ListNode(pollNode.val);
                node = node.next;

                if (pollNode.left != null) {
                    queue.offer(pollNode.left);
                }

                if (pollNode.right != null) {
                    queue.offer(pollNode.right);
                }
            }

            listNodes[height++] = head.next;
        }

        return listNodes;
    }

    private int getHeight(TreeNode tree) {
        if (tree == null) {
            return 0;
        }

        int left = getHeight(tree.left);
        int right = getHeight(tree.right);

        return 1 + Math.max(left, right);
    }


}
