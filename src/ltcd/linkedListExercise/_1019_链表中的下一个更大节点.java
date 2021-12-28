package ltcd.linkedListExercise;


public class _1019_链表中的下一个更大节点 {

    public int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return new int[1];
        }

        ListNode fast = head;
        ListNode slow = head;
        int n = 0;

        while (fast != null) {
            fast = fast.next;
            n++;
        }

        int[] ans = new int[n];
        fast = head;
        int index = 0;

        while (slow != null) {
            fast = slow;

            while (fast != null && slow.val > fast.val) {
                fast = fast.next;
            }

            ans[index++] = fast == null ? 0 : fast.val;
            while (slow != null && slow.next.val <= slow.val) {
                ans[index++] = fast.val;
                slow = slow.next;
            }
        }

        return ans;
    }

}
