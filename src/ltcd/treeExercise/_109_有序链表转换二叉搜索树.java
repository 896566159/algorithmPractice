package ltcd.treeExercise;

public class _109_有序链表转换二叉搜索树 {

    public static void main(String[] args) {
        _109_有序链表转换二叉搜索树 v = new _109_有序链表转换二叉搜索树();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        v.sortedListToBST(head);
    }

    public TreeNode sortedListToBST2(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }

        TreeNode root = new TreeNode(slow.val);
        pre.next = null;
        pre = slow.next;
        slow.next = null;

        root.left = sortedListToBST2(head);
        root.right = sortedListToBST2(pre);

        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode p = head;
        int lenght = 0;
        while (p != null) {
            lenght++;
            p = p.next;
        }

        return dfs(head, 0, lenght - 1);
    }

    private TreeNode dfs(ListNode head, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        int tmp = mid;
        ListNode p = head;
        while (tmp-- > 0) {
            p = p.next;
        }

        TreeNode root = new TreeNode(p.val);

        root.left = dfs(head, start, mid - 1);
        root.right = dfs(p.next, mid + 1, end);

        return root;
    }

    public TreeNode sortedListToBST1(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode p = head;
        int lenght = 0;
        while (p != null) {
            lenght++;
            p = p.next;
        }

        int[] nums = new int[lenght];
        p = head;
        lenght = 0;
        while (p != null) {
            nums[lenght++] = p.val;
            p = p.next;
        }

        return dfs(nums, 0, nums.length);
    }

    private TreeNode dfs(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, start, mid - 1);
        root.right = dfs(nums, mid + 1, end);

        return root;
    }

}
