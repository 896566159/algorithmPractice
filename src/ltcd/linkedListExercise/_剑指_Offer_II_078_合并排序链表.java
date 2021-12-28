package ltcd.linkedListExercise;

public class _剑指_Offer_II_078_合并排序链表 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }

        if (lists.length <= 1) {
            return lists[0];
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = lists[0];
        int n = 1;

        while (n++ < lists.length) {
            ListNode p1 = lists[n];
            ListNode cur = dummy;
            ListNode p2 = dummy.next;

            while (p2 != null && p1 != null) {
                if (p1.val < p2.val) {
                    ListNode tmp = p1.next;
                    p1.next = p2;
                    cur.next = p1;

                    p1 = tmp;
                    cur = cur.next;
                } else {
                    p2 = p2.next;
                    cur = cur.next;
                }
            }

            if (p1 != null) {
                cur.next = p1;
            }
        }

        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode[] l = new ListNode[3];
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        l[0] = l1;
        l[1] = l2;
        l[2] = l3;

        _剑指_Offer_II_078_合并排序链表 v = new _剑指_Offer_II_078_合并排序链表();
        v.mergeKLists(l);
    }
}
