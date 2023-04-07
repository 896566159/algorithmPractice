package ltcd.intervalExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _57_插入区间 {

    public static void main(String[] args) {
        _57_插入区间 v = new _57_插入区间();
        v.insert(new int[][]{{1,3}, {6,9}}, new int[] {2,5});
    }

    /**
     * 借助额外的空间
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        // 没有重叠区间的数组
        int[][] ans = new int[n + 1][2];
        int index = 0;

        // 将newInterval插入intervals中，并排序
        List<int[]> ints = new ArrayList<>();
        for (int[] interval : intervals) {
            ints.add(interval);
        }
        ints.add(newInterval);

        Collections.sort(ints, (a, b)->a[0] - b[0]);

        int end = ints.get(0)[1];
        int start = ints.get(0)[0];
        for (int[] arr : ints) {
            // 当前区间和前一个区间有交集
            if (arr[0] <= end) {
                end = Math.max(end, arr[1]);
            } else {
                // 当前区间和前一个区间无交集
                ans[index++] = new int[]{start, end};
                end = arr[1];
                start = arr[0];
            }
        }
        // 最后一个区间也需要添加没有重叠区间的数组
        ans[index++] = new int[]{start, end};

        return Arrays.copyOf(ans, index + 1);
    }

}
