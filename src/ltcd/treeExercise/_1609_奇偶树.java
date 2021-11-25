package ltcd.treeExercise;

import java.util.LinkedList;
import java.util.Queue;

public class _1609_奇偶树 {

    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelSize = queue.size();
        boolean flag = true;//is odd number or even number
        int pre = 0;

        while (!queue.isEmpty()) {
            levelSize = queue.size();
            flag = flag ? false : true;
            pre = flag ? queue.peek().val + 1 : queue.peek().val - 1;
            System.out.println(pre);

            while (levelSize-- > 0) {
                TreeNode pollNode = queue.poll();

                if (!flag && pre >= pollNode.val) {//is odd number, addition
                    return false;
                }

                if (flag && pre <= pollNode.val) {
                    return false;
                }

                pre = pollNode.val;

                if (pollNode.left != null) {
                    queue.offer(pollNode.left);
                }

                if (pollNode.right != null) {
                    queue.offer(pollNode.right);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(10);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(12);
        root.left.left.right = new TreeNode(8);

        root.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.left.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        root.right.right.right = new TreeNode(2);

        _1609_奇偶树 v = new _1609_奇偶树();
        v.isEvenOddTree(root);
        System.out.println();
    }

}
