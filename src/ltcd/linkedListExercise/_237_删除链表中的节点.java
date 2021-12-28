package ltcd.linkedListExercise;

public class _237_删除链表中的节点 {

    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }

        if (node.next == null) {
            node = null;
        } else {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

}
