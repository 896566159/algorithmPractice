package ltcd.treeExercise.n_aryTree;

import ltcd.treeExercise.n_aryTree.Node;

import java.util.LinkedList;
import java.util.List;

public class _590_N_叉树的后序遍历 {

    LinkedList<Integer> res = new LinkedList<>();

    public List<Integer> postorder1(Node root) {
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

        List<Node> children = root.children;
        for (int i = 0; i < children.size(); i++) {
            dfs(children.get(i));
        }

        res.add(root.val);
    }

}
