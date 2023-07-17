package ltcd.binarySearchExercise.minimizeMaximumValue_or_MaximizeMin;

import java.util.Arrays;

public class _2517_礼盒的最大甜蜜度_ {

    public static void main(String[] args) {
        _2517_礼盒的最大甜蜜度_ v = new _2517_礼盒的最大甜蜜度_();
        v.maximumTastiness(new int[] {13,5,1,8,21,2}, 3);
    }

    public int maximumTastiness(int[] price, int k) {
        // 排序，二分的前提
        Arrays.sort(price);

        // 甜蜜度一定在 [0, (max - min) / k] 区间内
        int left = 0;
        int right = (price[price.length - 1] - price[0]) / (k - 1) + 1;

        while (left + 1 < right) {
            // 循环不变量
            int mid = (right - left) / 2 + left;
            if (f(price, mid) >= k) {
                // 下一轮搜索区间：(mid, right)
                left = mid;
            } else {
                // 下一轮搜索区间：(left, mid)
                right = mid;
            }
        }

        return left;
    }

    private int f(int[] price, int d) {
        int cnt = 1;
        int pre = price[0];

        for (int cur : price) {
            if (cur >= pre + d) {
                // 如果当前糖果值和上一个至少相差了 d，则可以在取这颗糖
                pre = cur;
                // 取到的糖果数量 +1
                cnt++;
            }
        }

        // 返回从数组 0 开始，按照元素间最小间隔为 d 从小到大取数，能去出多少个数
        return cnt;
    }

}
