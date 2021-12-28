package ltcd.linkedListExercise;

public class _剑指_Offer_25_合并两个排序的链表 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode node = new ListNode(0);
        ListNode p = node;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        if (p2 == null) {
            p = p1;
        }

        if (p1 == null) {
            p = p2;
        }

        return node.next;
    }

}
