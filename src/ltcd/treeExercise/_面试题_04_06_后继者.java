package ltcd.treeExercise;

import java.util.LinkedList;
import java.util.Stack;

public class _面试题_04_06_后继者 {

    boolean flag = false;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }

        TreeNode pointer = root;
        Stack<TreeNode> stack = new Stack<>();

        while (pointer != null || !stack.isEmpty()) {

            while (pointer != null) {
                stack.push(pointer);
                pointer = pointer.left;
            }

            TreeNode popNode = stack.pop();
            if (flag) {
                return popNode;
            }

            if (popNode.val == p.val) {
                flag = true;
            }

            if (popNode.right != null) {
                pointer = popNode.right;
            }
        }

        return null;
    }

}
