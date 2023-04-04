package ltcd.linkedListExercise;

import dataStructure.list.ArrayList;
import dataStructure.list.List;

import java.util.Map;

public class _2130_链表最大孪生和 {

    public int pairSum(ListNode head) {
        ListNode cur = head;
        List<Integer> list = new ArrayList<>();
        int count = 0;
        int ans = 0;

        while (cur != null) {
            list.add(cur.val);
            count++;
        }

        for (int i = 0; i < count >> 1; i++) {
            ans = Math.max(ans, (list.get(0) + list.get(count - 1 -i)));
        }

        return ans;
    }

}
