package ltcd.dynamicProgrammingExercise;

import java.util.LinkedList;
import java.util.List;

public class _剑指_Offer_II_100_三角形中最小路径之和 {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) {
            return 0;
        }

        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }

        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= triangle.get(i - 1).size(); j++) {
                if (j == 1) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i - 1).get(j - 1);
                } else if (j == triangle.get(i - 1).size()) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i - 1).get(j - 1);
                } else {
                    int min = Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                    dp[i][j] = min + triangle.get(i - 1).get(j - 1);
                }
            }
        }

        int min = dp[m][0];
        for (int i = 1; i <= n; i++) {
            min = Math.min(dp[m][i], min);
        }

        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> l1 = new LinkedList<>();
        l1.add(2);

        List<Integer> l2 = new LinkedList<>();
        l2.add(3);
        l2.add(4);

        List<Integer> l3 = new LinkedList<>();
        l3.add(6);
        l3.add(5);
        l3.add(7);

        List<Integer> l4 = new LinkedList<>();
        l4.add(4);
        l4.add(1);
        l4.add(8);
        l4.add(3);

        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);

        new _剑指_Offer_II_100_三角形中最小路径之和().minimumTotal(list);
    }

}
