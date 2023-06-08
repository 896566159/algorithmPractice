package ltcd.slidingWindowExercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _2461_长度为_K_子数组中的最大和 {

    public static void main(String[] args) {
        _2461_长度为_K_子数组中的最大和 v = new _2461_长度为_K_子数组中的最大和();
        System.out.println(v.maximumSubarraySum(new int[]{1, 5, 4, 2, 9, 9, 9}, 3));
        System.out.println(v.maximumSubarraySum(new int[]{9, 9, 9}, 3));
        System.out.println(v.maximumSubarraySum(new int[]{9,9,9,1,2,3}, 3));
    }

    public long maximumSubarraySum(int[] nums, int k) {
        int left = 0;
        int right = 0;
        Map<Integer, Integer> valCount = new HashMap<>();
        long sum = 0;
        long max = 0;

        while (right < k - 1) {
            valCount.put(nums[right], valCount.getOrDefault(nums[right], 0) + 1);
            sum += nums[right];
            right++;
        }


        while (right < nums.length) {
            sum += nums[right];
            valCount.put(nums[right], valCount.getOrDefault(nums[right], 0) + 1);

            if (valCount.size() == k) {
                max = Math.max(max, sum);
            }

            sum -= nums[left];
            if (valCount.get(nums[left]) == 1) {
                valCount.remove(nums[left]);
            } else {
                valCount.put(nums[left], valCount.getOrDefault(nums[left], 0) - 1);
            }
            right++;
            left++;
        }

        return max;
    }

}
