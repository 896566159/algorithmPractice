package ltcd.treeExercise;

import java.util.HashMap;
import java.util.Map;

public class _106_从中序与后序遍历序列构造二叉树 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return help1(postorder, map, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode help1(int[] postorder, Map<Integer, Integer> map, int rootIndexOfPostorder, int startOfInorder, int endOfInorder) {
        if (startOfInorder > endOfInorder || rootIndexOfPostorder < 0 || rootIndexOfPostorder >= postorder.length) {
            return null;
        }

        if (startOfInorder == endOfInorder) {
            return new TreeNode(postorder[rootIndexOfPostorder]);
        }

        TreeNode root = new TreeNode(postorder[rootIndexOfPostorder]);
        Integer mid = map.get(postorder[rootIndexOfPostorder]);

        root.right = help1(postorder, map, rootIndexOfPostorder - 1, mid + 1, endOfInorder);
        root.left = help1(postorder, map, rootIndexOfPostorder - (endOfInorder - mid) - 1, startOfInorder, mid - 1);

        return root;
    }

    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }

        return help(postorder, inorder, postorder.length - 1, 0, inorder.length - 1);
    }

    /**
     * use the postorder and inorder traversal to build the tree
     * @param postorder postorder traversal
     * @param inorder inorder traversal
     * @param rootIndexOfPostorder the tree index of postorder traversal
     * @param startOfInorder the nodes of the inorder traversal start bound
     * @param endOfInorder the nodes of the inorder traversal end bound
     * @return the tree's root node
     */
    private TreeNode help(int[] postorder, int[] inorder, int rootIndexOfPostorder, int startOfInorder, int endOfInorder) {
        if (startOfInorder > endOfInorder || rootIndexOfPostorder < 0 || rootIndexOfPostorder >= postorder.length) {
            return null;
        }

        if (startOfInorder == endOfInorder) {
            return new TreeNode(inorder[startOfInorder]);
        }

        TreeNode root = new TreeNode(postorder[rootIndexOfPostorder]);
        int mid = 0;
        for (int i = startOfInorder; i < inorder.length; i++) {
            if (inorder[i] == postorder[rootIndexOfPostorder]) {
                mid = i;
                break;
            }
        }


        root.right = help(postorder, inorder, rootIndexOfPostorder - 1, mid + 1, endOfInorder);
        root.left = help(postorder, inorder, rootIndexOfPostorder - (endOfInorder - mid) - 1, startOfInorder, mid - 1);

        return root;
    }

}
