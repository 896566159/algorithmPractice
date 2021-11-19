package ltcd.treeExercise;

public class _105_从前序与中序遍历序列构造二叉树 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length || inorder.length == 0) {
            return null;
        }

        return help(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode help(int[] preorder, int[] inorder, int rootIndex, int start, int end) {
        if (rootIndex == preorder.length || start > end || start < 0 || end >= inorder.length) {
            return null;
        }

        if (start == end) {
            return new TreeNode(inorder[start]);
        }

        TreeNode root = new TreeNode(preorder[rootIndex]);
        int mid = 0;
        for (int i = start; i <= end; i++) {
            if (inorder[i] == preorder[rootIndex]) {
                mid = i;
                break;
            }
        }
        root.left = help(preorder, inorder, rootIndex + 1, start,mid - 1);
        root.right = help(preorder, inorder, mid - start, mid + 1, end);

        return root;
    }

}
