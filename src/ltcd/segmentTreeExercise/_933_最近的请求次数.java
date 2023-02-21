package ltcd.segmentTreeExercise;

public class _933_最近的请求次数 {

    public int ping(int t) {
//        System.out.println("up[" + t + ", " + t + "]");
//        update(root, 1, N, t, t + 1, 1);
//
//        int start = t - 3000 <= 1 ? 1 : t - 3000;
//        System.out.println("qu[" + start + ", " + t + "]");
//        return query(root, 1, N, start, t + 1);
        update(root, 1, N, t, t, 1);
        return query(root, 1, N, Math.max(0, t - 3000), t);
    }


    //**********************线段树模板************************

    class Node {
        Node left;
        Node right;
        int val;
        int add;
    }

    int N = (int) 1e9;
    Node root = new Node();

    private int query(Node root, int searchLeft, int searchRight, int targetLeft, int targetRight) {
        if (targetLeft <= searchLeft && targetRight >= searchRight) {
            return root.val;
        }

        pushDown(root);
        int queryResult = 0;
        int mid = (searchLeft + searchRight) >> 1;

        if (targetLeft <= mid) {
            queryResult += query(root.left, searchLeft, mid, targetLeft, targetRight);
        }

        if (targetRight > mid) {
            queryResult += query(root.right, mid + 1, searchRight, targetLeft, targetRight);
        }

        return queryResult;
    }

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

        root.val = root.left.val + root.right.val;
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
