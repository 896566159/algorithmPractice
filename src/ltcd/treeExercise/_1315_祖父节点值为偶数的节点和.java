package ltcd.treeExercise;

public class _1315_祖父节点值为偶数的节点和 {

    int sum = 0;

    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int total = 0;

        if (root.val % 2 == 0 && root.left != null && root.left.left != null) {
            total += root.left.left.val;
        }

        if (root.val % 2 == 0 && root.left != null && root.left.right != null) {
            total += root.left.right.val;
        }

        if (root.val % 2 == 0 && root.right != null && root.right.right != null) {
            total += root.right.right.val;
        }

        if (root.val % 2 == 0 && root.right != null && root.right.left != null) {
            total += root.right.left.val;
        }

        return sum + total + sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right);
    }
}
