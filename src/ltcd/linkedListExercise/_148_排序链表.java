package ltcd.linkedListExercise;

import java.util.Collections;
import java.util.LinkedList;

public class _148_排序链表 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        LinkedList<Integer> list = new LinkedList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        Collections.sort(list);

        System.out.println(list.size());

        head = new ListNode(-1);
        ListNode cur = head;

        while (list.isEmpty()) {
            int remove = list.remove();
            System.out.println(remove);
            cur = cur.next = new ListNode(remove);
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(3);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(1);

        _148_排序链表 v = new _148_排序链表();
        v.sortList(node);
    }

}
