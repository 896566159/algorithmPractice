package ltcd.classExercise;

import java.util.HashSet;
import java.util.Set;

public class _1261_在受污染的二叉树中查找元素 {

    TreeNode tree = null;
    Set<Integer> set = new HashSet<>();

    public _1261_在受污染的二叉树中查找元素(TreeNode root) {
        if (root == null) {
            tree = null;
        }

        root.val = 0;
        dfs(root.left, root.val, root);
        dfs(root.right, root.val, root);

        tree = root;
    }

    private void dfs(TreeNode root, int val, TreeNode pre) {
        if (root == null) {
            return;
        }

        if (pre.left == root) {
            root.val = 2 * val + 1;
            System.out.println(root.val);
        }

        if (pre.right == root) {
            root.val = 2 * val + 2;
        }

        set.add(root.val);
        dfs(root.left, 0, root);
        dfs(root.right, 0, root);
    }

    public boolean find(int target) {
        if (tree == null) {
            return false;
        }
        return set.contains(target);
    }

}
