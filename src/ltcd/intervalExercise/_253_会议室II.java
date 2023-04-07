package ltcd.intervalExercise;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 开会也可以理解成坐公交，都是占用某个资源。 就拿题目给的第一组数组来分析。
 * intervals = [[0,30],[5,10],[15,20]]
 * 第一个人从0上车，从30下车； 第二个人从5上车，10下车。。。
 * 我们的问题转化为最多车上有几个人（也就是最多有多少会议室）。
 * 显然：上车，车上人数+1；下车，车上人数-1 我们把intervals拆解一下
 *
 * 上车：[0, 1], [5, 1], [15, 1]
 * 下车：[10, -1], [20, -1], [30, -1]
 *
 * 然后按照第一个数把上下车排好序
 * 人数 1    2     1     2     1      0
 *      0----5----10----15----20-----30
 * 变化 +1   +1    -1    +1    -1    -1
 *
 * 本质：求解某一时刻重叠的区间数量
 */
public class _253_会议室II {
    public static void main(String[] args) {
        _253_会议室II v = new _253_会议室II();
//        v.minMeetingRooms(new int[][]{{0, 30}, {20, 30}, {10, 15}});
        v.minMeetingRooms(new int[][]{{2,11}, {6,16},{11,16}});
    }

    // 使用双指针
    public int minMeetingRooms1(int[][] intervals) {
        int max = 0;
        int count = 0;
        int n = intervals.length;
        // 会议开始的时间点,表示上车
        int[] begin = new int[n];
        // 会议开始的时间点，表示下车
        int[] end = new int[n];
        // 指针
        int x = 0;
        int y = 0;

        for (int i = 0; i < n; i++) {
            begin[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        // 根据时间升序进行排序
        Arrays.sort(begin);
        Arrays.sort(end);

        while (x < n && y < n) {
            // 先扫描到 start
            if (begin[x] < end[y]) {
                count++;
                x++;
            } else {
                count--;
                y++;
            }

            max = Math.max(max, count);
        }

        return max;
    }

    // 使用优先队列
    public int minMeetingRooms(int[][] intervals) {

        int max = 0;
        int count = 0;
        // 按照start时间点升序
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
//            return Integer.compare(a[0], b[0]);
            // 时间点相同：先下后上
            return a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]);
        });

        // 上下车
        for (int[] interval : intervals) {
            // 上车，车上人数+1
            pq.add(new int[]{interval[0], 1});
            // 下车，车上人数-1
            pq.add(new int[]{interval[1], -1});
        }

        while (!pq.isEmpty()) {
            count += pq.poll()[1];
            max = Math.max(max, count);
        }

        return max;
    }

}
