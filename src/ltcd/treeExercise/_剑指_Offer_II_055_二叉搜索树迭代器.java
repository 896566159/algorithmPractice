package ltcd.treeExercise;

import java.util.LinkedList;
import java.util.List;

public class _剑指_Offer_II_055_二叉搜索树迭代器 {

    List<Integer> list = new LinkedList<>();
    int position = 0;

    public _剑指_Offer_II_055_二叉搜索树迭代器(TreeNode root) {
        inorderTrasalver(root);
    }

    private void inorderTrasalver(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTrasalver(root.left);
        list.add(root.val);
        inorderTrasalver(root.right);
    }

    public int next() {
        return list.get(position++);
    }

    public boolean hasNext() {
        return position < list.size();
    }

}
