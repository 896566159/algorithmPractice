package ltcd.linkedListExercise;

public class _725_分隔链表 {

    public ListNode[] splitListToParts(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        int count = 0;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            count++;
        }

        count = fast == null ? count * 2 : count * 2 + 1;
        int quotient = count / k;
        int mod = count % k;
        ListNode[] ans = new ListNode[k];
        fast = head;
        int index = 0;

        if (quotient == 0) {
            while (true) {
                ListNode tmp = head.next;
                ans[index++] = head;
                head.next = null;
                head = tmp;
                if (head == null) {
                    return ans;
                }
            }
        }


        while (head != null) {
            ListNode tmp = head;
            quotient = count / k;

            while (quotient-- > 0) {
                head = head.next;
            }

            if (mod-- > 0) {
                head = head.next;
            }

            ans[index++] = tmp;
            ListNode p = head.next;
            head.next = null;
            head = p;
        }

        return ans;
    }

}
