package ltcd.treeExercise;

import java.util.Arrays;

public class _654_最大二叉树 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int rootIndex = start;
        for (int i = start + 1; i <= end; i++) {
            rootIndex = nums[rootIndex] < nums[i] ? i : rootIndex;
        }

        TreeNode root = new TreeNode(nums[rootIndex]);

        root.left = dfs(nums, start, rootIndex - 1);
        root.right = dfs(nums, rootIndex + 1, end);

        return root;
    }
}
