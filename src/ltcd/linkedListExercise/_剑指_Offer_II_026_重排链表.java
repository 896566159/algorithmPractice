package ltcd.linkedListExercise;

public class _剑指_Offer_II_026_重排链表 {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = head;
        int count = 0;

        while (p != null) {
            count++;
            ListNode node = new ListNode(p.val);
            node.next = dummy.next;
            dummy.next = node;
            p = p.next;
        }

        ListNode copy = dummy.next;
        p = head;
        int half = count >> 1;
        dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (half-- > 0) {
            ListNode tmp = copy.next;
            copy.next = p.next;
            p.next = copy;
            p = copy.next;
            copy = tmp;
        }

        if (count % 2 == 0) {
            p.next = null;
        } else {
            p.next.next = null;
        }

        head = dummy.next;
    }

}
