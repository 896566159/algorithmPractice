package ltcd.treeExercise.difficult;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _235_二叉搜索树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }









    List<List<TreeNode>> paths = new LinkedList<>();

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        Deque<TreeNode> path = new LinkedList<>();

        dfs(root, path, p, q);

        int index = 0;
        while (index < paths.get(0).size() && index < paths.get(0).size()) {
            if (paths.get(0).get(index).val != paths.get(1).get(index).val) {
                return paths.get(0).get(index);
            }

            index++;
        }

        if (index >= paths.get(0).size()) {
            return paths.get(0).get(paths.get(0).size() - 1);
        }

        if (index >= paths.get(1).size()) {
            return paths.get(1).get(paths.get(1).size() - 1);
        }

        return root;
    }

    private void dfs(TreeNode root, Deque<TreeNode> path, TreeNode p, TreeNode q) {
        if (root == null) {
            return;
        }

        path.addLast(root);

        if (root.val == q.val || root.val == p.val) {
            paths.add(new LinkedList<>(path));
            return;
        }

        dfs(root.left, path, p, q);
        dfs(root.right, path, p, q);

        path.removeLast();
    }
}
