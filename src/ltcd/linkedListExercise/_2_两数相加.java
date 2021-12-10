package ltcd.linkedListExercise;

public class _2_两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        int flag = 0;
        ListNode p1 = l1;
        ListNode p2 = l2;

        while (p1 != null && p2 != null && p1.next != null && p2.next != null) {
            p1.val = p1.val + p2.val + flag;
            flag = p1.val / 10;
            p1.val = p1.val % 10;

            p1 = p1.next;
            p2 = p2.next;
        }

        if (p1.next == null) {
            p1.val = p1.val + p2.val + flag;
            flag = p1.val / 10;
            p1.val = p1.val % 10;
            p1.next = p2.next;

            ListNode pre = p1;
            p1 = p1.next;

            while (p1 != null && flag != 0) {
                p1.val = p1.val + flag;
                flag = p1.val / 10;
                p1.val = p1.val % 10;

                pre = p1;
                p1 = p1.next;
            }

            if (flag == 1) {
                pre.next = new ListNode(1);
            }
        }

        if (p2.next == null) {
            p1.val = p1.val + p2.val + flag;
            flag = p1.val / 10;
            p1.val = p1.val % 10;

            ListNode pre = p1;
            p1 = p1.next;

            while (p1 != null && flag != 0) {
                p1.val = p1.val + flag;
                flag = p1.val / 10;
                p1.val = p1.val % 10;

                pre = p1;
                p1 = p1.next;
            }

            if (flag == 1) {
                pre.next = new ListNode(1);
            }
        }



        return l1;
    }

}
