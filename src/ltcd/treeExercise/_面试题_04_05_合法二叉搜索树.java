package ltcd.treeExercise;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _面试题_04_05_合法二叉搜索树 {

    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        return dfs(root);
    }

    private boolean dfs(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!dfs(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;

        if (!dfs(root.right)) {
            return false;
        }

        return true;
    }


    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode p = root;
        long pre = Long.MIN_VALUE;

        while (!stack.isEmpty() || p != null) {

            while (p != null) {
                stack.push(p);
                p = p.left;
            }

            p = stack.pop();
            if (p.val <= pre) {
                return false;
            }
            pre = p.val;
            p = p.right;
        }

        return true;
    }

}
