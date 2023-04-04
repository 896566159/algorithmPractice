package ltcd.linkedListExercise;

public class _2487_从链表中移除节点 {

    public ListNode removeNodes(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode node = removeNodes(head.next);

        if (node.val > head.val) {
            return node;
        }

        head.next = node;

        return head;
    }

}
