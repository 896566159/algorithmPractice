package ltcd.sort;

/**
 * ① 对序列进行原地建堆（heapify）
 * ② 重复执行以下操作，直到堆的元素数量为 1
 *         ✓ 交换堆顶元素与尾元素
 *         ✓ 堆的元素数量减 1
 *         ✓ 对 0 位置进行 1 次 siftDown 操作
 */
public class HeapSort {
    int heapSize;

    public void HeapSort(int[] nums) {
        heapSize = nums.length;

        //initial heap,root is the nums[nums.length/2 - 1]
        for (int i = (heapSize >> 1) - 1; i >= 0; i--) {
            shiftDown(nums, i);
        }

        //不停的交换队顶和尾部元素
        while (heapSize > 1) {
            swap(nums, 0, --heapSize);

            //调整堆结构，让堆恢复成大根堆
            shiftDown(nums, 0);
        }
    }

    private void shiftDown(int[] nums, int index) {
        int element = nums[index];
        int half = heapSize >> 1;

        while (index < half) {// index必须是非叶子节点
            int childIndex = (index << 1) + 1;//默认是左边跟父节点比较
            int child = nums[childIndex];
            int rightChildIndex = (index << 1) + 2;//没有左孩子就和右孩子比较
            //右节点比左节点大
            if (rightChildIndex < heapSize && nums[rightChildIndex] > child) {
                child = nums[childIndex = rightChildIndex];
            }

            //大于等于子节点,符合大根堆条件，直接停止循环
            if (element >= child) break;

            nums[index] = child;
            index = childIndex;
        }
        nums[index] = element;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] =  tmp;
    }
}
