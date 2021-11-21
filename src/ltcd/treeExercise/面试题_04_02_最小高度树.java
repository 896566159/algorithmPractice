package ltcd.treeExercise;

public class _1038_把二叉搜索树转换为累加树 {

    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if(root == null) {
            return null;
        }

        bstToGst(root.right);
        sum += root.val;
        root.val = sum;
        bstToGst(root.left);
        return root;
    }

}
