package ltcd.classExercise;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _449_序列化和反序列化二叉搜索树 {

    List<String> list = new LinkedList<>();
    Deque<String> nodes = new LinkedList<>();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String serialize = root.val + "," + serialize(root.left) + "," + serialize(root.right);
        list.add(serialize);

        return serialize;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }

        String[] strings = data.split(",");
        for (int i = 0; i < strings.length; i++) {
            nodes.offer(strings[i]);
        }

        return recur(nodes);
    }

    private TreeNode recur(Deque<String> nodes) {
        String s = nodes.pollFirst();

        if (s.equals("#")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = recur(nodes);
        root.right = recur(nodes);

        return root;
    }

}
