package ltcd.intervalExercise;

import java.util.Arrays;

public class _436_寻找右区间 {

    public static void main(String[] args) {
        _436_寻找右区间 v = new _436_寻找右区间();
        v.findRightInterval(new int[][]{{3,4},{2,3},{1,2}});
//        v.findRightInterval(new int[][]{{1,1}, {3,4}});
    }

    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] ans = new int[n];

        // 拷贝一份 intervals
        int[][] intervalWithIndex = new int[n][3];
        for (int i = 0; i < n; i++) {
            intervalWithIndex[i][0] = intervals[i][0];
            intervalWithIndex[i][1] = intervals[i][1];
            intervalWithIndex[i][2] = i;
        }

        // 按照 start 升序排序
        Arrays.sort(intervalWithIndex, (a, b)->a[0] - b[0]);

        // 遍历
        for (int i = 0; i < n; i++) {
            int end = intervalWithIndex[i][1];
            int start = intervalWithIndex[i][0];
            int minStart = Integer.MAX_VALUE;
            int minIndex = -1;
            // [start, start]区间的最右侧区间是自己
            if (end == start) {
                ans[intervalWithIndex[i][2]] = intervalWithIndex[i][2];
                continue;
            }
            // 寻找右侧区间
//            for (int j = i + 1; j < n; j++) {
//                if (end <= intervalWithIndex[j][0] && minStart > intervalWithIndex[j][0]) {
//                    minStart = intervalWithIndex[j][0];
//                    minIndex = intervalWithIndex[j][2];
//                }
//            }
            // 利用二分查找来找出 >= start 的最左边的区间
            minIndex = binarySearch(end, i, intervalWithIndex);

            ans[intervalWithIndex[i][2]] = minIndex;
        }


        return ans;
    }

    /**
     * 从区间 [left, n)中 返回 大于等于target 的最小下标
     * @param target
     * @param start
     * @param intervalWithIndex
     * @return
     */
    private int binarySearch(int target, int start, int[][] intervalWithIndex) {
        int left = start;
        int right = intervalWithIndex.length;

        while (right > left) {
            int mid = left + ((right - left) >> 1);
            if (intervalWithIndex[mid][0] >= target) {
                // 区间缩小 [left, mid)
                right = mid;
            } else {
                // 区间缩小 [mid + 1, right)
                left = mid + 1;
            }
        }

        // [start, n)区间中的所有数都小于 target
        if (left == intervalWithIndex.length) {
            return -1;
        }

        // 区间变成了[left, right)，所以left和right指向同一个元素，返回left和right都行
        return intervalWithIndex[left][2];
    }

}
