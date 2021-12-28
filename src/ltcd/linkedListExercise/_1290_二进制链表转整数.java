package ltcd.linkedListExercise;

public class _1290_二进制链表转整数 {

    public int getDecimalValue(ListNode head) {
        if (head == null) {
            return 0;
        }

        int ans = 0;
        ListNode p = head;

        while (p != null) {
            ans = ans * 2 + p.val;
            p = p.next;
        }

        return ans;
    }

}
