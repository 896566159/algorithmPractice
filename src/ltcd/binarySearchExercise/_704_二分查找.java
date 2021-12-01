package ltcd.binarySearchExercise;

public class _704_二分查找 {

    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
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
