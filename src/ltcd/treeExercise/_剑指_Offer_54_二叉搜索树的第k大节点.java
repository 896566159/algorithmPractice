package ltcd.treeExercise;

import java.util.LinkedList;
import java.util.Queue;

public class _剑指_Offer_54_二叉搜索树的第k大节点 {

    LinkedList<Integer> linkedList = new LinkedList<>();
    public int kthLargest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        dfs(root);

        return linkedList.get(linkedList.size() - k);
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        linkedList.add(root.val);
        dfs(root.right);
    }

}
