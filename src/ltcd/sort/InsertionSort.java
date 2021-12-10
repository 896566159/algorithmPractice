package ltcd.sort;

/**
 * 默认数组第一个数据有序，把下标大于等于1的当左需要插入有序的新牌
 * 是稳定排序
 * ① 在执行过程中，插入排序会将序列分为2部分
 *      ✓ 头部是已经排好序的，尾部是待排序的
 * ② 从头开始扫描每一个元素
 *      ✓ 每当扫描到一个元素，就将它插入到头部合适的位置，使得头部数据依然保持有序
 */
public class InsertionSort {

    public void InsertionSort(int[] nums) {
//        for (int begin = 1; begin < nums.length; begin++) {//未优化
//            int cur = begin;
//            while (cur > 0 && nums[cur - 1] > nums[cur]) {//如果带插入的数据比有序的尾巴大，交换
//                swap(nums, cur, --cur);
//            }
//        }

        //使用二分查找找到需要插入的位置，将牌插进去。---优化
        for (int begin = 1; begin < nums.length; begin++) {
            intsert(nums, begin, search(nums, begin));
        }
    }

    private void intsert(int[] nums, int searchIndex, int insertIndex) {
        int value = nums[searchIndex];
        while (searchIndex > insertIndex) {
            nums[searchIndex] = nums[--searchIndex];
        }
        nums[insertIndex] = value;
    }

    private int search(int[] nums, int index) {
        int begin = 0;
        int end = index;

        while (begin < end) {
            int mid = (end + begin) >> 1;

            if (nums[mid] > nums[index]) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }

        return begin;
    }

    //optimization
    public void InsertionSort1(int[] nums) {
        for (int begin = 1; begin < nums.length; begin++) {
            int cur = begin;
            int tmp= nums[cur];
            while (cur > 0 && nums[cur - 1] > tmp) {
                nums[cur] = nums[cur - 1];
                cur--;
            }
            nums[cur] = tmp;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

}
