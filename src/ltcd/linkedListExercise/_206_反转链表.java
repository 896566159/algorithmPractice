package ltcd.linkedListExercise;

public class _206_反转链表 {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newHead = new ListNode(0);
        ListNode p = head;
        newHead.next = recur(head, newHead);
        return newHead.next;
    }

    private ListNode recur(ListNode head, ListNode pre) {
        if (head == null) {
            return null;
        }

        ListNode next = pre.next;
        pre.next = head.next;
        head.next = pre;
//        pre = next;
        recur(next.next, next);

        return head;
    }

    // 不使用头结点
    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            // 记录原链表的一下个节点
            ListNode next = cur.next;

            // 翻转
            cur.next = pre;

            // 更新
            pre = cur;
            cur = next;
        }

        return pre;
    }

    // 使用一个虚拟头结点： dummy -> 翻转后真正的头结点 -> 其他节点
    // 遍历原链表，让每个节点都轮番成为dummy的下一个节点
    public ListNode reverseList1(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode newHead = new ListNode(0);
        ListNode cur = head;

        while (cur != null) {
            // 记录翻转前的下一个节点
            ListNode next = cur.next;

            // 翻转，当前节点变成头结点
            cur.next = newHead.next;

            // 更新虚拟头结点的next指针
            newHead.next = cur;

            // 继续迭代
            cur = next;
        }
        return newHead.next;
    }



}
