package ltcd.treeExercise;

import java.util.Stack;

public class _面试题_17_12_BiNode {

    TreeNode previous = null;

    public TreeNode convertBiNode(TreeNode root) {
        if (root == null) {
            return null;
        }

        convertBiNode(root.right);

        root.right = previous;
        previous = root;

        convertBiNode(root.left);

        root.left = null;

        return root;
    }

    public TreeNode convertBiNode1(TreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode head = null;
        TreeNode pre = null;

        while (node != null || !stack.isEmpty()) {

            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (pre == null) {
                head = node;
            } else {
                pre.right = node;
                node.left = null;//left change to null
            }
            pre = node;

            node = node.right;
        }

        return head;
    }

}
