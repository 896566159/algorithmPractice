package ltcd.linkedListExercise;

public class _2095_删除链表的中间节点 {

    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }

        if (fast == null) {
            if (slow.next == null) {
                pre.next = null;
            } else {
                pre.next = pre.next.next;
            }
        } else {
            slow.next = slow.next.next;
        }

        return head;
    }

}
