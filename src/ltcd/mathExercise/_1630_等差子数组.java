package ltcd.mathExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1630_等差子数组 {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList(l.length);
        int[][] numAndIndex = new int[nums.length][2];

        // 遍历，将数组和数组的元素绑定
        for (int i = 0; i < nums.length; i++) {
            numAndIndex[i] = new int[]{nums[i], i};
        }

        Arrays.sort(numAndIndex, (a, b) -> {
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        });

        for (int i = 0; i < l.length; i++) {
            int left = l[i];
            int right = r[i];

            if (right - left <= 1) {
                ans.add(right - left == 1);
                continue;
            }

            // 遍历
            boolean flag = true;
            boolean first = true;
            boolean second = true;
            int pre = 0;
            int diff = 0;
            int count = right - left + 1;
            // 找到属于 [left, right] 区间之内的数
            for (int j = 0; j < numAndIndex.length && count > 0; j++) {

                if (!second && numAndIndex[j][0] - pre > diff) {
                    flag = false;
                    break;
                }

                if (numAndIndex[j][1] <= right && numAndIndex[j][1] >= left) {
                    if (first) {
                        first = false;
                    } else {
                        if (second) {
                            diff = numAndIndex[j][0] - pre;
                            second = false;
                        } else {
                            if (numAndIndex[j][0] - pre != diff) {
                                flag = false;
                                break;
                            }
                        }
                    }

                    count--;
                    pre = numAndIndex[j][0];
                }
            }

            ans.add(flag);
        }

        return ans;
    }

}
