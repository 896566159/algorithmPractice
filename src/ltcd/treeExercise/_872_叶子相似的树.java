package ltcd.treeExercise;

import java.util.LinkedList;
import java.util.List;

public class _872_叶子相似的树 {

    List<Integer> tree1 = new LinkedList<>();
    List<Integer> tree2 = new LinkedList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null & root2 == null) {
            return true;
        }

        if (root1 == null || root2 ==null) {
            return false;
        }

        levelOrder(root1, tree1);
        levelOrder(root2, tree2);

        System.out.println(tree1);
        System.out.println(tree2);

        if (tree1.size() != tree2.size()) {
            return false;
        }

        for (int i = 0; i < tree1.size(); i++) {
            if (tree1.get(i) != tree2.get(i)) {
                return false;
            }
        }

        return true;
    }

    private void levelOrder(TreeNode root, List<Integer> tree) {
        if (root == null) {
            return;
        }

        levelOrder(root.left, tree);
        if (root.left == null & root.right == null) {
            tree.add(root.val);
        }
        levelOrder(root.right, tree);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(3);

        _872_叶子相似的树 v = new _872_叶子相似的树();
        v.leafSimilar(root1, root2);
    }

}
