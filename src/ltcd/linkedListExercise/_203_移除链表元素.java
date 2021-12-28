package ltcd.linkedListExercise;

public class _203_移除链表元素 {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode newHead = new ListNode(0);
        ListNode pre = newHead;
        newHead.next = head;
        ListNode p = newHead.next;

        while (p != null) {
            if (p.val == val) {
                pre.next = p.next;
            }
            pre = p;
            p = p.next;
        }

        return newHead.next;
    }

}
