package ltcd.linkedListExercise;

import ltcd.linkedListExercise.ListNode;

public class _2058_找出临界点之间的最小和最大距离 {

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(2);
        node.next.next = new ListNode(4);
        node.next.next.next = new ListNode(1);
//        node.next.next.next.next = new ListNode(5);
//        node.next.next.next.next.next = new ListNode(1);
//        node.next.next.next.next.next.next = new ListNode(2);

        _2058_找出临界点之间的最小和最大距离 v = new _2058_找出临界点之间的最小和最大距离();
        v.nodesBetweenCriticalPoints(node);
    }

    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int[] ans = new int[]{-1, -1};
        // 极值点距离中最大的值
        int maxMax = Integer.MIN_VALUE;
        int minMax = Integer.MAX_VALUE;
        // 上一个极值点的坐标
        int preMax = -1;
        // 第一个极值点的坐标
        int firstMax = -1;
        // 节点的下标
        int index = 1;
        // 上一个节点的值
        int preVal = head.val;
        ListNode cur = head;

        while (cur != null) {
            if (cur.next != null) {
                // 该点是极小/大值
                if ((cur.next.val > cur.val && cur.val < preVal) || (cur.next.val < cur.val && cur.val > preVal)) {
                    if (preMax != -1) {
                        // 更新极值之间的最大距离
                        maxMax = Math.max(maxMax, index - firstMax);
                        minMax = Math.min(minMax, index - preMax);
                    } else {
                        firstMax = index;
                    }
                    preMax = index;
                }
            }

            index++;
            preVal = cur.val;
            cur = cur.next;
        }

        if (maxMax != Integer.MIN_VALUE) {
            ans = new int[]{minMax, maxMax};
        }

        return ans;
    }

}
