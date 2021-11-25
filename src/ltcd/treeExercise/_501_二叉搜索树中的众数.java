package ltcd.treeExercise;

import java.util.*;

public class _501_二叉搜索树中的众数 {

    Map<Integer, Integer> map = new HashMap<>();
    public int[] findMode(TreeNode root) {

        dfs(root);

        int max = 0;
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            max = max > entry.getValue() ? max : entry.getValue();
        }

        iterator = map.entrySet().iterator();
        LinkedList<Integer> list = new LinkedList<>();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (max == entry.getValue()) {
                list.add(entry.getKey());
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        dfs(root.right);
        map.put(root.val, map.containsKey(root.val) ? map.get(root.val) + 1 : 1);
    }

}
