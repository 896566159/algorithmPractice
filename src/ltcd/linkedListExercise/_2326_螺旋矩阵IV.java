package ltcd.linkedListExercise;

import java.util.Arrays;

public class _2326_螺旋矩阵IV {

    public static void main(String[] args) {
        ListNode node = new ListNode(515);
        node.next = new ListNode(942);
        node.next.next = new ListNode(528);
        node.next.next.next = new ListNode(483);
        node.next.next.next.next = new ListNode(20);
        node.next.next.next.next.next = new ListNode(159);
        node.next.next.next.next.next.next = new ListNode(868);
        node.next.next.next.next.next.next.next = new ListNode(999);
        node.next.next.next.next.next.next.next.next = new ListNode(474);
        node.next.next.next.next.next.next.next.next.next = new ListNode(320);
        node.next.next.next.next.next.next.next.next.next.next = new ListNode(734);
        node.next.next.next.next.next.next.next.next.next.next.next = new ListNode(956);
        node.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(12);
        node.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(124);
        node.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(224);
        node.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(252);
        node.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(909);
        node.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(732);

        _2326_螺旋矩阵IV iv = new _2326_螺旋矩阵IV();
        iv.spiralMatrix(4, 5, node);
    }

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(ans[i], -1);
        }

        ListNode cur = head;
        int left = 0;
        int right = n;
        int top = 0;
        int button = m;

        while (cur != null) {

            // 从左上角到右上角
            for (int i = left; i < right && cur != null; i++) {
                ans[top][i] = cur.val;
                cur = cur.next;
            }
            top++;

            // 从右上角到右下角
            for (int i = top; i < button && cur != null; i++) {
                ans[i][right] = cur.val;
                cur = cur.next;
            }
            right--;

            // 从右下角到左下角
            for (int i = right - 1; i >= left && cur != null; i--) {
                ans[button][i] = cur.val;
                cur = cur.next;
            }
            button--;

            // 从左下角到左上角
            for (int i = button - 1; i >= top && cur != null; i--) {
                ans[i][left] = cur.val;
                cur = cur.next;
            }
            left++;
        }


        return ans;
    }

}
