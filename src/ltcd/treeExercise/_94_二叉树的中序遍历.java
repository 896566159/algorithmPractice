package ltcd.treeExercise;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _94_二叉树的中序遍历 {

    static List<Integer> l = new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null) return new LinkedList<>();
        inorderTraversal(root.left);
        l.add(root.val);
        inorderTraversal(root.right);
        return l;
    }

    //This function will change the tree
    public static List<Integer> inorderTraversal1(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        Stack<TreeNode> stack = new Stack<>();
        //push root node onto stack
        stack.push(root);

        while (!stack.empty()) {

            //pop the accessed node
            TreeNode popNode = stack.pop();

            //left not null, push the accessed node, and push the accessed node's left
            if (popNode.left != null) {
                stack.push(popNode);
                stack.push(popNode.left);
                popNode.left = null;//have to make the left = null, otherwise will dead cycle
            }else {//left is null
                l.add(popNode.val);

                //left is null and right is not null: push the right node
                if (popNode.right != null){
                    stack.push(popNode.right);
                }
            }
        }

        return l;
    }

    //This function will not change the tree
    public static List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode popNode = stack.pop();
            l.add(popNode.val);
            root = popNode.right;
        }


        return l;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);

        System.out.println(inorderTraversal2(root));
    }

}
