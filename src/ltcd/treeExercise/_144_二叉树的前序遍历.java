package ltcd.treeExercise;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _144_二叉树的前序遍历 {

    public static List<Integer> preorderTraversal1(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.isEmpty()){
            while (root != null) {
                list.add(root.val);
                stack.push(root.right);
                root = root.left;
            }
            root = stack.pop();
        }

        return list;
    }

    static List<Integer> list = new LinkedList<>();
    public static List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);

        System.out.println(preorderTraversal(root));
    }

}
