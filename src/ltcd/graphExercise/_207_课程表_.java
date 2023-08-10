package ltcd.graphExercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _207_课程表_ {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Set<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new HashSet<>());
        }

        for (int[] prerequisite : prerequisites) {
            // prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi
            if (request(graph, prerequisite[0], prerequisite[1])) {
                return false;
            }

            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        return true;
    }

    // 从 a 出发，是否可达到 b
    private boolean request(List<Set<Integer>> graph, int a, int b) {
        // a 可达 b
        if (graph.get(a).contains(b) || a == b) {
            return true;
        }

        for (Integer pre : graph.get(a)) {
            if (request(graph, pre, b)) {
                return true;
            }
        }
        return false;
    }

}
