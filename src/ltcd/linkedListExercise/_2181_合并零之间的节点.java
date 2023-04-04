package ltcd.linkedListExercise;

public class _2181_合并零之间的节点 {

    public ListNode mergeNodes(ListNode head) {

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode p = head;

        while (p != null) {
            if (p.val == 0) {
                if (p.next != null) {
                    cur.next = new ListNode(0);
                    cur = cur.next;
                }
            } else {
                cur.val += p.val;
            }

            p = p.next;
        }

        return dummy.next;
    }

}
