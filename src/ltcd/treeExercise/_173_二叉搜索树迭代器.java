package ltcd.treeExercise;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _173_二叉搜索树迭代器 {

    Deque<Integer> deque = new LinkedList<>();

    public _173_二叉搜索树迭代器(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;

        while (p != null || !stack.isEmpty()) {

            while (p != null) {
                stack.push(p);
                p = p.left;
            }

            TreeNode popNode = stack.pop();
            deque.add(popNode.val);

            p = popNode.right;
        }

    }

    public int next() {
        return deque.pop();
    }

    public boolean hasNext() {
        return !deque.isEmpty();
    }

}
