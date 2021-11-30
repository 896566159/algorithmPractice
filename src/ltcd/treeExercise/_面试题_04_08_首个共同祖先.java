package ltcd.treeExercise;

import java.util.LinkedList;
import java.util.List;

public class _面试题_04_08_首个共同祖先 {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        //if search the node return the node
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        //use left and right to mark both q and p's position of the tree
        TreeNode left = lowestCommonAncestor(root.left, p, q);//will return p or q,and this node is on root's left
        TreeNode right = lowestCommonAncestor(root.right, p, q);//will return p or q,and this node is on root's right

        //if left and right not null, that root is the q and p's parent,return it
        if (left != null && right != null) {
            return root;
        }

        //if q and p are localing the same side, return the side(left or right)
        return left == null ? right : left;
    }
}
