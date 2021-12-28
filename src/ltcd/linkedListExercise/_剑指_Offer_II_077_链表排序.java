package ltcd.linkedListExercise;

public class _剑指_Offer_II_077_链表排序 {

    //merge sort:
        //partition
        //merge
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        int len = 0;
        ListNode p = head;

        while (p != null) {
            p = p.next;
            len++;
        }

        int left = 0;
        int mid = (left + len) >> 1;
        int right = len;

        partition(head, 0, len);


    }

    private ListNode partition(ListNode head, int left, int right) {
        if (left > right) {
            return ;
        }

        int mid = (left + right) >> 1;
        ListNode first = head;
        ListNode second = null;

        while (left < mid) {
            second = second.next;
            left++;
        }

        ListNode tmp = second.next;
        second.next = null;
        second = tmp;

        merge(first, second);
    }

    private void merge(ListNode first, ListNode second) {
        if (first == null || second == null) return;

        ListNode p1 = first;
        ListNode p2 = second;


    }

}
