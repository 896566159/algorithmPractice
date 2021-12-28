package ltcd.linkedListExercise;

public class _25_K_个一组翻转链表 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = head;
        ListNode fast = head;
        int n = k;
        ListNode h = dummy;
        ListNode t = null;

        while (slow != null) {
            n = k;
            fast = slow == dummy ? head : slow;

            while (--n > 0 && fast != null) {
                fast = fast.next;
            }

            if (fast == null) break;

            t = fast.next;
            fast.next = null;//断开
            h.next = reverse(slow);//head -> 翻转的head
            slow.next = t;//翻转之后的tail->未翻转的部分
            h = slow;

            slow = slow.next;
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = head;
        ListNode tmp = null;

        while (p != null) {
            tmp = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = tmp;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);

        _25_K_个一组翻转链表 v = new _25_K_个一组翻转链表();
        v.reverseKGroup(head, 3);
    }

}
