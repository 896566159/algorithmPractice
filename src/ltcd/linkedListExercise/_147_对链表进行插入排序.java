package ltcd.linkedListExercise;

public class _147_对链表进行插入排序 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head.next;
        ListNode tail = head;

        while (p != null) {

            if (p.val < head.val) {
                tail.next = p.next;
                p.next = head;
                head = p;
                p = tail.next;
                continue;
            }

            ListNode pre = head;
            while (pre != tail) {
                if (pre.val <= p.val && pre.next.val > p.val) {
                    tail.next = p.next;
                    p.next = pre.next;
                    pre.next = p;
                    break;
                }

                pre = pre.next;
            }

            if (pre == tail) {
                tail = tail.next;
            }

            while (tail != null && tail.next != null && tail.next.val > tail.val) {
                tail = tail.next;
            }

            p = tail.next;
        }

        return head;
    }

    //递归有问题
    private void recur(ListNode pre, ListNode p, ListNode head) {
        if (p == null || pre == null) {
            return;
        }

        if (p.val < head.val) {
            pre.next = p.next;
            p.next = head;
            head = p;
        }

        ListNode tmp = head;
        ListNode next = p.next;

        while (tmp != pre) {
            if (tmp.val < p.val && tmp.next.val > p.val) {
                pre.next = p.next;
                p.next = tmp.next;
                tmp.next = p;
                break;
            }
            tmp = tmp.next;
        }

        if (pre != null && pre.next == null) {
            return;
        }
        recur(pre, pre.next, head);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next = new ListNode(1);

        _147_对链表进行插入排序 v = new _147_对链表进行插入排序();
        v.insertionSortList(head);
    }

}
