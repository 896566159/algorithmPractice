package ltcd.sort;

/**
 * ① 不断地将当前序列平均分割成2个子序列
 *     ✓ 直到不能再分割（序列中只剩1个元素）
 * ② 不断地将2个子序列合并成一个有序序列
 *     ✓ 直到最终只剩下1个有序序列
 */

public class MergeSort {

    public void MergeSort(int[] nums) {
        int[] leftArray = new int[nums.length >> 1];
        sort(nums,leftArray, 0, nums.length);
    }

    //对[begin, end)进行归并排序
    private void sort(int[] nums, int[] leftArray, int begin, int end) {
        if (end - begin < 2) {
            return;
        }

        int mid = (begin + end) >> 1;
        sort(nums, leftArray, begin, mid);
        sort(nums, leftArray, mid, end);

        merge(nums, leftArray, begin, mid, end);
    }

    //将[begin, mid), [mid, end)合并成一个有序的序列
    private void merge(int[] nums, int[] leftArray, int begin, int mid, int end) {
        int leftIndex= 0;
        int leftLen = mid - begin;//left array: [begin, mid)
        int rightIndex = mid;
        int rightLen = end;//right array: [mid, end)
        int index = begin;//nums's index

        for (int i = leftIndex; i < leftLen; i++) {//copy the left array to the help array
            leftArray[i] = nums[begin + i];
        }

        while (leftIndex < leftLen) {//如果左边的数据全部比较完了，直接结束，因为右边的数据的位置本来就是升序的
            if (rightIndex < rightLen && nums[rightIndex] < leftArray[leftIndex]) {//if change from < to <=,will not stable
                nums[index++] = nums[rightIndex++];
            } else {
                nums[index++] = leftArray[leftIndex++];
            }
        }
    }

}
