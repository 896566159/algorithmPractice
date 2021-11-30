package ltcd.treeExercise;

import java.util.HashSet;
import java.util.Set;

public class _1457_二叉树中的伪回文路径 {

    int count = 0;
    Set<Integer> set = new HashSet<>();

    public int pseudoPalindromicPaths (TreeNode root) {

        dfs(root);
        return count;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        if (set.contains(root.val)) {
            set.remove(root.val);
        } else {
            set.add(root.val);
        }

        if (root.left == null && root.right == null) {
            if (set.size() == 1) {
                count++;
                    System.out.println(set);
            }
        }

        dfs(root.left);
        dfs(root.right);

        set.remove(root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);

        root.right = new TreeNode(1);
        root.right.right = new TreeNode(1);

        _1457_二叉树中的伪回文路径 v = new _1457_二叉树中的伪回文路径();
        v.pseudoPalindromicPaths(root);
    }

}
