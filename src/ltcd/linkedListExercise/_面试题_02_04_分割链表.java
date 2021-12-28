package ltcd.linkedListExercise;

public class _面试题_02_04_分割链表 {

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode small = dummy;
        ListNode p = head;
        ListNode pre = dummy;

        while (p != null) {
            if (p.next.val < x && pre != dummy) {
                pre.next = p.next;
                p.next = small.next;
                small.next = p;
                small = small.next;
                p = pre;
            }
            pre = p;
            p = p.next;
        }

        return dummy.next;
    }

}
