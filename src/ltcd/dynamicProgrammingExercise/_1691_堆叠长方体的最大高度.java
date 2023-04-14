package ltcd.dynamicProgrammingExercise;

import java.util.Arrays;

public class _1691_堆叠长方体的最大高度 {

    public static void main(String[] args) {
        _1691_堆叠长方体的最大高度 v = new _1691_堆叠长方体的最大高度();
        v.maxHeight(new int[][]{{38,25,45},{76,35,3}});
    }

    public int maxHeight(int[][] cuboids) {
        // 对于每块积木，长宽高进行排序，让最长的一边作为高
        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }

        // 按照积木的长、宽、高进行排序
        Arrays.sort(cuboids, (a, b)->{
            if (a[0] == b[0]) {
                if (a[1] == b[1]) {
                    return Integer.compare(a[2], b[2]);
                } else {
                    return Integer.compare(a[1], b[1]);
                }
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });

        int length = cuboids.length;
        int maxHeight = 0;
        int[] dp = new int[length];


        for (int i = 0; i < length; i++) {

            // 遍历 i 的，找出最长升序
            for (int j = 0; j < i; j++) {

                // 排序后，cuboids[j][0] <= cuboids[i][0] 恒成立
                if (cuboids[i][1] >= cuboids[j][1] && cuboids[i][2] >= cuboids[j][2]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }

            // 加上自身的高度
            dp[i] += cuboids[i][2];
            // 更新答案
            maxHeight = Math.max(dp[i], maxHeight);
        }

        return maxHeight;
    }

}
