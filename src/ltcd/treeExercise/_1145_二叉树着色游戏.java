package ltcd.treeExercise;

public class _1145_二叉树着色游戏 {

    int countLeftNode = 0;
    int countRightNode = 0;

    public static void main(String[] args) {
        _1145_二叉树着色游戏 v = new _1145_二叉树着色游戏();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
//        node.left.left = new TreeNode(4);
//        node.left.right = new TreeNode(5);
//        node.left.left.left = new TreeNode(8);
//        node.left.left.right = new TreeNode(9);
//        node.left.right.left = new TreeNode(10);
//        node.left.right.right = new TreeNode(11);
        node.right = new TreeNode(3);
//        node.right.left = new TreeNode(6);
//        node.right.right = new TreeNode(7);

        System.out.println(v.btreeGameWinningMove(node, 3, 2));
    }

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode target = lookForX(root, x);


        traversal(target.left, 0);
        traversal(target.right, 1);

        return n - countRightNode < countRightNode
                || n - countLeftNode < countLeftNode
                || countLeftNode + countRightNode + 1 < n - countLeftNode - countRightNode - 1;
    }

    private void traversal(TreeNode target, int lr) {
        if (target == null) {
            return;
        }

        traversal(target.left, lr);
        traversal(target.right, lr);
        if (lr == 0) {
            countLeftNode++;
        } else if (lr == 1){
            countRightNode++;
        }
    }

    private TreeNode lookForX(TreeNode root, int x) {
        if (root == null) {
            return null;
        }

        if (root.val == x) {
            return root;
        }

        return lookForX(root.left, x) == null ? lookForX(root.right, x) : lookForX(root.left, x);
    }
}
