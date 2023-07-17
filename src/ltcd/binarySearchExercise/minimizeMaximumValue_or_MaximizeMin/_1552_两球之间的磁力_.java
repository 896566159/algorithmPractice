package ltcd.binarySearchExercise.minimizeMaximumValue_or_MaximizeMin;

import java.util.Arrays;

public class _1552_两球之间的磁力_ {

    public int maxDistance(int[] position, int m) {
        // 排序，二分的前提
        Arrays.sort(position);

        // 磁力一定在区间 [0, (max-min)/m] 之间
        int left = 0;
        int right = (position[position.length - 1] - position[0]) / (m - 1) + 1;

        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (f(position, mid) >= m) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private int f(int[] position, int distance) {
        int cnt = 1;
        int pre = position[0];

        for (int cur : position) {
            // 如果当前元素和上一个元素之间相隔至少 distance 的距离，说明这里可取当前元素
            if (cur >= pre + distance) {
                cnt++;
                pre = cur;
            }
        }

        return cnt;
    }

}
