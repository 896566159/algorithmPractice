package ltcd.mathExercise;

/**
 * 从后往前找出逆序数对(i, j)，从[j, len - 1]区间找出一个最大的且小于 arr[i]的数。交换
 */
public class _1053_交换一次的先前排列 {

    public static void main(String[] args) {
        _1053_交换一次的先前排列 v = new _1053_交换一次的先前排列();
        v.prevPermOpt1(new int[] {1,9,4,6,7});
    }

    public int[] prevPermOpt1(int[] arr) {
        int len = arr.length;
        int x = -1;
        int y = -1;
        int max = Integer.MIN_VALUE;

        for (int i = len - 1; i > 0; i--) {
            // 出现逆序对
            if (arr[i - 1] > arr[i]) {
                // 记录下逆序数对的左边元素
                x = i - 1;
                break;
            }
        }

        // arr数组是升序的，是最小的字典数直接返回
        if (x == -1) {
            return arr;
        }

        // 寻找在 [x, len - 1]区间最大且小于 arr[x] 的元素
        for (int i = x + 1; i < len; i++) {
            // 首先要小于 arr[x]，其次该元素要是最大的
            if (arr[x] > arr[i] && arr[i] > max) {
                max = arr[i];
                // 记录下该元素的位置
                y = i;
            }
        }

        // 交换 nums[x] nums[y]
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;

        return arr;
    }

}
