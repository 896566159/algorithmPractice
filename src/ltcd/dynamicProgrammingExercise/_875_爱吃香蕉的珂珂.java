package ltcd.dynamicProgrammingExercise;

import ltcd.backtrackingExecise._87_扰乱字符串;

import java.util.Arrays;

public class _875_爱吃香蕉的珂珂 {

    public static void main(String[] args) {
        _875_爱吃香蕉的珂珂 v = new _875_爱吃香蕉的珂珂();
        System.out.println(v.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
    }

    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);

        // 如果 h = piles.length，则最小速度等于最多的那一堆香蕉数量
        int right = piles[piles.length - 1];
        // 如果 h >= piles.length，则最小速度等于 0
        int left = piles[0];

        // 二分：[left, right]
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (f(piles, mid, h)) {
                // 可以在 mid 的速度下吃完，继续下一轮二分 (mid, right)
                right = mid;
            } else {
                // 速度为 mid, 无法在 h 小时内吃完，下一轮范围 (left, mid)
                left = mid;
            }
        }

        return right;
    }

    private boolean f(int[] piles, int d, int h) {

        for (int pile : piles) {
            while (pile > 0) {
                pile -= d;
                h--;
            }

            if (h < 0) {
                return false;
            }
        }

        return h >= 0;
    }

}
