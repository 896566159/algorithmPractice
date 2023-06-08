package ltcd.treeExercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _1110_删点成林 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        _1110_删点成林 v = new _1110_删点成林();
        v.delNodes(root, new int[]{3, 5});
    }


    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        Set<Integer> s = new HashSet<>();
        for (int i : to_delete) {
            s.add(i);
        }

        if (dfs(ans, s, root) != null) {
            ans.add(root);
        }

        return ans;
    }

    private TreeNode dfs(List<TreeNode> ans, Set<Integer> s, TreeNode node) {
        if (node == null) {
            return node;
        }

        node.left = dfs(ans, s, node.left);
        node.right = dfs(ans, s, node.right);

        // 如果改点不会被删除，则返回
        if (!s.contains(node.val)) {
            return node;
        }

        if (node.left != null) {
            ans.add(node.left);
        }

        if (node.right != null) {
            ans.add(node.right);
        }

        // 改节点会被删除，返回空
        return null;
    }

}
