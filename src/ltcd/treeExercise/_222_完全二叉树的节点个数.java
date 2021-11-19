package ltcd.treeExercise;

import java.util.Stack;

public class _222_完全二叉树的节点个数 {

    public int countNodes(TreeNode root) {

        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;

        while (p != null || !stack.isEmpty()) {

            while (p != null) {
                stack.push(p);
                p = p.left;
            }

            TreeNode popNode = stack.pop();
            count++;

            p = popNode.right;
        }

        return count;
    }

}
