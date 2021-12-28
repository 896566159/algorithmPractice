package ltcd.linkedListExercise;

public class _143_重排链表 {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        ListNode help = reverse(head);
        ListNode fast = head;
        ListNode slow = head;
        int len = 0;
        ListNode x = new ListNode(0);

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            len++;
        }

        fast = head;
        slow = help;
        ListNode p = x;
        while (len-- > 0) {
            p.next = fast;
            ListNode tmp1 = fast;
            ListNode tmp2 = slow;
            fast = fast.next;
            slow = slow.next;
            tmp1.next = tmp2;
            p = tmp2;
        }

        head = x.next;
    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newHead = new ListNode(0);
        ListNode p = head;
        while (p != null) {
            ListNode tmp = new ListNode(p.val);
            p = p.next;
            tmp.next = newHead.next;
            newHead.next = tmp;
        }

        return newHead.next;
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next = new ListNode(3);
        node.next.next = new ListNode(4);
        node.next.next.next = new ListNode(5);
    }
}
