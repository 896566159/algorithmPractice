package ltcd.linkedListExercise;

public class _剑指_Offer_22_链表中倒数第k个节点 {

    //double pointer
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;

        while (k-- > 0) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    //traversal list and count the node
    public ListNode getKthFromEnd1(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        int count = 1;

        while (fast != null && fast.next != null) {
            count++;
            slow = slow.next;
            fast = fast.next.next;
        }

        count = fast == null ? count * 2 : count * 2 + 1;
        int index = 0;

        slow = head;
        while (index++ < count - k) {
            slow = slow.next;
        }

        return slow;
    }

}
