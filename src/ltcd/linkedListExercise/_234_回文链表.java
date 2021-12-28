package ltcd.linkedListExercise;

public class _234_回文链表 {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        slow = fast == null ? slow : slow.next;
        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newHead = new ListNode(0);
        ListNode  p = head;
        ListNode  cur = newHead;

        while (p != null) {

            ListNode tmp = p;
            p = p.next;
            tmp.next = cur.next;
            cur.next = tmp;
        }

        return newHead.next;
    }

}
