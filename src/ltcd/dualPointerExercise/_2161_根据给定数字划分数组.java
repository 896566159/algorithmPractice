package ltcd.dualPointerExercise;

public class _2161_根据给定数字划分数组 {

    public int[] pivotArray(int[] nums, int pivot) {
        int length = nums.length;
        int left = 0;
        int count = 0;
        int right = length - 1;
        int[] ans = new int[length];

        // 小于
        for (int i = 0; i < length; i++) {
            if (nums[i] < pivot) {
                ans[left++] = nums[i];
            }
            // 等于
            if (nums[i] == pivot) {
                count++;
            }
        }

        // 等于
        while (count-- > 0) {
            ans[left++] = pivot;
        }

        // 大于
        for (int i = 0; i < length; i++) {
            if (nums[i] > pivot) {
                ans[left++] = nums[i];
            }
        }

        return nums;
    }

}
