package ltcd.intervalExercise;

import java.util.Arrays;
import java.util.Comparator;

public class _435_无重叠区间 {

    public int eraseOverlapIntervals(int[][] intervals) {
        // 按照结束时间升序排序
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        // 至少有一个区间不相交
        int count = 1;
        // 记录排序后的第一个区间的结束时间end
        int end = intervals[0][1];

        // 从第二个开始，遍历区间
        for (int i = 1; i < intervals.length; i++) {
            // 如果 end < 当前区间的 start，说明这两个区间有交集，
            if (end <= intervals[i][0]) {
                count++;
                // 更新 end
                end = intervals[i][1];
            }
        }

        // 删除相交区间数 = 总区间数 - 不相交区间的数
        return intervals.length - count;
    }

}
