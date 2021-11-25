package ltcd.treeExercise.n_aryTree;

import java.util.LinkedList;
import java.util.List;

public class _589_N_叉树的前序遍历 {

    LinkedList<Integer> res = new LinkedList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return new LinkedList<>();
        }
        dfs(root);
        return res;
    }

    private void dfs(Node root) {
        if (root == null) {
            return;
        }

        res.add(root.val);

        List<Node> children = root.children;
        for (int i = 0; i < children.size(); i++) {
            dfs(children.get(i));
        }
    }

}
