package ltcd.linkedListExercise;

public class _445_两数相加_II {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode p1 = reverse(l1);
        ListNode p2 = reverse(l2);
        int jw = 0;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (p2 != null && p1 != null) {
            cur = new ListNode((p1.val + p2.val) % 10 + jw);

            jw = (p1.val + p2.val) / 10;
            cur = cur.next;
            p1 = p1.next;
            p2 = p2.next;
        }

        if (p2 == null) {
            while (p1 != null) {
                cur.next = new ListNode((p1.val + jw) % 10);

                jw = (p1.val + p2.val + jw) / 10;
                cur = cur.next;
                p1 = p1.next;
            }
        }

        if (p1 == null) {
            while (p2 != null) {
                cur.next = new ListNode((p2.val + jw) % 10);

                jw = (p2.val + jw) / 10;
                cur = cur.next;
                p2 = p2.next;
            }
        }

        dummy = reverse(dummy.next);
        if (jw != 0) {
            ListNode head = new ListNode(jw);
            head.next = dummy;
            return head;
        }

        return dummy;
    }

    private ListNode reverse(ListNode head) {
        ListNode p = head;
        ListNode dummy = new ListNode(-1);

        while (p != null) {
            ListNode tmp = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = tmp;
        }

        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        _445_两数相加_II v = new _445_两数相加_II();
        v.addTwoNumbers(l1, l2);
    }

}
