package ltcd.sort;

public class _912_排序数组 {

    public int[] sortnums(int[] nums) {
        boolean flag = false;

        for (int end = nums.length - 1; end > 0; end--) {
            for (int j = 1; j <= end; j++) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                    flag = false;
                } else {
                    flag = true;
                }
            }

            if (flag) {
                break;
            }
        }

        return nums;
    }

    private void swap(int[] nums, int j, int i) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
    
}
