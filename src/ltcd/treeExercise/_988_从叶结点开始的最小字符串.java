package ltcd.treeExercise;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class _988_从叶结点开始的最小字符串 {

    String ans = "~";

    public String smallestFromLeaf(TreeNode root) {
        StringBuffer sb = new StringBuffer();

        dfs(root, sb);

        return ans;
    }

    private void dfs(TreeNode node, StringBuffer sb) {
        if (node == null) {
            return;
        }

        sb.append((char)('a' + node.val));

        if (node.left == null && node.right == null) {
            sb.reverse();
            String tmp = sb.toString();
            sb.reverse();

            if (tmp.compareTo(ans) < 0) {
                ans = tmp;
            }
        }

        dfs(node.left, sb);
        dfs(node.right, sb);

        sb.deleteCharAt(sb.length() - 1);
    }

}
