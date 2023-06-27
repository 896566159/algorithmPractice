package ltcd.preSum;

import java.util.HashMap;
import java.util.Map;

public class _525_连续数组_ {

    public static void main(String[] args) {
        _525_连续数组_ v = new _525_连续数组_();
        System.out.println(v.findMaxLength(new int[]{0, 1, 0}));
    }

    public int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int preSum = 0;

        // 统计,遇0减一，遇1加一
        for (int i = 0; i < n; i++) {
            preSum += nums[i] == 0 ? -1 : 1;

            // 如果在前面的统计结果中有和当前结果一样的值，说明在这中间的 0 、 1 数量相同
            if (map.containsKey(preSum)) {
                max = Math.max(i - map.get(preSum), max);
            } else {
                map.put(preSum, i);
            }
        }

        return max;
    }

}
