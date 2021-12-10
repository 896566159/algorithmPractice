package ltcd.dualPointerExercise;

public class _876_链表的中间结点 {

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode first = head;
        ListNode second = head;

        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }

        return first;
    }

}