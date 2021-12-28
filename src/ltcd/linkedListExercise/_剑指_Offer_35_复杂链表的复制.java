package ltcd.linkedListExercise;

public class _剑指_Offer_35_复杂链表的复制 {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        Node p = head;
        while (p != null) {
            Node next = new Node(p.val);
            next.next = p.next;
            p.next = next;

            p = next.next;
        }

        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }

            p = p.next.next;
        }

        p = head;
        Node dummy = new Node(-1);
        Node cur = dummy;

        while (p != null) {
            Node tmp = p.next;
            cur.next = tmp;
            p.next = tmp.next;
            cur = cur.next;
            p = p.next;
        }

        return dummy.next;
    }

}
