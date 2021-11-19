package ltcd.treeExercise;

import java.util.Deque;
import java.util.LinkedList;

public class _面试题_04_12_求和路径 {

    Deque<Integer> path = new LinkedList<>();
    int res = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        dfs(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);

        return res;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        path.addLast(root.val);
        sum -= root.val;

        if (root.left == null && root.right == null && sum == 0) {
            res++;
        }

        dfs(root.left, sum);
        dfs(root.right, sum);

        path.pollLast();
    }





    int ans = 0;

    public int pathSum1(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        dfs1(root, sum);
        pathSum1(root.left, sum);
        pathSum1(root.right, sum);

        return ans;
    }

    private void dfs1(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        sum -= root.val;

        if (sum == 0) {
            ans++;
        }

        dfs1(root.left, sum);
        dfs1(root.right, sum);
    }

}
