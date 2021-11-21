package ltcd.treeExercise;

import java.util.LinkedList;
import java.util.List;

public class _655_输出二叉树 {

    public List<List<String>> printTree(TreeNode root) {
        if(root == null) {
            return new LinkedList<>();
        }

        int height = getHeight(root);
        List<List<String>> res = new LinkedList<>();
        for (int i = 0; i < height; i++) {
            res.add(new LinkedList<>());
            for (int j = 0; j < Math.pow(2, height) - 1; j++) {
                res.get(i).add("");
            }
        }

        System.out.println(height);
        System.out.println((int)Math.pow(2, height) - 1);
        lvel(root, 0, 0, (int)Math.pow(2, height) - 1, res);

        return res;
    }

    private void lvel(TreeNode root, int level, int left, int riht, List<List<String>> res) {
        res.get(level).set((left + riht)/2, String.valueOf(root.val));
        lvel(root, level + 1, left, (left + riht)/2 - 1, res);
        lvel(root, level + 1, (left + riht)/2 - 1, riht, res);
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
