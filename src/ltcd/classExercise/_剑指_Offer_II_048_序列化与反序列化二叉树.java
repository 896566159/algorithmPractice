package ltcd.classExercise;

import java.util.Deque;
import java.util.LinkedList;

public class _剑指_Offer_II_048_序列化与反序列化二叉树 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String left = serialize(root.left);
        String right =  serialize(root.right);

        return root.val + "," + left + "," + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }

        String[] strings = data.split(",");
        Deque<String> deque = new LinkedList<>();

        for (int i = 0; i < strings.length; i++) {
            deque.addLast(strings[i]);
        }

        return deserialize(deque);
    }

    private TreeNode deserialize(Deque<String> deque) {
        String s = deque.pollFirst();

        if (s.equals("#")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = deserialize(deque);
        root.right = deserialize(deque);

        return root;
    }

}
