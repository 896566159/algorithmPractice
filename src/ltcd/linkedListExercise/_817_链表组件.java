package ltcd.linkedListExercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _817_链表组件 {

    public static int numComponents(ListNode head, int[] nums) {
        if (head == null || nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        ListNode s = head;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        while (s != null) {
            if (set.contains(s.val)) {
                while (s != null && set.contains(s.val)) {
                    s = s.next;
                }

                max++;
            } else {
                s = s.next;
            }
        }

        return max;
    }

    public static void main(String[] args) {
    }

}
