package ltcd.slidingWindowExercise;

public class _2134_最少交换次数来组合所有的1_II_ {

    public int minSwaps(int[] nums) {
        int count = 0;
        // 统计有多少个 1
        for (int num : nums) {
            count += num;
        }

        // 开一个大小为 count 的窗口，统计窗口中最多能有多少个 1
        int right = 0;
        int n = nums.length;
        int window = 0;
        while (right < n) {
            window += nums[right++];
        }

        int left = 0;
        int max = window;
        // 因为是循环数组，所以窗口的左边界需要一直移动到数组尾部才结束
        while (left < n) {
            window -= nums[left++ % n];
            window -= nums[right++ % n];
            max = Math.max(max, window);
        }

        return count - max;
    }

}
