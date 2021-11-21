package ltcd.treeExercise;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _559_n叉树的最大深度 {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int maxChildDepth = 0;
        List<Node> children = root.children;
        for (Node child: children) {
            int chiildDepth = maxDepth(child);
            maxChildDepth = Math.max(maxChildDepth, chiildDepth);
        }

        return maxChildDepth + 1;
    }


    public int maxDepth1(Node root) {
        if (root == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int levelSize = queue.size();
        int height = 0;

        while (!queue.isEmpty()) {

            while (levelSize-- > 0) {
                Node pollNode = queue.poll();

                List<Node> children = pollNode.children;
                for (Node node : children) {
                    if (node != null) {
                        queue.offer(node);
                    }
                }
            }

            levelSize = queue.size();
            height++;
        }

        return height;
    }

}
