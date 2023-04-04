package ltcd.linkedListExercise;

public class _2074_反转偶数长度组的节点 {

    public static void main(String[] args) {
        ListNode node = new ListNode(5);
        node.next = new ListNode(2);
        node.next.next = new ListNode(6);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(9);
        node.next.next.next.next.next = new ListNode(1);
        node.next.next.next.next.next.next = new ListNode(7);
        node.next.next.next.next.next.next.next = new ListNode(3);
        node.next.next.next.next.next.next.next.next = new ListNode(8);
        node.next.next.next.next.next.next.next.next.next  = new ListNode(4);

        _2074_反转偶数长度组的节点 v = new _2074_反转偶数长度组的节点();
        v.reverseEvenLengthGroups(node);
    }

    public ListNode reverseEvenLengthGroups(ListNode head) {
        // 节点个数
        int count = countNode(head);
        // 组数
        int group = 1;
        int tmp = 1;
        // 当前节点的下标
        int index = 1;
        // 前一个节点
        ListNode prev = head;
        // 当前节点
        ListNode cur = head;


        while (count-- > 0) {

            if (group % 2 == 0) {
                System.out.println(index);

                // [index， index + grop] 之间的节点翻转
                ListNode start = cur.next;


                //                    prev = cur;

            } else {
                index++;
                prev = cur;
                cur = cur.next;
            }
            if (--tmp < 1) {
                group++;
                tmp = group;
            }
        }

        return head;
    }

    private int countNode(ListNode head) {
        if (head == null) {
            return 0;
        }

        int ans = 0;
        while (head != null) {
            head = head.next;
            ans++;
        }

        return ans;
    }

}
