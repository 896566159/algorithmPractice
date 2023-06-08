package ltcd.unionFindExercise;

public class _剑指_OfferII_113_课程顺序 {

    int[] parent;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        parent = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            parent[i] = i;
        }

        for (int[] prerequisite : prerequisites) {
            if (!merge(prerequisite[0], prerequisite[1])) {
                return new int[0];
            }
        }

        return order;
    }

    private boolean merge(int a, int b) {
        if (a == b) {
            return true;
        }

        if (parent[a] == b) {
            return false;
        }

        parent[b] = a;
        return true;
    }

}
