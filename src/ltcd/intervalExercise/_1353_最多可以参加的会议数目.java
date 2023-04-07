package ltcd.intervalExercise;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _1353_最多可以参加的会议数目 {

    // 无重叠的区间的都可以参加——无条件
    // 重叠的区间也可以都参加——有条件
    public int maxEvents(int[][] events) {
        //[[1,2],[1,2],[3,3],[1,5],[1,5]]
        Arrays.sort(events, (a, b)->a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        int d = 0;
        int i = 0;
        int res = 0;
        int n = events.length;
        int max = events[n - 1][1];

        // 按照时刻遍历
        while (d <= max) {
            d++;
            // 1.将当前时间点开始的会议加入小根堆
            // [start, end] 区间都 <= d 的加入小根堆
            while (i < n && events[i][0] <= d && d <= events[i][1]) {
                pq.add(events[i]);
                i++;
            }

            // 2.再把当前已经结束的会议移出小根堆
            // end < d 的移出小根堆
            while (!pq.isEmpty() && pq.peek()[1] < d) {
                pq.poll();
            }

            // 3.从剩下的会议中选择一个结束时间最早的去参加(贪心 + 优先队列实现)
            if (!pq.isEmpty()) {
                pq.poll();
                res++;
            }
        }

        return res;
    }

}
