package ltcd.slidingWindowExercise;

public class _219_存在重复元素II {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) {
            return false;
        }

        int[] slidingWindow = new int[k];
        int bound = 0;

        for (int i = 0; i < nums.length; i++) {
            int scope = bound < k ? bound : k;
            if (contains(nums[i], slidingWindow, bound)  && bound != 0) {
                return true;
            }

            slidingWindow[bound % k] = nums[i];
            bound++;
        }

        return false;
    }

    private boolean contains(int target, int[] slidingWindow, int scope) {
        for (int i = 0; i < scope; i++) {
            if (slidingWindow[i] == target) {
                return true;
            }
        }
        return false;
    }

}
