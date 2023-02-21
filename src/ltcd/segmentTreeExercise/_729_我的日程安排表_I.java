package ltcd.segmentTreeExercise;

public class _729_我的日程安排表_I {

    public _729_我的日程安排表_I() {

    }

    public boolean book(int start, int end) {
        //先查询该区间是否为0
        if (query(root, 0, N, start, end - 1) > 0) {
            return false;
        }

        //更新区间
        update(root, 0, N, start, end - 1, 1);
        return true;
    }

    class Node {
        // 左右孩子节点
        Node left;
        Node right;
        // 当前节点值
        int val;
        // 懒惰标记
        int add;
    }

    private int N = (int) 1e9;
    private Node root = new Node();

    private int query(Node node, int start, int end, int boundLeft, int boundRight) {
        //如果目标范围区间[boundLeft, boundRight]包含了范围区间[start, end]，则该节点的节点值加上value，该节点的懒惰标记也加上value
        //即找到一个最大的能够覆盖[]
        if (boundLeft <= start && end <= boundRight) {
            return node.val;
        }

        //先把保证左右孩子不为 null
        pushDown(node);

        int ans = 0;
        int mid = (start + end) >> 1;

        //将搜索范围[start, end]变成两部分 [start, mid] U [mid + 1, end]，即：对应搜索树的左右子树
        //[start, mid)是否与搜索目标范围[boundLeft, boundRight]是否有交集，即：左子树上是否有目标范围内的数
        if (boundLeft <= mid) {
            ans += query(node.left, start, mid, boundLeft, boundRight);
        }
        //[mid, end)是否与搜索目标范围[boundLeft, boundRight]是否有交集，即：右子树上是否有目标范围内的数
        if (boundRight > mid) {
            ans += query(node.right, mid + 1, end, boundLeft, boundRight);
        }

        return ans;
    }

    private void pushDown(Node node) {

        if (node.left == null) {
            node.left = new Node();
        }

        if (node.right == null) {
            node.right = new Node();
        }

        //如果当前节点的值是默认值，则说明是被查询方法调用
        if (node.val == 0) {
            return;
        }

        //如果当前节点的值不为空，则需要更新当前节点的左右孩子的值
        //左右孩子的节点值要加上当前节点的懒惰标记值
        node.left.val += node.add;
        node.right.val += node.add;

        //左右孩子的节点值被更新后，需要递归将左右孩子的懒惰标记值也加上当前节点的懒惰标记值
        //此时，左右孩子节点的懒惰值被更新，但是不会去迭代更新左右孩子节点的节点，即懒惰标记——延迟更新子树，将更新的值暂存在标记中
        //等到调用 pushDown(当前node.left) 和 pushDown(当前node.right)时，才会去更新左右孩子的节点值
        node.left.add += node.add;
        node.right.add +=node.add;

        //当前节点的懒惰标记值已经用于更新，将其重新初始化为 0
        node.add = 0;
    }

    /**
     * 更新节点的值，先更新当前节点，再往下更新子节点（更新之前先pushDown保证左右子树不为空）
     * @param node
     * @param start
     * @param end
     * @param boundLeft
     * @param boundRight
     * @param value
     */
    private void update(Node node, int start, int end, int boundLeft, int boundRight, int value) {
        //如果目标范围区间[boundLeft, boundRight]包含了范围区间[start, end]，则该节点的节点值加上value，该节点的懒惰标记也加上value
        if (boundLeft <= start && end <= boundRight) {
            node.val += value;
            node.add += value;
            return;
        }

        //先保证更新的节点的左右孩子不为空
        pushDown(node);

        //计算出左右子树的分界点，以便于更新左右子树
        int mid = (start + end) >> 1;

        //向下更新左子树
        if (boundLeft <= mid) {
            update(node.left, start, mid, boundLeft, boundRight, value);
        }

        //向下更新右子树
        if (boundRight > mid) {
            update(node.right, mid + 1, end, boundLeft, boundRight, value);
        }

        //更新当前节点的值
        node.val = node.left.val + node.right.val;
    }

}
