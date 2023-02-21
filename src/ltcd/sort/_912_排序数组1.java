package ltcd.sort;

public class _912_排序数组1 {

    public static void main(String[] args) {
        new _912_排序数组1().sortnums(new int[]{-2,3,-5});
    }

    public int[] sortnums(int[] nums) {

        mergeSort(0, nums.length, nums);
        return nums;
    }

    private void mergeSort(int left, int right, int[] nums) {
        if (right - left <= 1) {
            return;
        }

        int mid = (right + left) >> 1;
        mergeSort(left, mid, nums);
        mergeSort(mid, right, nums);

        merge(left, mid, right, nums);
    }

    /**
     * 归并两个有序数组
     * @param left
     * @param mid
     * @param right
     * @param nums
     */
    private void merge(int left, int mid, int right, int[] nums) {
        int[] help = new int[right - left];
        int index = 0;
        int among = mid;
        int start = left;

        while (left < among && mid < right) {

            if (nums[left] <= nums[mid]) {
                help[index++] = nums[left++];
            } else {
                help[index++] = nums[mid++];
            }

        }

        while (left < among) {
            help[index++] = nums[left++];
        }

        while (mid < right) {
            help[index++] = nums[mid++];
        }

        for (int i = 0; i < help.length; i++) {
            nums[start++] = help[i];
        }
    }

}
