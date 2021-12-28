package ltcd.linkedListExercise;

import dataStructure.list.List;

public class _83_删除排序链表中的重复元素 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;

        while (p != null) {
            while (p != null && p.next != null && p.val == p.next.val) {
                p.next = p.next.next;
            }
            p = p.next;
        }
        return head;
    }

}
