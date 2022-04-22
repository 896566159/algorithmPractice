package ltcd.dualPointerExercise;

public class _27_移除元素 {

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int ans = 0;
        int last = nums.length;

        for (int i = 0; i < last; i++) {
            if (nums[i] == val) {
                swap(nums, i, last - 1);
                ans = --last;
                i--;
            }
        }

        return ans;
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[j] + nums[i];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }

}
