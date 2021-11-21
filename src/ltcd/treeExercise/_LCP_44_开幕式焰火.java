package ltcd.treeExercise;


import java.util.HashSet;
import java.util.Set;

public class _LCP_44_开幕式焰火 {

    Set<Integer> set = new HashSet<>();

    public int numColor(TreeNode root) {

        dfs(root);
        return set.size();
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        if (!set.contains(root.val)) {
            set.add(root.val);
        }

        dfs(root.left);
        dfs(root.right);
    }

}
