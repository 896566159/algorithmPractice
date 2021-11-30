package ltcd.treeExercise;

public class _450_删除二叉搜索树中的节点 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val > key) {//delete node int the left
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {//delete node int the right
            root.right = deleteNode(root.right, key);
        } else {//this node is the delete node
            if (root.left == null) { //case1：the left is null,return the right
                return root.right;
            }

            if (root.right == null) { //case2：the right is null,return the left
                return root.left;
            }

            //case3：both left and right are not null: use the right's the most left node to replace this root
            TreeNode node = root.right;
            TreeNode pre = root;
            while (node.left != null) {
                pre = node;
                node = node.left;
            }
            root.val = node.val;

            if (pre.right == node) {//the node is realy delete node, which is the parent's right, parent.right = node.right
                pre.right = node.right;
            } else {//which is the parent's left, parent.left = node.right
                pre.left = node.right;
            }
            node.right = null;//free the delete node'right pointer

        }
        return root;
    }
}
