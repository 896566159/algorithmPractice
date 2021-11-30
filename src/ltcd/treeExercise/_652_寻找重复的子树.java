package ltcd.treeExercise;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class _652_寻找重复的子树 {

    int t;
    Map<String, Integer> trees;
    Map<Integer, Integer> count;
    List<TreeNode> res;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        t = 1;
        trees = new HashMap();
        count = new HashMap();
        res = new LinkedList();
        lookup(root);
        return res;
    }

    public int lookup(TreeNode node) {
        if (node == null) return 0;
        String serial = node.val + "," + lookup(node.left) + "," + lookup(node.right);
        //use UID(unique id) to economize the space
        int uid = trees.computeIfAbsent(serial, x-> t++);//create UId: UID = (root.val, leftUID, rightUID)
        count.put(uid, count.getOrDefault(uid, 0) + 1);
        if (count.get(uid) == 2)
            res.add(node);
        return uid;
    }








    List<TreeNode> ans = new LinkedList<>();
    Map<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees1(TreeNode root) {
        if (root == null) {
            return ans;
        }

        serialize(root);

        return ans;
    }

    private String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String serialize = root.val + "," + serialize(root.left) + "," + serialize(root.right);
        map.put(serialize, map.getOrDefault(serialize, 0) + 1);

        if (map.get(serialize) == 2) {
            ans.add(root);
        }

        return serialize;
    }

}
