package ltcd.linkedListExercise;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class _138_复制带随机指针的链表 {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        //copy the list, and the copy-node will mount at the node.next.
        Node p = head;
        while (p != null) {
            Node tmp = new Node(p.val);
            tmp.next = p.next;
            p.next = tmp;

            p = tmp.next;
        }

        //copy the random
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }

            p = p.next.next;
        }

        //separate the list and copy list
        p = head;
        Node dummy = new Node(-1);
        Node cur = dummy;

        while (p != null) {
            Node tmp = p.next;
            cur.next = tmp;
            cur = cur.next;
            p.next = tmp.next;

            p = p.next;
        }

        return dummy.next;
    }

    public Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }

        Node p = head;
        Node newHead = new Node(0);
        Node cur = newHead;
        LinkedList<Node> nodes = new LinkedList<>();

        //just copy the node， not copying the random
        while (p != null) {
            cur.next = new Node(p.val);
            cur = cur.next;
            nodes.add(p.random);
            p = p.next;
        }

        //traverse the list again， copy the random
        p = newHead.next;
        while (p != null) {
            Node remove = nodes.remove();
            Node tmp1 = head;
            Node tmp2 = head;

            while (tmp1 != null) {
                if (tmp1.next == remove) {
                    p.random = tmp2.next;
                    break;
                }
                tmp2 = tmp2.next;
                tmp1 = tmp1.next;
            }
            p = p.next;
        }

        return newHead.next;
    }

}



class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
