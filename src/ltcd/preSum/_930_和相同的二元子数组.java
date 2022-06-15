package ltcd.preSum;

import java.util.HashMap;

public class _930_和相同的二元子数组 {

    public int numSubarraysWithSum(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }

        int preSum = 0;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num: nums) {
            preSum += num;
            if (map.containsKey(preSum - k)) {
                ans += map.get(preSum - k);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        return ans;
    }

}
