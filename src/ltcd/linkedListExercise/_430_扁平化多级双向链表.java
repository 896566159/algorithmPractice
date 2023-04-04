package ltcd.linkedListExercise;

public class _430_扁平化多级双向链表 {

    public static void main(String[] args) {
        Node1 head = new Node1(1);
        Node1 node2 = new Node1(2);
        Node1 node3 = new Node1(3);
        Node1 node4 = new Node1(4);
        Node1 node5 = new Node1(5);
        Node1 node6 = new Node1(6);
        Node1 node7 = new Node1(7);
        Node1 node8 = new Node1(8);
        Node1 node9 = new Node1(9);
        Node1 node10 = new Node1(10);
        Node1 node11 = new Node1(11);
        Node1 node12 = new Node1(12);

        head.next = node2;
        node2.prev = head;
        head.child = node3;

//        node2.next = node3;
//        node3.prev = node2;
//
//        node3.next = node4;
//        node4.prev = node3;
//        node3.child = node7;
//
//        node4.next = node5;
//        node5.prev = node4;
//
//        node5.next = node6;
//        node6.prev = node5;
//
//
//        node7.next = node8;
//        node8.prev = node7;
//
//        node8.next = node9;
//        node9.prev = node8;
//        node8.child = node11;
//
//        node9.next = node10;
//        node10.prev = node9;
//
//        node11.next = node12;
//        node12.prev = node11;


        _430_扁平化多级双向链表 v = new _430_扁平化多级双向链表();
        v.flatten(head);

    }

    /**
     * 迭代
     * @param head
     * @return
     */
    public Node1 flatten1(Node1 head) {
        Node1 cur = head;

        while (cur != null) {

            if (cur.child != null) {
                // 记录下 next 节点
                Node1 nextNode = cur.next;
                Node1 childNode = cur.child;

                // child 节点变成 next 节点
                cur.next = childNode;
                childNode.prev = cur;
                cur.child = null;

                // 遍历 child 分支，找出该分支的最后一个节点
                Node1 prev = childNode;
                Node1 last = childNode.next;
                while (last != null) {
                    prev = last;
                    last = last.next;
                }

                // 将 记录下来的 next 节点 连接在 child 分支的最后一个节点上
                prev.next = nextNode;
                if (nextNode != null) {
                    nextNode.prev = prev;
                }
            }

            cur = cur.next;
        }

        return head;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public Node1 flatten(Node1 head) {
        if (head == null) {
            return head;
        }

        Node1 child = flatten(head.child);

        // 没有 child，则递归 对下一个节点做扁平化
        if (child == null) {
            head.next = flatten(head.next);
        } else {
            // 有child并且有next，将child这个分支 变成next，next变成child的next
            if (head.next != null) {
                Node1 next = head.next;

                // 将child变成next
                // 先找出该分支的最后一个节点
                Node1 pre = child;
                Node1 cur = child.next;
                while (cur != null) {
                    pre = cur;
                    cur = cur.next;
                }
                // next 指向 child 节点
                head.next = child;
                child.prev = head;

                // next 变成 child分支的 next
                next.prev = pre;
                pre.next = next;
            } else {
                // 有child，但是没有next，直接将child变成next
                // 将child变成next
                head.next = child;
                child.prev = head;
            }

            // child 指针断开
            head.child = null;
        }

        return head;
    }

}

class Node1 {
    public int val;
    public Node1 prev;
    public Node1 next;
    public Node1 child;

    public Node1 (int val) {
        this.val = val;
    }

    public Node1(int val, Node1 prev) {
        this.val = val;
        this.prev = prev;
    }
}
