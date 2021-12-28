package ltcd.linkedListExercise;

import java.util.Stack;

public class _82_删除排序链表中的重复元素_II {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = new ListNode(0);
        ListNode p = head;
        ListNode cur = newHead;
        boolean flag = true;

        while (p != null) {
            while (p.next != null && p.val == p.next.val) {
                p = p.next;
                flag = false;
            }
            if (flag) {
                cur.next = p;
                cur = cur.next;
                cur.next = null;
            }

            flag = true;
            p = p.next;
        }

        return newHead;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode p = head.next;
        ListNode pre = head;
        stack.push(head);

        while (p != null) {
            if (stack.peek().val == p.val) {
                while (p != null && stack.peek().val == p.val) {
                    pre.next = p.next;
                    p.next = null;
                    p = pre.next;
                }
                stack.pop();
                if (stack.isEmpty()) {
                    pre.next = null;
                    pre = p;
                } else {
                    stack.peek().next = stack.peek().next.next;
                }
            }
            stack.push(p);

            pre = p;
            p = p == null ? null : p.next;
        }

        ListNode newHead = null;
        while (!stack.isEmpty()) {
            newHead = stack.pop();
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(2);
//        node.next.next.next = new ListNode(3);
//        node.next.next.next.next = new ListNode(4);
//        node.next.next.next.next.next = new ListNode(4);
//        node.next.next.next.next.next.next = new ListNode(5);
        _82_删除排序链表中的重复元素_II v = new _82_删除排序链表中的重复元素_II();
        v.deleteDuplicates(node);
    }
}
