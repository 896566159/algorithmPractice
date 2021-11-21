package ltcd.treeExercise.difficult;

import java.util.Deque;
import java.util.LinkedList;

public class _297_二叉树的序列化与反序列化 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "n";
        }

        String leftSerialize = serialize(root.left);
        String rightSerialize = serialize(root.right);

        return root.val + "," + leftSerialize + "," + rightSerialize;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split(",");
        Deque<String> deque = new LinkedList<>();


        for (int i = 0; i < strings.length; i++) {
            deque.addLast(strings[i]);
        }
        return deserialize(deque);
    }

    private TreeNode deserialize(Deque<String> data) {
        String s = data.pollFirst();
        if (s.equals("n")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = deserialize(data);
        root.right = deserialize(data);

        return root;
    }

}
