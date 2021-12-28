package ltcd.linkedListExercise;

public class _160_相交链表 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {
            p1 = p1.next == null ? headB : p1.next;
            p2 = p2.next == null ? headA : p2.next;
        }

        return p1;
    }

}
