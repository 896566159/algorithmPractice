package ltcd.sort;

public class BubbleSort {

//    ① 从头开始比较每一对相邻元素，如果第1个比第2个大，就交换它们的位置
//    ✓ 执行完一轮后，最末尾那个元素就是最大的元素
//    ② 忽略 ① 中曾经找到的最大元素，重复执行步骤 ①，直到全部元素有序

    public void BubbleSort(int[] nums) {
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
    }

    private void swap(int[] array, int j, int i) {
        int tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
    }

}
