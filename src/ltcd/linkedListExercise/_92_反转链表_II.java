package ltcd.linkedListExercise;

public class _92_反转链表_II {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode one = head;
        ListNode two = head;
        ListNode t = head;
        ListNode p = head;
        int index = 0;

        while (p != null) {
            if (index + 1 == left) {
                t = p;
                one = p.next;
                p.next = null;
                p = one;
            }
            if (index + 1 == right) {
                two = p.next;
                p.next = null;
                p = two;
                break;
            }
            p = p.next;
        }

        t.next = reverseList1(one);
        while (t.next != null) {
            t = t.next;
        }
        t.next = p;

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
