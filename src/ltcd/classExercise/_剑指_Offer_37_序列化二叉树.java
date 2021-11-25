package ltcd.classExercise;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class _剑指_Offer_37_序列化二叉树 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String left = serialize(root.left);
        String right = serialize(root.right);

        return root.val + "," + left + "," + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] strings = data.split(",");
        Deque<String> queue = new LinkedList<>();

        for (int i = 0; i < strings.length; i++) {
            queue.offerLast(strings[i]);
        }

        return help(queue);
    }

    private TreeNode help(Deque<String> queue) {
        String str = queue.pollFirst();

        if (str.equals("#")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(str));

        root.left = help(queue);
        root.right = help(queue);

        return root;
    }

}
