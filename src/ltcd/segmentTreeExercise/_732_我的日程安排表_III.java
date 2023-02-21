package ltcd.segmentTreeExercise;

public class _732_我的日程安排表_III {

    public int book(int start, int end) {
        update(root, 0, N, start, end - 1, 1);
        return root.val;
    }

    class Node {
        Node left;
        Node right;
        int val;
        int add;
    }

    int N = (int) 1e9;
    Node root = new Node();

    private void update(Node root, int searchLeft, int searchRight, int targetLeft, int targetRight, int value) {
        if (targetLeft <= searchLeft && targetRight >= searchRight) {
            root.val += value;
            root.add += value;
            return;
        }

        pushDown(root);
        int mid = (searchLeft + searchRight) >> 1;

        if (targetLeft <= mid) {
            update(root.left, searchLeft, mid, targetLeft, targetRight, value);
        }

        if (targetRight > mid) {
            update(root.right, mid + 1, searchRight, targetLeft, targetRight, value);
        }

        root.val = Math.max(root.left.val, root.right.val);
    }

    private void pushDown(Node root) {
        if (root.left == null) {
            root.left = new Node();
        }

        if (root.right == null) {
            root.right = new Node();
        }

        if (root.add == 0) {
            return;
        }

        root.left.val += root.add;
        root.right.val += root.add;
        root.left.add += root.add;
        root.right.add += root.add;
        root.add = 0;
    }
}
