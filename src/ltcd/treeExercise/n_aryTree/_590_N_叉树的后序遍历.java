package ltcd.treeExercise;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _590_N_叉树的后序遍历 {

    public List<Integer> postorder(Node root) {
        List<Integer> ans = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        Node p = root;

        while (p != null || !stack.isEmpty()) {


            while (p != null) {
                stack.push(p);
                List<Node> children = p.children;

            }

            p = stack.pop();
            ans.add(p.val);

            p =
        }
    }


    LinkedList<Integer> res = new LinkedList<>();

    public List<Integer> postorder1(Node root) {
        if (root == null) {
            return new LinkedList<>();
        }
        return res;
    }

    private void dfs(Node root) {
        if (root == null) {
            return;
        }

        List<Node> children = root.children;
        for (int i = children.size() - 1; i >= 0; i++) {
            dfs(children.get(i));
        }

        res.add(root.val);
    }

}
