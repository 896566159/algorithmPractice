package ltcd.treeExercise;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _剑指_Offer_27_二叉树的镜像 {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;

        root.left = mirrorTree(root.right);
        root.right = mirrorTree(root.left);
        return root;
    }

    //preorderTraserval
    public TreeNode mirrorTree1(TreeNode root) {
        if (root == null) return null;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = null;
        TreeNode p = root;

        while (p != null || !stack.isEmpty()){
            while (p != null) {

                //swap the left and right tree
                node = p.left;
                p.left = p.right;
                p.right = node;

                //push the right and change the root to the left tree
                stack.push(p.right);
                p = p.left;
            }
            p = stack.pop();
        }

        return root;
    }

    //inorderTraserval
    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null) return null;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = null;
        TreeNode p = root;

        while (p != null || !stack.isEmpty()){
            while (p != null) {
                stack.push(p.left);
                p = p.right;
            }
            p = stack.pop();
        }

        return root;
    }

}
