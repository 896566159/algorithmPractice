package ltcd.linkedListExercise;

public class _1721_交换链表中的节点 {

    public ListNode swapNodes(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode first = head;
        ListNode second = head;

        while (k-- > 0) {
            fast = fast.next;
        }

        fast = fast;

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        second = slow;

        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;

        return head;
    }

}
