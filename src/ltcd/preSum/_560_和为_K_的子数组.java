package ltcd.preSum;

import java.util.HashMap;

public class _560_和为_K_的子数组 {

    public int subarraySum1(int[] nums, int k) {
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

    /**
     * 前缀和
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        int[] preSum = new int[length + 1];
        int ans = 0;
        preSum[0] = 0;//前缀和第一个元素初始化为零

        for (int i = 0; i < length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        //依次缩小区间：[0, length] [0, length - 1] [0, length - 2] ... [length - 1, length]
        for (int i = 0; i < length; i++) {

            //preSum 的下标比 nums 大 1
            //preSum[n] = preSum[n - 1] + nums[n] --> preSum[n] 是对nums中 [0, n - 1] 区间之和
            //preSum[j + 1] - preSum[i] 表示 nums 中 [i, j] 区间之和.其中：
                //preSum[j + 1] 是对 nums 中 [0, j] 区间之和
                //preSum[i] 是对 nums 中 [0, i - 1] 区间之和
            for (int j = i; j < length; j++) {
                if (preSum[j + 1] - preSum[i] == k) {
                    ans++;
                }
            }
        }

        return ans;
    }

}
