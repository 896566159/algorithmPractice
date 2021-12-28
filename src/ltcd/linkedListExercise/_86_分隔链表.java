package ltcd.linkedListExercise;

public class _86_分隔链表 {

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }

        ListNode p1 = head;
        ListNode small = new ListNode(0);
        ListNode big = new ListNode(0);
        ListNode p2 = small;
        ListNode p3 = big;

        while (p1 != null) {
            if (p1.val < x) {
                p2.next = new ListNode(p1.val);
                p2 = p2.next;
            } else {
                p3.next = new ListNode(p1.val);
                p3 = p3.next;

            }
            p1 = p1.next;
        }
        p2.next = big.next;
        return small.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(4);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(2);

        _86_分隔链表 v = new _86_分隔链表();
        v.partition(node, 3);
    }

}
