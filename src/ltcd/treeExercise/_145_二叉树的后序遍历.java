package ltcd.treeExercise;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _145_二叉树的后序遍历 {

    List<Integer> list = new LinkedList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);

        return list;
    }

    public static List<Integer> postorderTraversal1(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = root;//distinguish the right node has been accessed

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode popNode = stack.pop();
            if (popNode.right == null || prev == popNode.right) {
                list.add(popNode.val);
                prev = popNode;
                popNode = null;
            } else {
                stack.push(popNode);
                root = popNode.right;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);

        System.out.println(postorderTraversal1(root));
    }

}
