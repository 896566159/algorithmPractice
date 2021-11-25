package ltcd.treeExercise;

import java.util.Deque;
import java.util.LinkedList;

public class _513_找树左下角的值 {

    int res = 0;
    int maxDepth = 0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root,0);
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        if (maxDepth < depth) {
            maxDepth = depth;
            res = root.val;
        }

        //递归从右子树到左子树，这样整体（包括最后一层）的扫描方向就是从右往左。能找到最左边的节点
        dfs(root.right, depth + 1);
        dfs(root.left, depth + 1);

    }


    public int findBottomLeftValue1(TreeNode root) {

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int levelSize = deque.size();
        int ans = 0;

        while (!deque.isEmpty()) {
            levelSize = deque.size();
            ans = deque.peekFirst().val;

            while (levelSize-- > 0) {
                TreeNode pollNode = deque.poll();

                if (pollNode.left != null) {
                    deque.offer(pollNode.left);
                }

                if (pollNode.right != null) {
                    deque.offer(pollNode.right);
                }
            }
        }

        return ans;
    }

}
