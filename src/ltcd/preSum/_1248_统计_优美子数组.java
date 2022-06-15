package ltcd.preSum;

import java.util.HashMap;
import java.util.Map;

public class _1248_统计_优美子数组 {

    public int numberOfSubarrays1(int[] nums, int k) {
        // 数组 prefixCnt 的下标是前缀和（即当前奇数的个数），值是前缀和的个数。
        int[] prefixCnt = new int[nums.length + 1];
        prefixCnt[0] = 1;
        // 遍历原数组，计算当前的前缀和，统计到 prefixCnt 数组中，
        // 并且在 res 中累加上与当前前缀和差值为 k 的前缀和的个数。
        int res = 0, sum = 0;
        for (int num : nums) {
            sum += num & 1;
            prefixCnt[sum]++;
            if (sum >= k) {
                res += prefixCnt[sum - k];
            }
        }
        return res;
    }


    public int numberOfSubarrays(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int oddCount = 0;
        int leftOddCount = 0;//只对奇数做前缀和

        for (int num : nums) {

            leftOddCount += num % 2 == 0 ? 0 : 1;

            if (map.containsKey(leftOddCount - k)) {
                ans += map.get(leftOddCount - k);
            }

            map.put(leftOddCount, map.getOrDefault(leftOddCount, 0) + 1);

        }

        return ans;
    }

}
