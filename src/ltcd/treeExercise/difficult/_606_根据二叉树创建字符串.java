package ltcd.treeExercise;

public class _606_根据二叉树创建字符串 {

    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }

        String mid = new String(String.valueOf(root.val));
        if (root.left != null && root.right == null) {
            return mid + "(" + tree2str(root.left) + ")";
        }

        if (root.right == null && root.right == null) {
            return mid;
        }


        return mid + "(" + tree2str(root.left) + ")" + "(" + tree2str(root.right) + ")";
    }

}
