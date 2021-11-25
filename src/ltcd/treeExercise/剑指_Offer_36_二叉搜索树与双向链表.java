package ltcd.treeExercise;

import java.util.Stack;

public class 剑指_Offer_36_二叉搜索树与双向链表 {

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode head = null;
        TreeNode node = root;
        TreeNode previous = null;

        while (node != null || !stack.isEmpty()) {

            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            if (previous == null) {
                head = node;
            } else {
                previous.right = node;
            }
            node.left = previous;
            previous = node;
            node = node.right;
        }


        return head;
    }


    TreeNode head = null;
    TreeNode pre = null;
    TreeNode cur = null;

    public TreeNode treeToDoublyList1(TreeNode root) {
        if (root == null) {
            return null;
        }

        head = root;
        dfs(root);

        return head;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);

        //previous node is null, this node will be the head of list
        if (pre == null) {
            head = root;
            pre = root;
        } else {
            pre.right = root;
            root.left = pre;
        }
        pre = root;

        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        剑指_Offer_36_二叉搜索树与双向链表 v = new 剑指_Offer_36_二叉搜索树与双向链表();
        v.treeToDoublyList(treeNode);
    }

}
