package ltcd.treeExercise.difficult;

import java.util.LinkedList;
import java.util.List;

public class _257_二叉树的所有路径 {

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        List<String> res = new LinkedList<>();
        String path = new String();

        dfs(root, res, path);
        return res;
    }

    private void dfs(TreeNode root, List<String> res, String path) {
        if (root == null) {
            return;
        }

        if (root.left == null & root.right == null) {
            res.add(path + root.val);
            return;
        }

        dfs(root.left, res, path + root.val + "->");
        dfs(root.right, res, path + root.val + "->");
    }

}
