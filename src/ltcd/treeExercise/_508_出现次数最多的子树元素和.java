package ltcd.treeExercise;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class _508_出现次数最多的子树元素和 {

    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        recur(root);

        int cout = 0;
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue() == max) {
                cout++;
            }
        }

        int[] ans = new int[cout];
        cout = 0;
        iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue() == max) {
                ans[cout++] = entry.getKey();
            }
        }

        return ans;
    }

    private int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = recur(root.left);
        int right = recur(root.right);
        int sum = left + right + root.val;

        map.put(sum, map.containsKey(sum) ? map.get(sum) + 1 : 1);
        max = Math.max(map.get(sum), max);

        return sum;
    }

}
