package ltcd.treeExercise;

public class _剑指_Offer_II_054_所有大于等于节点的值之和 {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            root.val += sum;
            sum += root.val;
            convertBST(root.left);
        }

        return root;
    }

}
