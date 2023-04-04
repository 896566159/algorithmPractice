package ltcd.mathExercise;

public class _31_下一个排列 {

    public static void main(String[] args) {
        _31_下一个排列 v = new _31_下一个排列();
        v.nextPermutation(new int[]{1,3,2});
    }

    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int x = 0;
        int y = 0;
        int tmp = 0;

        // 从后往前找找出第一对降序的、紧挨着的数对
        for (int i = length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                x = i - 1;
                break;
            }
        }

        // 从后往前找找出第一个 大于 上面找出来的数
        for (int i = length - 1; i >= x; i--) {
            if (nums[i] > nums[x]) {
                y = i;
                break;
            }
        }

        // nums 是非降序的，不存在逆序的数对，将 nums 翻转后返回
        if (x == 0 && y == 0) {
            y = length - 1;
            while (x < y) {
                tmp = nums[x];
                nums[x] = nums[y];
                nums[y] = tmp;
                x++;
                y--;
            }
            return;
        }

        // 交换 nums[x] nums[y]
        tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;

        // 将后面的数进行升序
        for (int i = x + 1; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] > nums[j]) {
                    tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }

}
