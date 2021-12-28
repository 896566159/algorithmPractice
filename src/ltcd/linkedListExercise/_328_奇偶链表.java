package ltcd.linkedListExercise;

public class _328_奇偶链表 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode p = head;
        ListNode d1 = dummy1;
        ListNode d2 = dummy2;
        int f = 1;

        while (p != null) {
            if (f % 2 == 1) {
                d1.next = new ListNode(p.val);
                d1 = d1.next;
                f++;
            } else {
                d2.next = new ListNode(p.val);
                d2 = d2.next;
                f++;
            }
        }

        d1.next = dummy2.next;

        return dummy1.next;
    }

}
