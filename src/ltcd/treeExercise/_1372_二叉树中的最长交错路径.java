package ltcd.treeExercise;

public class _1372_二叉树中的最长交错路径 {

    int ans = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root, true, 0);
        dfs(root, false, 0);
        return ans;
    }

    private void dfs(TreeNode root, boolean b, int len) {
        if (root == null) {
            return;
        }

        ans = Math.max(ans, len);

        if (b) {
            if (root.right != null) {//可以拐弯
                dfs(root.right, false, len + 1);
            }
            if (root.left != null) {//不拐弯
                dfs(root.left, true, 1);
            }
        } else {
            if (root.left != null) {//可以拐弯
                dfs(root.left, true, len + 1);
            }
            if (root.right != null) {//不拐弯
                dfs(root.right, false, 1);
            }
        }
    }

    //out time
    //true is left
    private void dfs1(TreeNode root, boolean b, int len) {
        if (root == null) {
            return;
        }

        if (b) {
            ans = Math.max(ans, len = 1);
            dfs(root.right, false, len + 1);
        } else {
            ans = Math.max(ans, len = 1);
            dfs(root.left, true, len + 1);
        }
    }

}
