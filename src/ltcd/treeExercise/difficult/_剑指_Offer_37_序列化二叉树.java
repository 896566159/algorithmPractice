package ltcd.treeExercise.difficult;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 此题与 297 题相同，但是解题方式不同
 */
public class _剑指_Offer_37_序列化二叉树 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelSize = queue.size();
        StringBuffer sb = new StringBuffer();

        while (!queue.isEmpty()) {

            while (levelSize-- > 0) {
                TreeNode pollNode = queue.poll();

                if (pollNode == null) {
                    sb.append("#,");
                } else {
                    sb.append(pollNode.val + ",");
                    queue.offer(pollNode.left);
                    queue.offer(pollNode.right);
                }
            }

            levelSize = queue.size();
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("#")) {
            return null;
        }

        Deque<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        Queue<TreeNode> tree = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes.poll()));
        tree.offer(root);
        System.out.println(nodes.size());

        while (!tree.isEmpty()) {
            TreeNode pollNode = tree.poll();

            String left = nodes.poll();
            String right = nodes.poll();

            if (!left.equals("#")) {
                pollNode.left = new TreeNode(Integer.parseInt(left));
                tree.offer(pollNode.left);
            }

            if (!right.equals("#")) {
                pollNode.right = new TreeNode(Integer.parseInt(right));
                tree.offer(pollNode.right);
            }
        }

        return root;
    }

}
