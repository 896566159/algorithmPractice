package ltcd.sort;

public class SelectionSort {


//    ① 从序列中找出最大的那个元素，然后与最末尾的元素交换位置
//    ✓ 执行完一轮后，最末尾的那个元素就是最大的元素
//    ② 忽略 ① 中曾经找到的最大元素，重复执行步骤 ①
    public void SelectionSort(int[] nums) {

        for (int end = nums.length - 1; end > 1; end--) {
            int maxIdx = end;
            for (int begin = 1; begin < end; begin++) {
                if (nums[begin] > nums[begin - 1]) {
                    maxIdx = begin;
                }
            }

            swap(nums, maxIdx, end);
        }

    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

}
