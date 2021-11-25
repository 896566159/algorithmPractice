package ltcd.treeExercise;


import java.util.Stack;

public class _114_二叉树展开为链表 {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);

        //如果节点的左子树不为空，就要将左子树变成右子树。
        //右子树要接在左子树的右子树的最右边的节点上。
        //同时要断开根节点接在已经交换了的左子树
        if (root.left != null) {
            //将左子树接在右子树上，并将左子树设置为null
            TreeNode tmp = root.right;
            root.right = root.left;
            root.left = null;

            //寻找左子树的右子树的最右边节点
            TreeNode p = root.right;
            while (p.right != null) {
                p = p.right;
            }

            //将右子树接在左子树的最右边的节点上
            p.right = tmp;
        }

        flatten(root.right);
    }
}
