package ltcd.treeExercise;

public class _剑指_Offer_II_052_展平二叉搜索树 {

    public TreeNode increasingBST(TreeNode root) {
        root.right = dfs(root.right, root);
        root.left = dfs(root.left, root);

        if (root.left != null) {
            TreeNode p = root.left;
            TreeNode tree = root.left;
            TreeNode tmp = root;
            tmp.left = null;

            while (p.right != null) {
                p = p.right;
            }

            p.right = tmp;
            return tree;
        }
        return root;
    }

    private TreeNode dfs(TreeNode root, TreeNode pre) {
        if (root == null) {
            return null;
        }

        dfs(root.left, root);
        dfs(root.right, root);

        if (root.left != null) {
            TreeNode tmp = root.left;//
            root.left = null;//cut left

            if (pre != null) {
                boolean leftOrRight = pre.left == root;

                if (leftOrRight) {
                    pre.left = tmp;
                } else {
                    pre.right = tmp;
                }
            }

            TreeNode p = tmp;
            while (p.right != null) {
                p = p.right;
            }

            p.right = root;
            root = tmp;
        }

        return root;
    }

}
