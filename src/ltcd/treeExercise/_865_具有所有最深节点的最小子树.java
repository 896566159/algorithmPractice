package ltcd.treeExercise;

public class _865_具有所有最深节点的最小子树 {

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return null;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        if (left > right) {
            return subtreeWithAllDeepest(root.left);
        } else if (left < right){
            return subtreeWithAllDeepest(root.right);
        } else {
            return root;
        }
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

}
