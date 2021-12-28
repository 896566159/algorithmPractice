package ltcd.linkedListExercise;

public class _206_反转链表 {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newHead = new ListNode(0);
        ListNode p = head;
        newHead.next = recur(head, newHead);
        return newHead.next;
    }

    private ListNode recur(ListNode head, ListNode pre) {
        if (head == null) {
            return null;
        }

        ListNode next = pre.next;
        pre.next = head.next;
        head.next = pre;
//        pre = next;
        recur(next.next, next);

        return head;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode newHead = new ListNode(0);
        ListNode p = head;

        while (p != null) {
            ListNode next = p.next;
            p.next = newHead.next;
            newHead.next = p;
            p = next;
        }
        return newHead.next;
    }

}
