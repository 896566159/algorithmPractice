package ltcd.linkedListExercise;

public class _面试题_0206_回文链表 {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode node = reverse(head);
        ListNode p = head;

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

        while (node != null && p != null) {
            if (node.val != p.val) {
                return false;
            }
            p = p.next;
            node = node.next;
        }

        return p == null && node == null;
    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newHead = new ListNode(0);
        ListNode p = head;

        while (p != null) {
            ListNode tmp = new ListNode(p.val, newHead.next);
            newHead.next = tmp;
            p = p.next;
        }

        return newHead.next;
    }

}
