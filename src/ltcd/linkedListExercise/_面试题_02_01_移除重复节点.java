package ltcd.linkedListExercise;

import java.util.HashSet;
import java.util.Set;

public class _面试题_02_01_移除重复节点 {

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode p = head.next;
        ListNode pre = head;

        while (p != null) {
            if (set.contains(p.val)) {
                pre.next = p.next;
                p = p.next;
                continue;
            } else {
                set.add(p.val);
            }
            pre = p;
            p = p.next;
        }

        return head;
    }

}
