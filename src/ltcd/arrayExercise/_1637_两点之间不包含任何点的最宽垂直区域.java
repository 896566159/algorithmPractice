package ltcd.arrayExercise;

import java.util.Arrays;

public class _1637_两点之间不包含任何点的最宽垂直区域 {

    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a, b)->{
            return a[0] - b[0];
        });
        int ans = 0;

        for (int i = 1; i < points.length; i++) {
            ans = Math.max(points[i][0] - points[i - 1][0], ans);
        }

        return ans;
    }

}
