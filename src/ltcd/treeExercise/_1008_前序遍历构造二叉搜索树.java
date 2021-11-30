package ltcd.treeExercise;

public class _1008_前序遍历构造二叉搜索树 {

    public TreeNode bstFromPreorder(int[] preorder) {
        return recur(preorder, 0, preorder.length - 1);
    }

    private TreeNode recur(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[start]);

        int mid = start + 1;
        while (mid <= end) {
            if (preorder[mid] > preorder[start]) {
                break;
            }
            mid++;
        }

        root.left = recur(preorder, start + 1, mid - 1);
        root.right = recur(preorder, mid, end);

        return root;
    }

}
