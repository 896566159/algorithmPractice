package ltcd.treeExercise;

public class _687_最长同值路径 {

    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        }

        int leftPath = root.left == null ? 0 : dfs(root.left) + 1;
        int rightPath = root.right == null ? 0 : dfs(root.right) + 1;

        if (root.left != null && root.val != root.left.val) {
            leftPath = 0;
        }

        if (root.right != null && root.val != root.right.val) {
            rightPath = 0;
        }

        ans = Math.max(leftPath, rightPath);

        return Math.min(leftPath, rightPath);
    }


//    private int dfs(TreeNode root) {
//        if (root.left == null && root.right == null) {
//            return 0;
//        }
//
//        int leftPath = root.left == null ? 0 : dfs(root.left) + 1;
//        int rightPath = root.right == null ? 0 : dfs(root.right) + 1;
//
//        if (leftPath > 0 && root.left.val != root.val) {
//            // 唯一的区别在这里，按照上题思路求出了左边边长后， 如果当前节点和左孩子节点不同值，就把边长重新赋值为0。
//            leftPath = 0;
//        }
//        if (rightPath > 0 && root.right.val != root.val) {
//            // 同上。
//            rightPath = 0;
//        }
//
//        ans = Math.max(ans, leftPath + rightPath);
//
//        return Math.max(leftPath, rightPath);
//    }

}
