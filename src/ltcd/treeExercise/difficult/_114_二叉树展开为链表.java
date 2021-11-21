package ltcd.treeExercise;


import java.util.Stack;

public class _114_二叉树展开为链表 {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.right);
        flatten(root.left);

        if (root.left != null) {
            TreeNode tmp = root.right;
            root.right = root.left;
            root.left = null;
            while (root.right != null) {
                root = root.right;
            }
            root.right = tmp;
        }

    }

}
