package ltcd.preSum;

import java.util.HashMap;
import java.util.Map;

public class _974_和可被_K_整除的子数组 {

    public int subarraysDivByK(int[] nums, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int ans = 0 ;
        int sum = 0;

        for (int num: nums) {
            sum += num;
            //当前 presum 与 K的关系，余数是几，当被除数为负数时取模结果为负数，需要纠正
            int key = (sum % K + K) % K;
            if (map.containsKey(key)) {
                ans += map.get(key);
            }
            map.put(sum, 1);
        }

        return ans;
    }

}
