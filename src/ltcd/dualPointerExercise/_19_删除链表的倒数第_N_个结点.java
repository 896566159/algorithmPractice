package ltcd.dualPointerExercise;

public class _19_删除链表的倒数第_N_个结点 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode first = head;
        ListNode second = head;
        int length = 0;

        while (second != null && second.next != null) {
            first = first.next;
            length++;
            second = second.next.next;
        }

        length = second == null ? length * 2 : length * 2 + 1;
        int index = 0;
        first = head;

        while (index < length - 1 - n) {
            first = first.next;
            index++;
        }
        first.next = first.next.next;

        return head;
    }

}
