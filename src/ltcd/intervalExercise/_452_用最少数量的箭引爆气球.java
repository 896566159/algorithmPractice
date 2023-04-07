package ltcd.intervalExercise;

import java.util.Arrays;

public class _452_用最少数量的箭引爆气球 {

    public int findMinArrowShots(int[][] points) {
        int ans = 0;

        // 按照end升序排序
        Arrays.sort(points, (a, b)->{
            return a[1] != b[1] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]);
        });
        // 无交集的区间数量
        int count = 1;
        int end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            // 如果当前区间的 start > 前一个区间的end,表示有前一个区间和当前区间没有交集
            if (points[i][0] > end) {
                count++;
                // 更新end
                end = points[i][1];
            }
        }

        return points.length - count;
    }

}
