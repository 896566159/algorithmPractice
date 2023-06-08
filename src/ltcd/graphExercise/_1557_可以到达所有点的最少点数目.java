package ltcd.graphExercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _1557_可以到达所有点的最少点数目 {

    public static void main(String[] args) {
        _1557_可以到达所有点的最少点数目 v = new _1557_可以到达所有点的最少点数目();
        List<List<Integer>> e = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        li.add(0);
        li.add(1);
        e.add(new ArrayList<>(li));
        li.clear();

        li.add(0);
        li.add(2);
        e.add(new ArrayList<>(li));
        li.clear();

        li.add(2);
        li.add(5);
        e.add(new ArrayList<>(li));
        li.clear();

        li.add(3);
        li.add(4);
        e.add(new ArrayList<>(li));
        li.clear();

        li.add(4);
        li.add(2);
        e.add(new ArrayList<>(li));
        li.clear();

        System.out.println(v.findSmallestSetOfVertices(6, e));
    }

    Set<Integer> set = new HashSet<>();
    List<List<Integer>> edges;
    boolean[] visited;
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

        this.edges = edges;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            set.add(i);
        }

        for (List<Integer> edge : edges) {
            List<Integer> path = new ArrayList<>();
            traverse(edge.get(0), path);
        }
        return new ArrayList<>(set);
    }

    private void traverse(int index, List<Integer> path) {
        if (visited[index] || index >= visited.length) {
            return;
        }

        if (path.size() > 0) {
            set.remove(index);
        }

        visited[index] = true;
        // 当前节点记录到路径上
        path.add(index);
        // 添加当前节点的邻接节点到路径上
        Integer v = edges.get(index).get(1);
        path.add(v);

        traverse(v, path);

        // 从路劲上删除当前节点和邻接节点
        path.remove(path.size() - 1);
        path.remove(path.size() - 1);
    }

}
