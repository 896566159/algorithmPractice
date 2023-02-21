package ltcd.greedyExercise;

import java.util.Arrays;
import java.util.Comparator;

public class _452_用最少数量的箭引爆气球 {

    public static void main(String[] args) {
        new _452_用最少数量的箭引爆气球().findMinArrowShots(new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}});
    }

    public int findMinArrowShots(int[][] points) {

        int ans = 1;
        int preEndX = points[0][1];

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] point1, int[] point2) {
                if (point1[1] == point2[1]) {
                    return Integer.compare(point1[0], point2[0]);
                } else {
                    return Integer.compare(point1[1], point2[1]);
                }
            }
        });

        preEndX = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > preEndX) {
                ans++;
                preEndX = points[i][1];
            }
        }



        return ans;
    }

}
