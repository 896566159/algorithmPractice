package ltcd.slidingWindowExercise;

public class _209_长度最小的子数组 {

    public static void main(String[] args) {
        _209_长度最小的子数组 v = new _209_长度最小的子数组();
        System.out.println(v.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    public int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int right = 0;
        int length = nums.length;
        int ans = Integer.MAX_VALUE;
        int sum = 0;

        while (right < length) {
            sum += nums[right];
            right++;

            while (sum >= target) {
                sum -= nums[left];
                left++;
                ans = Math.min(ans, right - left + 1);
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

}
