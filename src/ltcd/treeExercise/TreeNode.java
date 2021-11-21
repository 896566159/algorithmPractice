package ltcd.treeExercise;

public class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
