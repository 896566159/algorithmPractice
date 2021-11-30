package ltcd.treeExercise;

import java.util.LinkedList;
import java.util.Queue;

public class _623_在二叉树中增加一行 {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null) {
            return null;
        }

        if (depth == 1) {
            TreeNode tree = new TreeNode(val);
            tree.left = root;
            return tree;
        }

        dfs(root,0, val, depth);

        return root;
    }

    private void dfs(TreeNode root, int height, int val, int depth) {
        if (root == null) {
            return;
        }

        if (height == depth - 1) {
            TreeNode left = new TreeNode(val);
            TreeNode right = new TreeNode(val);

            if (root.left != null) {
                left.left = root.left;
                root.left = left;
            } else {
                root.left = left;
            }

            if (root.right != null) {
                right.right = root.right;
                root.right = right;
            } else {
                root.right = right;
            }
        } else {
            dfs(root.left, height + 1, val, depth);
            dfs(root.right, height + 1, val, depth);
        }
    }

    public TreeNode addOneRow1(TreeNode root, int val, int depth) {
        if (root == null) {
            return null;
        }

        if (depth == 1) {
            TreeNode tree = new TreeNode(val);
            tree.left = root;
            return tree;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelSize = queue.size();
        int height = 0;

        while (!queue.isEmpty()) {
            levelSize = queue.size();
            if (height++ == depth - 1) {
                break;
            }

            while (levelSize-- > 0) {
                TreeNode pollNode = queue.poll();

                if (pollNode.left != null) {
                    queue.offer(pollNode.left);
                }

                if (pollNode.right != null) {
                    queue.offer(pollNode.right);
                }
            }
        }

        while (!queue.isEmpty()) {

            TreeNode pollNode = queue.poll();

            if (pollNode.left != null) {
                TreeNode node = new TreeNode(val);
                node.left = pollNode.left;
                pollNode.left = node;
            } else {
                pollNode.left = new TreeNode(val);
            }

            if (pollNode.right != null) {
                TreeNode node = new TreeNode(val);
                node.right = pollNode.right;
                pollNode.right = node;
            } else {
                pollNode.right = new TreeNode(val);
            }
        }

        return root;
    }

}
