package ltcd.sort;

/**
 * 从待排序的序列[begin, end]中找一个轴点（比如默认第一个beging），然后将改数据value拷贝出来，
 * 大于轴点的数据放在轴点后面，小于等于轴点的放在左边,得到序列：[小于等于轴点的序列] ∪ [轴点数] ∪ [大于轴点的数]
 */
public class QuickSort {

    public void QuickSort(int[] nums) {
        recur(nums, 0, nums.length - 1);
    }

    private void recur(int[] nums, int begin, int end) {
        if (begin >= end) return;

//        int value = nums[begin];未优化
        //优化，随机挑选轴点
        swap(begin, begin + (int)(Math.random() * (end - begin)), nums);
        int value = nums[begin];
        int left = begin;
        int right = end;

        //先从从右往左扫描，将数据序列变成：[小于等于轴点的序列] ∪ [垃圾数据] ∪ [大于轴点的数]
        while (begin < end) {//先从右往左扫描，遇见交换数据之后，交换方向
            while (begin < end) {
                if (nums[end] > value) {//如果扫描到的数大于轴点数据，将扫描指针右移
                    end--;
                } else if (nums[end] <= value){//如果扫描到的数据小于等于轴点数据，将扫描到的数据和begin指向的数据进行交换
                    nums[begin++] = nums[end];
                    break;
                }
            }
            while (begin < end) {
                if (nums[begin] < value) {//如果扫描到的数大于轴点数据，将扫描指针右移
                    begin++;
                } else if (nums[begin] >= value){//如果扫描到的数据小于等于轴点数据，将扫描到的数据和begin指向的数据进行交换
                    nums[end--] = nums[begin];
                    break;
                }
            }
        }

        //将轴点数据填充回序列[小于等于轴点的序列] ∪ [轴点数] ∪ [大于轴点的数]
        nums[begin] = value;

        //递归对[小于等于轴点的序列] 和 [大于轴点的数]进行排序
        recur(nums, left, begin - 1);
        recur(nums, begin + 1, right);
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
