package ltcd.treeExercise;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _429_N_叉树的层序遍历 {

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new LinkedList<>();
        }

        List<List<Integer>> ans = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int level_size = queue.size();
        List<Integer> list = new LinkedList<>();

        while (!queue.isEmpty()) {
            while (level_size-- > 0) {
                Node pollNode = queue.poll();
                list.add(pollNode.val);

                int children_size = pollNode.children.size();
                for (int i = 0; i < children_size; i++) {
                    queue.add(pollNode.children.get(i));
                }
            }

            ans.add(new LinkedList<>(list));
            level_size = queue.size();
            list.clear();
        }

        return ans;
    }

}
