package ltcd.treeExercise;

import java.util.Deque;
import java.util.LinkedList;

public class _129_求根节点到叶节点数字之和 {

    int sum = 0;
    
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int path = 0;
        dfs(root, path);
        
        return sum;
    }

    private int dfs(TreeNode root, int path) {
        if (root == null) {
            return 0;
        }

        path = path * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += path;
        }

        int leftSUm = root.left == null ? 0 : dfs(root.left, path) ;
        int rightSum = root.right == null ? 0 : dfs(root.right, path) ;

        path = path % 10;

        return path;
    }

}
