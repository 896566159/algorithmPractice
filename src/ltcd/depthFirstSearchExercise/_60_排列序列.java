package ltcd.depthFirstSearchExercise;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _60_排列序列 {

    int stop = 0;
    int count = 0;

    public String getPermutation(int n, int k) {
        if (n == 1) {
            return "1";
        }

        List<String> permutation = new LinkedList<>();
        StringBuffer path = new StringBuffer();
        boolean[] used = new boolean[n];
        stop = k - 1;

        dfs(n, 1, 0, used, path, permutation);

        System.out.println(permutation.size());
        return permutation.get(k - 1);
    }

    private void dfs(int n, int begin, int depth, boolean[] used, StringBuffer path, List<String> permutation) {
        if (count++ > stop) {
            return;
        }

        if (depth == n) {
            permutation.add(path.toString());
            System.out.println("******" + path);
            return;
        }

        for (int i = begin; i <= n; i++) {
            if (used[i - 1]) {
                continue;
            }

            path.append(i);
//            path.add(i);
            used[i - 1] = true;

            dfs(n, begin, depth + 1, used, path, permutation);

            used[i - 1] = false;
            path.deleteCharAt(path.length() - 1);
//            path.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new _60_排列序列().getPermutation(9, 200));
    }

}
