package ltcd.treeExercise;

import java.util.LinkedList;
import java.util.List;

public class _998_最大二叉树_II {


    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val < val) {
            return new TreeNode(val, root, null);
        } else {
            root.right = insertIntoMaxTree(root.right, val);
        }

        return root;
    }

}
