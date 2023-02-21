package ltcd.segmentTreeExercise;

public class _729_我的日程安排表_II {

    public _729_我的日程安排表_II() {
    }

    public boolean book(int start, int end) {
        //查询区间中的重叠数是否超过了2，超过了则返回false
        if (query(root, 0, N, start, end - 1) >= 2) {
            return false;
        }

        update(root, 0, N, start, end - 1, 1);

        return true;
    }

    class Node {
        Node left;
        Node right;
        int val;//节点值
        int add;//懒惰标记，延迟更新的节点数量
    }

    int N = (int) 1e9;
    Node root = new Node();

    /**
     * 在搜索范围[searchLeft, searchRight]中查询目标范围[targetLeft, targetRight]的范围值
     * @param root
     * @param searchLeft
     * @param searchRight
     * @param targetLeft
     * @param targetRight
     * @return
     */
    private int query(Node root, int searchLeft, int searchRight, int targetLeft, int targetRight) {
        //只要找到一个刚好比 目标区间小的 & 最大区间，可返回该大区间的节点值
        if (targetLeft <= searchLeft && targetRight >= searchRight) {
            return root.val;
        }

        //保证左右孩子节点不为空
        pushDown(root);

        //如果当前节点代表的区间很大，目标区间无法覆盖当前区间，则将当前区间一分为二，
        //分别从左右两个区间中统计目标区间[targetRight,targetRight]的结果
        int mid = (searchLeft + searchRight) >> 1;
        int queryResult = 0;//目标区间中最大的重叠数

        //在区间[searchLeft, mid)上搜索
        if (targetLeft <= mid) {
            queryResult = Math.max(queryResult, query(root.left, searchLeft, mid, targetLeft, targetRight));
        }

        //在区间[mid, searchRight)上搜索
        if (targetRight > mid) {
            queryResult = Math.max(queryResult, query(root.right, mid + 1, searchRight, targetLeft, targetRight));
        }

        return queryResult;
    }

    /**
     * 更新[targetLeft, targetRight]区间的值
     * @param root
     * @param searchLeft
     * @param searchRight
     * @param targetLeft
     * @param targetRight
     */
    private void update(Node root, int searchLeft, int searchRight, int targetLeft, int targetRight, int value) {
        if (targetLeft <= searchLeft && targetRight >= searchRight) {
            root.val += value;
            root.add += value;
            return;
        }

        //先保证左右节点不为空
        pushDown(root);

        int mid = (searchLeft + searchRight) >> 1;

        if (targetLeft <= mid) {
            update(root.left, searchLeft, mid, targetLeft, targetRight, value);
        }

        if (targetRight > mid) {
            update(root.right, mid + 1, searchRight, targetLeft, targetRight, value);
        }

        //更新当前节点的值，在该问题中，当前节点的值更新为左右孩子节点的最大值
        root.val = Math.max(root.left.val, root.right.val);
    }

    private void pushDown(Node root) {
        if (root.left == null) {
            root.left = new Node();
        }

        if (root.right == null) {
            root.right = new Node();
        }

        //如果root.add=0，表示该方法正在被query()方法调用，此时只做查询操作，可立即返回
        if (root.add == 0) {
            return;
        }

        //当该方法是由update()方法调用时，往下更新节点
        //但是只更新到当前节点的直接子节点
        //对于非直接子节点，延迟更新——使用了懒惰标记
        root.left.val += root.add;
        root.right.val += root.add;
        root.left.add += root.add;
        root.right.add += root.add;

        //该节点的懒惰标记已经被使用，重新将其初始化为 0
        root.add = 0;
    }

}
