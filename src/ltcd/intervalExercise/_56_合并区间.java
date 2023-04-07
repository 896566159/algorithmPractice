package ltcd.intervalExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _56_合并区间 {

    public static void main(String[] args) {
        _56_合并区间 v = new _56_合并区间();
//        v.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
        v.merge(new int[][]{{1,4},{2,3}});
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        int[][] res = new int[ans.size()][2];
        Arrays.sort(intervals, (a, b)->a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        int end = intervals[0][1];
        int start = intervals[0][0];

        for (int i = 1; i < intervals.length; i++) {
            // 有重叠，则继续更新右边界end
            if (intervals[i][0] < end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                // 当前区间和之前的区间不重叠，则可将之前的重叠区间合并成为一个
                ans.add(new int[]{start, end});
                // 更新新的左右边界
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        // 将最后一个区间也添加
        ans.add(new int[]{start, end});

        res = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }
    
}
