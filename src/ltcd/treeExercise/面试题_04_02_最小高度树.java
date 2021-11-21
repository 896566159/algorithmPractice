package ltcd.treeExercise;

public class 面试题_04_02_最小高度树 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return help(nums, 0, nums.length - 1);
    }

    private TreeNode help(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = help(nums, start, mid - 1);
        root.right = help(nums, mid + 1, end);

        return root;
    }

}
