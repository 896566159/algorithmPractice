package ltcd.linkedListExercise;

import java.util.HashMap;
import java.util.Map;

public class _382_链表随机节点 {

    Map<Integer, ListNode> map = new HashMap<>();
    int i = 0;

    public _382_链表随机节点(ListNode head) {
        ListNode p = head;

        while (p != null) {
            map.put(i++, p);
            p = p.next;
        }
    }

    public int getRandom() {
        return (int) Math.random();
    }

}
