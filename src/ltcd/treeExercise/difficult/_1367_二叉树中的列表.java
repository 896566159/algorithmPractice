//package ltcd.treeExercise.difficult;
//
//public class _1367_二叉树中的列表 {
//
//    public boolean isSubPath(ListNode head, TreeNode root) {
//        if (head == null) {
//            return false;
//        }
//
//        return recur(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
//    }
//
//    private boolean recur(ListNode head, TreeNode root) {
//        if (root == null) return false;
//        return find(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
//    }
//
//    private boolean find(ListNode head, TreeNode node) {
//        if (head == null) return true;
//        if (node == null || head.val != node.val) return false;
//        return find(head.next, node.left) || find(head.next, node.right);
//    }
//
//}
