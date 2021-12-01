package ltcd.treeExercise;

import java.util.LinkedList;
import java.util.List;

public class _1382_将二叉搜索树变平衡 {

    List<Integer> list = new LinkedList();

    public TreeNode balanceBST(TreeNode root) {
        dfs(root);

        return recur(0, list.size());
    }

    private TreeNode recur(int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = recur(0, mid - 1);
        root.right = recur(mid + 1, end);

        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);

        list.add(root.val);

        dfs(root.right);
    }

}
