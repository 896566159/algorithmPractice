package ltcd.linkedListExercise;


import java.util.Stack;

public class _61_旋转链表 {


    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head.next;
        int size = 1;

        while (p != null) {
            size++;
            p = p.next;
        }

        k = k % size;
        if (k == 0) return head;

        k = size - k;
        ListNode newHead = null;
        ListNode middle = p;
        p = head;

        while (k-- > 0) {
            newHead = p;
            p = p.next;
        }

        ListNode tmp = newHead;
        newHead = newHead.next;
        tmp.next = null;

        middle.next = head;

        return newHead;
    }


    public ListNode rotateRight1(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;

        while (p != null) {
            stack.push(p);
            p = p.next;
        }

        int size = stack.size();
        k = k % size;
        ListNode newHead = null;
        ListNode middle = stack.peek();

        while (k-- > 0) {
            newHead = stack.pop();
        }

        while (!stack.isEmpty()) {
            middle.next = stack.pop();
        }

        return newHead;
    }

}
