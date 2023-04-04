package ltcd.linkedListExercise;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀和
 * 前面出现过的前缀和，后面再出现，说明两次相同前缀和中间的节点和 = 0
 */
public class _1171_从链表中删去总和值为零的连续节点 {

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int sum = 0;
        Map<Integer, ListNode> preSum = new HashMap<>();
        preSum.put(sum, dummy);
        ListNode cur = head;

        while (cur != null) {
            sum += cur.val;

            if (preSum.containsKey(sum)) {
                ListNode node = preSum.get(sum);
                ListNode del = node.next;
                node.next = cur.next;

                int dSum = sum;
                while (del != cur) {
                    dSum += del.val;
                    preSum.remove(dSum);
                    del = del.next;
                }
            } else {
                preSum.put(sum, cur);
            }
            cur = cur.next;
        }

        return dummy.next;
    }

}
