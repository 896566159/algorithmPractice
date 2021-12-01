package ltcd;

public class _35_搜索插入位置 {

    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int start, int end) {
        if (start == end) {
            return start;
        }

        int mid = start + (end - start) / 2;
        if (nums[mid] > target) {
            return binarySearch(nums, target, start, mid - 1);
        } else if (nums[mid] < target) {
            return binarySearch(nums, target, mid + 1, end);
        } else {
            return nums[mid];
        }
    }

}
