package ltcd.greedyExercise;

import java.util.Arrays;

public class _面试题_17_08_马戏团人塔_ {
    public static void main(String[] args) {
//        System.out.println(new _面试题_17_08_马戏团人塔_().bestSeqAtIndex(new int[] {65,70,56,75,60,68}, new int[] {100,150,90,190,95,110}));
        System.out.println(new _面试题_17_08_马戏团人塔_().bestSeqAtIndex(new int[] {5,6,6,2}, new int[] {4,4,7,3}));
    }

    public int bestSeqAtIndex(int[] height, int[] weight) {
        int n = height.length;
        int[][] person = new int[n][2];

        for (int i = 0; i < n; i++) {
            person[i] = new int[]{height[i], weight[i]};
        }

        // 身高相同，体重降序
        Arrays.sort(person, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 0;

        for (int[] per : person) {
            int left = 0;
            int right = res;

            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (dp[mid] < per[1]) {  // 要找的是dp数组中第一个小于当前h的位置
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            dp[left] = per[1];
            if (res == left) {
                res++;
            }
        }
        return res;
    }

}
