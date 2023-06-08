package ltcd.dynamicProgrammingExercise;

import java.util.Arrays;

public class _1240_铺瓷砖 {

    public static void main(String[] args) {
        _1240_铺瓷砖 v = new _1240_铺瓷砖();
        System.out.println(v.tilingRectangle(2, 3));
        System.out.println(v.tilingRectangle(5, 8));
        System.out.println(v.tilingRectangle(11, 13));
    }

    int res = Integer.MAX_VALUE;
    int a;
    int b;
    int[][] memo;
    public int tilingRectangle(int n, int m) {
        a = m;
        b = n;
        f(m, n);
        return res;
    }

    private int f(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (m == n) {
            return 1;
        }

        int ans = 0;
        int big = Math.max(m, n);
        int small = Math.min(m, n);
        // 选取的瓷砖的最多是 m * n 块边长为 1 的
        // 选取范围： [1, small]
        for (int i = 1; i <= small; i++) {
            if (small - i >= 0) {
                int recctangle1 = f(small - i, i);
                int recctangle2 = f(big - i, small);

                ans = 1 + recctangle1 + recctangle2;
                if ((a == m && b == n) || (a == n && b == m)) {
                    res = Math.min(res, ans);
                }
            }
        }

        return ans;
    }


    //这种方法的到的为结果不是最优的
//    public int tilingRectangle(int n, int m) {
//        if (m == 0 || n == 0) {
//            return 0;
//        }
//
//        int ans = 0;
//        int big = Math.max(m, n);
//        int small = Math.min(m, n);
//        int diff = big - small;
//        ans = tilingRectangle(small, diff) + 1;
//
//        return ans;
//    }

}
