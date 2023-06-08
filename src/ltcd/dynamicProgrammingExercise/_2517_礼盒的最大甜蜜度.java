package ltcd.dynamicProgrammingExercise;

import java.util.Arrays;

public class _2517_礼盒的最大甜蜜度 {

    public static void main(String[] args) {
        _2517_礼盒的最大甜蜜度 v = new _2517_礼盒的最大甜蜜度();
        System.out.println(v.maximumTastiness(new int[]{21, 5, 8, 1}, 3));
    }

    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);

        int left = 0;
        int right = (price[price.length - 1] - price[0]) / (k - 1) + 1;

        // 开区间
        while (left + 1 < right) {
            // 循环不变量
            int mid = (right - left) / 2 + left;
            if (f(price, mid) >= k) {
                // 一下轮二分范围：(mid, right)
                left = mid;
            } else {
                // 一下轮二分范围：(left, mid)
                right = mid;
            }
        }

        return left;
    }

    private int f(int[] price, int d) {
        int cut = 1;
        int pre = price[0];

        for (int p : price) {
            if (p >= pre + d) {
                cut++;
                pre = p;
            }
        }

        return cut;
    }

}
