package ltcd.classExercise;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _剑指_Offer_II_043_往完全二叉树添加节点 {

    TreeNode tree = null;

    public _剑指_Offer_II_043_往完全二叉树添加节点(TreeNode root) {
        List<Integer> list = levelOrder(root);

        for (int i = 0; i < list.size(); i++) {
            insert(list.get(i));
        }

    }

    private List<Integer> levelOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        queue.offer(root);
        int levelSize = queue.size();

        while (!queue.isEmpty()) {
            levelSize = queue.size();
            while (levelSize-- > 0) {
                TreeNode pollNode = queue.poll();
                list.add(pollNode.val);

                if (pollNode.left != null) {
                    queue.offer(pollNode.left);
                }
                if (pollNode.right != null) {
                    queue.offer(pollNode.right);
                }
            }
        }

        return list;
    }

    public int insert(int v) {
        if (tree == null) {
            tree = new TreeNode(v);
            return -1;
        }

        TreeNode parent = findParent(tree);
        if (parent.left == null) {
            parent.left = new TreeNode(v);
        } else {
            parent.right = new TreeNode(v);
        }

        return parent.val;
    }

    private TreeNode findParent(TreeNode tree) {
        if (tree == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        int levelSize = queue.size();
        boolean stop = false;

        while (!queue.isEmpty()) {
            levelSize = queue.size();

            while (levelSize-- > 0) {
                TreeNode pollNode = queue.poll();
                if (pollNode.left == null || pollNode.right == null) {
                    return pollNode;
                }

                if (pollNode.left != null) {
                    queue.offer(pollNode.left);
                }
                if (pollNode.right != null) {
                    queue.offer(pollNode.right);
                }
            }

            if (stop) break;
        }

        return tree;
    }

    public TreeNode get_root() {
        return tree;
    }

}
