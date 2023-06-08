package ltcd.graphExercise;

import java.util.*;

public class _剑指Offer_II_110所有路径 {

    public static void main(String[] args) {
        _剑指Offer_II_110所有路径 v = new _剑指Offer_II_110所有路径();
        v.allPathsSourceTarget(new int[][]{{1,2},{3},{3},{}});
    }


    // bfs：从0开始一层一层向外搜索
    public List<List<Integer>> allPathsSourceTarget1(int[][] graph) {
        List<List<Integer>> resultList = new ArrayList<>();
        int n = graph.length;
        Queue<Node> queue = new ArrayDeque<>();

        // 将节点0入栈
        queue.offer(new Node(0));
        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            if (poll.index == n - 1) {
                resultList.add(poll.path);
                continue;
            }

            // 如果不是最后一个节点，则将弹出的节点的邻接节点入队
            for (int v : graph[poll.index]) {
                queue.offer(new Node(v, poll.path));
            }
        }

        return resultList;
    }

    class Node {
        int index;
        List<Integer> path;

        Node(int index) {
            this.index = index;
            this.path = new ArrayList<>();
            // 把当前节点加入路径
            this.path.add(index);
        }

        Node(int index, List<Integer> path) {
            this.index = index;
            // 复制一个新的list
            this.path = new ArrayList<>(path);
            // 把当前节点加入
            this.path.add(index);
        }
    }


    //------------------------------------------上面是bfs版本，下面是dfs版本----------------------------------

    // 记录所有路径
    List<List<Integer>> res = new LinkedList<>();
    int[][] graph;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> path = new ArrayList<>();
        this.graph = graph;

        traverse(0, path);
        return res;
    }

    private void traverse(int index, List<Integer> path) {
        // 把当前节点记录在路径上
        path.add(index);

        // 如果当前节点是最后一个节点，则加入到结果集中
        if (index == graph.length - 1) {
            res.add(new ArrayList<>(path));
        }

        // 从当前节点的邻接节点选择一个继续遍历
        for (int v : graph[index]) {
            traverse(v, path);
        }

        // 从当前节点出发到最后一个节点的路径已经遍历结束，把当前节点从路径是移出
        path.remove(path.size() - 1);
    }

}
