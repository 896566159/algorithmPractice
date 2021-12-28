package ltcd.linkedListExercise;

public class _1669_合并两个链表 {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        ListNode fisrt = list1;
        ListNode second = list1;
        ListNode p = list1;

        while (--b > 0 && p != null) {
            if(--a == 0) {
                fisrt = p;
            }

            second = p;
            p = p.next;
        }

        fisrt.next = list2;
        while (fisrt != null && fisrt.next != null) {
            fisrt = fisrt.next;
        }

        fisrt.next = list2;

        return list1;
    }

}
